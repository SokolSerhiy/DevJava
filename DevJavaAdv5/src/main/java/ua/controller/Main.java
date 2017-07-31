package ua.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import ua.entity.Cuisine;
import ua.entity.Meal;
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
		
		List<Meal> meals = em.createQuery("SELECT m FROM Meal m JOIN FETCH m.cuisine c WHERE c.name = ?1 AND m.components IS NOT EMPTY", Meal.class)
				.setParameter(1, "German")
				.getResultList();
		List<MealView> views = em.createQuery("SELECT new ua.model.view.MealView(m.id, m.photoUrl, m.version, m.rate, m.name, m.fullDescription, m.price, m.weight, c.name) FROM Meal m JOIN m.cuisine c WHERE c.name=?1", MealView.class)
				.setParameter(1, "German")
				.getResultList();
		em.getTransaction().commit();
		em.close();
		"SELECT c.name FROM Cuisine c".length();
		meals.forEach(m->System.out.println(m.getCuisine().getName()));
		views.forEach(System.out::println);
		factory.close();
	}
}
