package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Transporter;

public interface TransporterRepository extends JpaNameRepository<Transporter, Integer>{

	@Query("SELECT name FROM Model")
	List<String> findAllModels();
	@Query("SELECT name FROM Brand")
	List<String> findAllBrands();
	@Query("SELECT name FROM City")
	List<String> findAllCities();

}