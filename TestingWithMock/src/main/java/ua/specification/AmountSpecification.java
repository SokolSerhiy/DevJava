package ua.specification;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import ua.dto.filter.AmountFilter;
import ua.entity.Amount;

public class AmountSpecification implements Specification<Amount>{

	private final AmountFilter filter;
	
	private final List<Predicate> predicates = new ArrayList<>();
	
	private static final Pattern REG = Pattern.compile("^([0-9]{1,17}\\.[0-9]{1,2})|([0-9]{1,17}\\,[0-9]{1,2})|([0-9]{1,17})$");

	public AmountSpecification(AmountFilter filter) {
		this.filter = filter;
		if(REG.matcher(filter.getMax()).matches()){
			filter.setMaxValue(new BigDecimal(filter.getMax().replace(',', '.')));
		}
		if(REG.matcher(filter.getMin()).matches()){
			filter.setMinValue(new BigDecimal(filter.getMin().replace(',', '.')));
		}
	}
	
	private void findBySystem(Root<Amount> root, CriteriaQuery<?> query) {
		if(!filter.getSystemId().isEmpty()){
			predicates.add(root.get("system").in(filter.getSystemId()));
		}
	}
	
	private void findByIngredient(Root<Amount> root, CriteriaQuery<?> query) {
		if(!filter.getIngredientId().isEmpty()){
			predicates.add(root.get("ingredient").in(filter.getIngredientId()));
		}
	}
	
	private void findByAmount(Root<Amount> root, CriteriaQuery<?> query, CriteriaBuilder cb){
		if(filter.getMaxValue()!=null){
			predicates.add(cb.le(root.get("amount"), filter.getMaxValue()));
		}
		if(filter.getMinValue()!=null){
			predicates.add(cb.ge(root.get("amount"), filter.getMinValue()));
		}
	}
	
	private void fetch(Root<Amount> root, CriteriaQuery<?> query){
		if(!query.getResultType().equals(Long.class)){
			query.distinct(true);
			root.fetch("ingredient");
			root.fetch("system");
		}
	}

	@Override
	public Predicate toPredicate(Root<Amount> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		fetch(root, query);
		findByAmount(root, query, cb);
		findByIngredient(root, query);
		findBySystem(root, query);
		if(predicates.isEmpty())return null;
		Predicate[] array = new Predicate[predicates.size()];
		array = predicates.toArray(array);
		return cb.and(array);
	}
}
