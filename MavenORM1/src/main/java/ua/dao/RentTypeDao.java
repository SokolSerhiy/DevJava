package ua.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
}
