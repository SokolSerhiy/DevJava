package ua.service;

import java.util.List;

import ua.model.request.MealRequest;
import ua.model.view.MealView;

public interface MealService {

	List<String> findAllCuisines();
	
	List<String> findAllIngredients();
	
	List<MealView> findAllViews();
	
	void save(MealRequest request);
	
	MealRequest findOne(Integer id);
	
	void delete(Integer id);
}
