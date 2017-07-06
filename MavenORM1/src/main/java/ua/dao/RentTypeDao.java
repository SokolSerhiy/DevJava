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
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.persist(type);
		em.getTransaction().commit();
		em.close();
	}
	
	public void update(RentType type){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.merge(type);
		em.getTransaction().commit();
		em.close();
	}
	
	public void delete(Integer id){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.remove(em.find(RentType.class, id));
		em.getTransaction().commit();
		em.close();
	}
	
	public RentType findOne(Integer id){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		RentType type = em.find(RentType.class, id);
		em.getTransaction().commit();
		em.close();
		return type;
	}
	
	public List<RentType> findAll(){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<RentType> types = em.createQuery("FROM RentType", RentType.class).getResultList();
		em.getTransaction().commit();
		em.close();
		return types;
	}
	
	public List<RentType> findByApartmentPrice(BigDecimal price){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<RentType> types = em.createQuery("SELECT rt FROM RentType rt JOIN rt.apartments a WHERE a.price = ?1", RentType.class)
				.setParameter(1, price)
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return types;
	}
	
	public List<Apartment> findApartmentByRentTypeId(Integer id){
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		List<Apartment> apartments = em.createQuery("SELECT DISTINCT rt FROM RentType rt JOIN FETCH rt.apartments a WHERE rt.id = ?1", RentType.class)
				.setParameter(1, id)
				.getSingleResult()
				.getApartments();
		em.getTransaction().commit();
		em.close();
		return apartments;
	}
}
