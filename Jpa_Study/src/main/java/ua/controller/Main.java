package ua.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Hibernate;

import ua.entity.Commodity;
import ua.entity.Order;
import ua.entity.User;

public class Main {

	public static void main(String[] args) {
		final EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("primary");
		final EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		
		User user = em.createQuery(
				"SELECT DISTINCT u FROM User u LEFT JOIN FETCH u.orders o"
				+ " LEFT JOIN FETCH o.commodity"
				+ " WHERE u.id=?1", User.class)
				.setParameter(1, 4)
				.getSingleResult();
		
		Hibernate.initialize(user.getOrders());
		em.getTransaction().commit();
		em.close();
		factory.close();
		for(Order order : user.getOrders()){
			System.out.println(order);
		}
	}

}
