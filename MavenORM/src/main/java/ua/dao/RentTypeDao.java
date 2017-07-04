package ua.dao;

import java.util.ArrayList;
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
}
