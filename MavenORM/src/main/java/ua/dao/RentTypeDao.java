package ua.dao;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaBuilder.In;

import ua.entity.Apartment;
import ua.entity.RentType;

public class RentTypeDao {

	private final EntityManagerFactory factory;

	public RentTypeDao(EntityManagerFactory factory) {
		this.factory = factory;
	}
	
	public void save(RentType type){
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(type);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void update(RentType type){
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(type);
		manager.getTransaction().commit();
		manager.close();
	}
	
	public void delete(Integer id){
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.remove(manager.find(RentType.class, id));
		manager.getTransaction().commit();
		manager.close();
	}
	
	public RentType findOne(Integer id) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		RentType type = manager.find(RentType.class, id);
		manager.getTransaction().commit();
		manager.close();
		return type;
	}
	
	public List<RentType> findAll() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		List<RentType> type = manager.createQuery("SELECT rt FROM RentType rt", RentType.class).getResultList();
		manager.getTransaction().commit();
		manager.close();
		return type;
	}
	
	public List<RentType> findByApartmentPrice(BigDecimal price) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		List<RentType> type = manager.createQuery("SELECT rt FROM RentType rt JOIN rt.apartments a WHERE a.price = ?1", RentType.class)
				.setParameter(1, price)
				.getResultList();
		manager.getTransaction().commit();
		manager.close();
		return type;
	}
	
	public List<Apartment> findApartmentByRentTypeId(Integer id) {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		List<Apartment> type = manager.createQuery("SELECT DISTINCT rt FROM RentType rt JOIN FETCH rt.apartments a WHERE rt.id = ?1", RentType.class)
				.setParameter(1, id)
				.getSingleResult()
				.getApartments();
		manager.getTransaction().commit();
		manager.close();
		return type;
	}
	
	public List<Apartment> findApartmentAllCriteria() {
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		BigDecimal minPrice = new BigDecimal("300");
		BigDecimal maxPrice = new BigDecimal("900");
		Integer rentTypeId = 1;
		Integer rentTypeId2 = 6;
		List<Integer> rentTypeIds = Arrays.asList(rentTypeId, rentTypeId2);
		Integer areaId = 1;
		int rooms = 2;
		CriteriaBuilder cb = manager.getCriteriaBuilder();
		CriteriaQuery<Apartment> cq = cb.createQuery(Apartment.class);
		Root<Apartment> root = cq.from(Apartment.class);
		cq.select(root);
		Predicate pricePred = cb.between(root.get("price"), minPrice, maxPrice);
		Predicate rentTypePred = root.get("rentType").in(rentTypeIds);
		Predicate areaPred = cb.equal(root.get("area"), areaId);
		Predicate roomsPred = cb.equal(root.get("rooms"), rooms);
		Predicate all = cb.and(pricePred, rentTypePred, areaPred, roomsPred);
		cq.where(all);
		List<Apartment> apartments = manager.createQuery(cq).getResultList();
		manager.getTransaction().commit();
		manager.close();
		return apartments;
	}
}
