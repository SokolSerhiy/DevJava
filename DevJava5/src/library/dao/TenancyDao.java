package library.dao;

import java.util.List;

import library.model.Tenancy;

public interface TenancyDao {

	void save(Tenancy tenancy);
	
	void upadate(Tenancy tenancy);
	
	void delete(Tenancy tenancy);
	
	Tenancy findOne(String id);
	
	List<Tenancy> findAll();
}
