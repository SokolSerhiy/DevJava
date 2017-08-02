package ua.controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.Component;
import ua.entity.Component_;
import ua.entity.Cuisine;
import ua.entity.Cuisine_;
import ua.entity.Ingredient;
import ua.entity.Ingredient_;
import ua.entity.Meal;
import ua.entity.Meal_;
import ua.model.view.MealView;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		Cuisine cuisine = em.find(Cuisine.class, 5);
//		Meal meal = new Meal();
//		meal.setCuisine(cuisine);
//		meal.setFullDescription("Full desc");
//		meal.setName("Sausage");
//		meal.setPrice(new BigDecimal("80"));
//		meal.setShortDescription("Short desc");
//		meal.setWeight(200);
//		em.persist(meal);
//		List<Meal> list = em.createQuery("FROM Meal m WHERE m.name=?1", Meal.class)
//				.setParameter(1, "Sausage")
//				.getResultList();
//		for (Meal meal : list) {
//			System.out.println(meal.getName());
//		}
		
//		List<Meal> meals = em.createQuery("SELECT m FROM Meal m JOIN FETCH m.cuisine c WHERE c.name = ?1 AND m.components IS NOT EMPTY", Meal.class)
//				.setParameter(1, "German")
//				.getResultList();
//		List<MealView> views = em.createQuery("SELECT new ua.model.view.MealView(m.id, m.photoUrl, m.version, m.rate, m.name, m.fullDescription, m.price, m.weight, c.name) FROM Meal m JOIN m.cuisine c WHERE c.name=?1", MealView.class)
//				.setParameter(1, "German")
//				.getResultList();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<MealView> cq = cb.createQuery(MealView.class);
		Root<Meal> root = cq.from(Meal.class);
		Join<Meal, Cuisine> cuisineJoin = root.join(Meal_.cuisine);
		Join<Meal,Component> componentJoin = root.join(Meal_.components);
		Join<Component, Ingredient> ingredientJoin = componentJoin.join(Component_.ingredient);
		cq.multiselect(root.get(Meal_.id),
				root.get(Meal_.photoUrl),
				root.get(Meal_.version),
				root.get(Meal_.rate),
				root.get(Meal_.name),
				root.get(Meal_.fullDescription),
				root.get(Meal_.price),
				root.get(Meal_.weight),
				cuisineJoin.get(Cuisine_.name));
		Predicate ratePredicate = cb.ge(root.get(Meal_.rate), new BigDecimal("4"));
		Predicate namePredicate = cb.like(root.get(Meal_.name), "A%");
		Predicate cuisinePredicate = cuisineJoin.get(Cuisine_.name).in(Arrays.asList("Ukrainian", "German"));
		Predicate ingredientPredicate = ingredientJoin.get(Ingredient_.name).in(Arrays.asList("potato", "meat", "root"));
		cq.where(ratePredicate, namePredicate, cuisinePredicate, ingredientPredicate);
//		Fetch<Meal, Cuisine> fetch = root.fetch(Meal_.cuisine);
//		Join<Meal, Cuisine> join = (Join<Meal, Cuisine>) fetch;
		List<MealView> meals = em.createQuery(cq).getResultList();
		System.out.println(meals);
		em.getTransaction().commit();
		em.close();
//		"SELECT c.name FROM Cuisine c".length();
//		meals.forEach(m->System.out.println(m.getCuisine().getName()));
//		views.forEach(System.out::println);
		factory.close();
	}
}
