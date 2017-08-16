package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Component;
import ua.model.view.ComponentView;

public interface ComponentRepository extends JpaRepository<Component, Integer>{

	@Query("SELECT i.name FROM Ingredient i")
	List<String> findAllIngredients();
	@Query("SELECT ms.name FROM Ms ms")
	List<String> findAllMss();
	@Query("SELECT new ua.model.view.ComponentView(c.id, i.name, c.amount, ms.name) FROM Component c JOIN c.ingredient i JOIN c.ms ms")
	List<ComponentView> findAllView();

}
