package ua.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Fetch;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ua.entity.Brand;
import ua.entity.Cargo;
import ua.entity.City;
import ua.entity.Model;
import ua.entity.Status;
import ua.entity.Transporter;
import ua.model.view.TransporterView;

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
		
//		List<Cargo> list = manager.createQuery("FROM Cargo c WHERE c.price > ?1", Cargo.class)
//		.setParameter(1, new BigDecimal("200"))
//		.getResultList();
//		for (Cargo cargo : list) {
//			System.out.println(cargo.getGoods().getName());
//		}
//		List<Transporter> list1 = new ArrayList<>();
//		List<TransporterView> list2 = new ArrayList<>();
//		Transporter transporter = manager.createQuery("SELECT t FROM Transporter t JOIN FETCH t.brand JOIN FETCH t.model JOIN t.cityArrive c WHERE c.name=?1", Transporter.class)
//				.setParameter(1, "Lviv")
//				.getSingleResult();
//		TransporterView view = manager.createQuery("SELECT new ua.model.view.TransporterView(t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name, t.count, t.age, t.phone, b.name, m.name, t.carAge, c.name, t.dateArrive, t.status) FROM Transporter t JOIN t.brand b JOIN t.model m JOIN t.cityArrive c WHERE c.name=?1", TransporterView.class)
//				.setParameter(1, "Lviv")
//				.getSingleResult();
//		"SELECT b.name FROM Brand b".length();
		
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<TransporterView> cq = cb.createQuery(TransporterView.class);
		Root<Transporter> root = cq.from(Transporter.class);
		Join<Transporter, Brand> brandJoin = root.join("brand");
		Join<Transporter, Model> modelJoin = root.join("model");
		Join<Transporter, City> cityJoin = root.join("cityArrive");
//t.id, t.rate, t.maxWeight, t.photoUrl, t.version, t.name, t.count, t.age, t.phone, b.name, m.name, t.carAge, c.name, t.dateArrive, t.status
		cq.multiselect(root.get("id"), root.get("rate"), 
			root.get("maxWeight"), 
			root.get("photoUrl"), 
			root.get("version"),
			root.get("name"),
			root.get("count"),
			root.get("age"),
			root.get("phone"),
			brandJoin.get("name"),
			modelJoin.get("name"),
			root.get("carAge"),
			cityJoin.get("name"),
			root.get("dateArrive"),
			root.get("status"));
		Predicate ratePredicate = cb.ge(root.get("rate"), new BigDecimal("4"));
		Predicate agePredicate = cb.between(root.get("age"), 25, 45);
		Predicate namePredicate = cb.like(root.get("name"), "A%");
		Predicate brandPredicate = cb.equal(brandJoin.get("name"), "Renault");
		Predicate modelPredicate = modelJoin.get("name").in(Arrays.asList("Premium", "Super car"));
//		root.fetch("model");
		Predicate all = cb.and(ratePredicate, agePredicate, namePredicate, brandPredicate, modelPredicate);
		cq.where(all);
		List<TransporterView> transporters=manager.createQuery(cq).getResultList();
		System.out.println(transporters);
		manager.getTransaction().commit();
		manager.close();
		factory.close();
	}
}