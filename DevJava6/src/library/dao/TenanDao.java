package library.dao;

import java.util.List;

import library.model.Tenan;

public interface TenanDao {

	void save(Tenan tenan);
	
	void update(Tenan tenan);
	
	void delete(Tenan tenan);
	
	Tenan findOne(String id);
	
	List<Tenan> findAll();
}