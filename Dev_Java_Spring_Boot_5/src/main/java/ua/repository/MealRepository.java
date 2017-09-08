package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Meal;

public interface MealRepository extends JpaNameRepository<Meal>{

	@Query("SELECT name FROM Cuisine")
	List<String> findAllCuisines();

}
