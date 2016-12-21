package library.dao;

import java.util.List;

import library.model.Rent;
import library.model.Tenancy;
import library.model.Tenant;

public interface RentDao {

	void save(Rent rent);
	
	void update(Rent rent);
	
	void delete(Rent rent);
	
	Rent findOne(String id);
	
	List<Rent> findAll();
	
	List<Rent> findByTenant(Tenant tenant);
	
	List<Rent> findByTenancy(Tenancy tenancy);
}
