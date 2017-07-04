package ua.controller;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import ua.entity.Apartment;
import ua.entity.Area;
import ua.entity.RentType;
import ua.entity.Street;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		Apartment apartment = new Apartment();
//		apartment.setArea(em.find(Area.class, 1));
//		apartment.setDescription("Very good apartment4");
//		apartment.setNumber("11");
//		apartment.setRentType(em.find(RentType.class, 2));
//		apartment.setPrice(new BigDecimal("6000"));
//		apartment.setRooms(1);
//		apartment.setStreet(em.find(Street.class, 2));
//		em.persist(apartment);
		List<RentType> rentTypes = em.createQuery("SELECT rt FROM RentType rt",
				RentType.class).getResultList();
		RentType rentType2 = em.createQuery("SELECT rt FROM RentType rt WHERE rt.name = ?1",
				RentType.class).setParameter(1, "per day").getSingleResult();
		em.getTransaction().commit();
		em.close();
		for (RentType rentType : rentTypes) {
			System.out.println(rentType.getName());
		}
		System.out.println(rentType2.getName());
		factory.close();
	}
}