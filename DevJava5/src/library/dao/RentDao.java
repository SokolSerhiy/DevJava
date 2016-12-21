package library.dao;

import java.util.List;

import library.model.Rent;
import library.model.Tenancy;
import library.model.Tenant;

public interface RentDao {

	void save(Rent rent);
	
	void upadate(Rent rent);
	
	void delete(Rent rent);
	
	Rent findOne(String id);
	
	List<Rent> findAll();
	
	List<Rent> findAll(Tenancy tenancy);
	
	List<Rent> findAll(Tenant tenant);
}
