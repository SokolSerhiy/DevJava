package ua.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Meal;
import ua.model.view.MealView;
import ua.repository.MealRepository;
import ua.service.MealService;

@Service
public class MealServiceImpl implements MealService{

	private final MealRepository repository;

	public MealServiceImpl(MealRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllCuisines() {
		return repository.findAllCuisines();
	}

	@Override
	public List<String> findAllIngredients() {
		return repository.findAllIngredients();
	}

	@Override
	@Transactional(readOnly=true)
	public List<MealView> findAllViews() {
		List<MealView> views = repository.findAllViews();
		views.forEach(this::loadIngredients);
		return views;
	}
	
	private void loadIngredients(MealView view) {
		view.setIngredients(repository.findAllIngredientsByMealId(view.getId()));
	}

	@Override
	public void save(Meal meal) {
		repository.save(meal);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
}
