package ua.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
}
