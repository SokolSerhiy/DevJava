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
//		RentType rentType = new RentType("per yea");
//		Street street = new Street("Naukova");
//		System.out.println(street.getId());
//		Area area = new Area("Frankivskiy");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
//		Apartment apartment = em.find(Apartment.class, 2);
//		Area area = em.find(Area.class, 1);
//		Street street = em.find(Street.class, 2);
//		RentType rentType = em.find(RentType.class, 1);
//		apartment.setRentType(rentType);
//		apartment.setArea(area);
//		apartment.setNumber("4A");
//		apartment.setStreet(street);
//		apartment.setDescription("Very good apartment1");
//		apartment.setPrice(new BigDecimal("900"));
//		apartment.setRentType(rentType);
//		apartment.setRooms(2);
//		em.persist(apartment);
//		apartment.setStreet(em.find(Street.class, 1));
//		em.persist(rentType);
//		rentType.setName(rentType.getName()+"r");
//		em.detach(rentType);
//		em.merge(rentType);
//		em.persist(street);
//		em.persist(area);
		List<RentType> rentTypes = em.createQuery("FROM RentType"
				, RentType.class).getResultList();
		RentType rentType1 = em.createQuery("FROM RentType rt WHERE rt.name = ?1",
				RentType.class)
				.setParameter(1, "per month")
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		for (RentType rentType : rentTypes) {
			System.out.println(rentType.getName());
		}
		System.out.println(rentType1.getName());
//		System.out.println(street.getId());
		factory.close();
	}
}