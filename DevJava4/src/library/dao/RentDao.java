package library.dao;

import java.util.List;

import library.model.Rent;
import library.model.Tenancy;
import library.model.Tenant;

public interface RentDao {

	void save(Rent rent);
	
	void returnRent(Tenant tenant, Tenancy tenancy);
	
	List<Rent> findAll();
	
	List<Rent> findAll(Tenant tenant);
	
	List<Rent> findAll(Tenancy tenancy);
}
