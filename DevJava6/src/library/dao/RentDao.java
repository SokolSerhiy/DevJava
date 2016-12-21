package library.dao;

import java.util.List;

import library.model.Rent;
import library.model.Tenan;
import library.model.Tenancy;

public interface RentDao {

	void save(Rent rent);
	
	void update(Rent rent);
	
	void delete(Rent rent);
	
	List<Rent> findAll();
	
	List<Rent> findAll(Tenan tenan);
	
	List<Rent> findAll(Tenancy tenancy);
}
