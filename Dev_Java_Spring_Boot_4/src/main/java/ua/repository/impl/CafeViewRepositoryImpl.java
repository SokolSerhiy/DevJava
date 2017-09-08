package ua.repository.impl;

import static org.springframework.data.jpa.repository.query.QueryUtils.toOrders;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import ua.entity.Cafe;
import ua.entity.Cafe_;
import ua.entity.Meal;
import ua.entity.Meal_;
import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;
import ua.repository.CafeViewRepository;

@Repository
public class CafeViewRepositoryImpl implements CafeViewRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Page<CafeIndexView> findAll(CafeFilter filter, Pageable pageable) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CafeIndexView> cq = cb.createQuery(CafeIndexView.class);
		Root<Cafe> root = cq.from(Cafe.class);
		cq.multiselect(root.get(Cafe_.id), root.get("rate"), root.get("name"), root.get("photoUrl"), root.get("version"), root.get("address"), root.get("shortDescription"), root.get("type"));
		PredicateBuilder builder = new PredicateBuilder(filter, cb, root);
		Predicate predicate = builder.toPredicate();
		if(predicate!=null) cq.where(predicate);
		cq.orderBy(toOrders(pageable.getSort(), root, cb));
		List<CafeIndexView> content = em.createQuery(cq)
				.setFirstResult(pageable.getPageNumber())
				.setMaxResults(pageable.getPageSize())
				.getResultList();
		CriteriaQuery<Long> cqCount = cb.createQuery(Long.class);
		Root<Cafe> rootCount = cqCount.from(Cafe.class);
		cqCount.select(cb.count(rootCount));
		PredicateBuilder builderCount = new PredicateBuilder(filter, cb, root);
		Predicate predicateCount = builderCount.toPredicate();
		if(predicate!=null) cqCount.where(predicateCount);
		return PageableExecutionUtils.getPage(content, pageable, ()->em.createQuery(cqCount).getSingleResult());
	}
	
	private static class PredicateBuilder{
		
		final CafeFilter filter;
		
		final CriteriaBuilder cb;
		
		final Root<Cafe> root;
		
		final List<Predicate> predicates = new ArrayList<>();

		public PredicateBuilder(CafeFilter filter, CriteriaBuilder cb, Root<Cafe> root) {
			this.filter = filter;
			this.cb = cb;
			this.root = root;
		}
		
		void findByMinRate() {
			if(!filter.getMinRate().isEmpty()) {
				predicates.add(cb.ge(root.get("rate"), new BigDecimal(filter.getMinRate().replace(',', '.'))));
			}
		}
		
		void findByMaxRate() {
			if(!filter.getMaxRate().isEmpty()) {
				predicates.add(cb.le(root.get("rate"), new BigDecimal(filter.getMaxRate().replace(',', '.'))));
			}
		}
		
		void findByTypes() {
			if(!filter.getTypes().isEmpty()) {
				predicates.add(root.get("type").in(filter.getTypes()));
			}
		}
		
		void findByMeals() {
			if(!filter.getMealsIds().isEmpty()) {
				Join<Cafe, Meal> join = root.join(Cafe_.meals);
				predicates.add(join.get(Meal_.id).in(filter.getMealsIds()));
			}
		}
		
		Predicate toPredicate() {
			findByMinRate();
			findByMaxRate();
			findByTypes();
			findByMeals();
			return cb.and(predicates.stream().toArray(Predicate[]::new));
		}
	}
}
