package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import ua.entity.Ingredient;

public interface IngredientRepository extends JpaNameRepository<Ingredient>{

	@Query("FROM Ingredient i WHERE i.name IN ?1")
	List<Ingredient> findAll(List<String> names);
}
