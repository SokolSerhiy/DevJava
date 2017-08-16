package ua.service;

import java.util.List;

import ua.entity.Meal;
import ua.model.view.MealView;

public interface MealService {

	List<String> findAllCuisines();
	
	List<String> findAllIngredients();
	
	List<MealView> findAllViews();
	
	void save(Meal meal);
	
	void delete(Integer id);
}
