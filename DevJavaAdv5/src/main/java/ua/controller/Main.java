package ua.controller;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Cuisine;
import ua.entity.Meal;

public class Main {
	
	public static void main(String[] args) {
		EntityManagerFactory factory = 
				Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		Cuisine cuisine = em.find(Cuisine.class, 5);
		Meal meal = new Meal();
		meal.setCuisine(cuisine);
		meal.setFullDescription("Full desc");
		meal.setName("Sausage");
		meal.setPrice(new BigDecimal("80"));
		meal.setShortDescription("Short desc");
		meal.setWeight(200);
		em.persist(meal);
		em.getTransaction().commit();
		em.close();
		factory.close();
	}
}
