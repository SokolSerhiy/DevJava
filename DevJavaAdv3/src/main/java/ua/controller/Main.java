package ua.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;

import ua.entity.Brand;
import ua.entity.Cargo;
import ua.entity.City;
import ua.entity.Model;
import ua.entity.Status;
import ua.entity.Transporter;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("primary");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
//		Model model = manager.find(Model.class, 1);
//		City city = manager.find(City.class, 1);
//		Brand brand = manager.find(Brand.class, 1);
//		Transporter transporter = manager.find(Transporter.class, 1);
//		transporter.setPhone("+380678524569");
//		transporter.setStatus(Status.IN_THE_WAY);
//		transporter.setAge(25);
//		transporter.setBrand(brand);
//		transporter.setCarAge(2);
//		transporter.setCityArrive(city);
//		transporter.setCount(0);
//		transporter.setDateArrive(LocalDateTime.of(2017, 8, 8, 15, 26));
//		transporter.setMaxWeight(20_000);
//		transporter.setModel(model);
//		transporter.setName("Mykola");
//		manager.persist(transporter);
		
		List<Cargo> list = manager.createQuery("FROM Cargo c WHERE c.price > ?1", Cargo.class)
		.setParameter(1, new BigDecimal("200"))
		.getResultList();
		for (Cargo cargo : list) {
			System.out.println(cargo.getGoods().getName());
		}
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}