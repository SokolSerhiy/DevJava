package ua.controller;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.Cafe;
import ua.entity.Cafe_;
import ua.entity.OpenClose;
import ua.entity.Type;
import ua.model.view.CafeView;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		OpenClose open = em.find(OpenClose.class, 1);
//		OpenClose close = em.find(OpenClose.class, 4);
//		openClose.setTime(LocalTime.of(10, 0));
//		em.remove(openClose);
//		Cafe cafe = new Cafe();
//		cafe.setAddress("Lviv, sq. Shevchenka 25");
//		cafe.setClose(close);
//		cafe.setEmail("sdfkjds@dfj.df");
//		cafe.setFullDescription("Full desc");
//		cafe.setName("Addada");
//		cafe.setOpen(open);
//		cafe.setPhone("+358956454");
//		cafe.setShortDescription("Short desc");
//		cafe.setType(Type.CAFE);
//		em.persist(cafe);
		
//		List<Cafe> list = em.createQuery("FROM Cafe c WHERE c.name=?24", Cafe.class)
//				.setParameter(24, "Addada")
//				.getResultList();
//		for (Cafe cafe : list) {
//			System.out.println(cafe.getOpen().getTime());
//		}
//		List<Cafe> cafes = em.createQuery("SELECT c FROM Cafe c JOIN FETCH c.open o JOIN FETCH c.close WHERE o.time = ?1 AND c.tables IS NOT EMPTY", Cafe.class)
//				.setParameter(1, LocalTime.of(12, 0))
//				.getResultList();
//		List<CafeView> views = em.createQuery("SELECT new ua.model.view.CafeView(c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.fullDescription, c.type, c.phone, c.email, open.time, close.time) FROM Cafe c JOIN c.open open JOIN c.close close WHERE open.time = ?1", CafeView.class)
//				.setParameter(1, LocalTime.of(12, 0))
//				.getResultList();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<CafeView> cq = cb.createQuery(CafeView.class);
		Root<Cafe> root = cq.from(Cafe.class);
		Join<Cafe, OpenClose> closeJoin = root.join("close");
		Join<Cafe, OpenClose> openJoin = root.join("open");
//c.id, c.rate, c.name, c.photoUrl, c.version, c.address, c.fullDescription, c.type, c.phone, c.email, open.time, close.time/
		cq.multiselect(root.get(Cafe_.id),
				root.get(Cafe_.rate),
				root.get("name"),
				root.get("photoUrl"),
				root.get("version"),
				root.get("address"),
				root.get("fullDescription"),
				root.get("type"),
				root.get("phone"),
				root.get("email"),
				openJoin.get("time"),
				closeJoin.get("time"));
		Predicate ratePredicate = cb.ge(root.get(Cafe_.rate), new BigDecimal("4"));
		Predicate typePredicate = cb.equal(root.get("type"), Type.CAFE);
		Predicate phonePredicate = cb.like(root.get(Cafe_.phone), "+380%");
		Predicate closePredicate = closeJoin.get("time").in(Arrays.asList(LocalTime.of(23, 0), LocalTime.of(0, 0), LocalTime.of(1, 0)));
//		root.fetch("close");
		Predicate and = cb.and(ratePredicate, typePredicate, phonePredicate, closePredicate);
		cq.where(and);
		List<CafeView> cafes = em.createQuery(cq).getResultList();
		System.out.println(cafes);
		em.getTransaction().commit();
		em.close();
//		"SELECT c.name FROM Cuisine c".length();
//		cafes.forEach(c->System.out.println(c.getOpen().getTime()));
//		views.forEach(System.out::println);
		factory.close();
	}
}
