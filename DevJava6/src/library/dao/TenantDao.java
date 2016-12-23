package library.dao;

import java.util.List;

import library.model.Tenant;

public interface TenantDao {

	void save(Tenant tenant);
	
	void update(Tenant tenant);
	
	void delete(Tenant tenant);
	
	Tenant findOne(String id);
	
	List<Tenant> findAll();
}
