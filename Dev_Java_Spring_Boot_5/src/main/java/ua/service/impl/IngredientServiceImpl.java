package ua.service.impl;

import org.springframework.stereotype.Service;

import ua.entity.Ingredient;
import ua.repository.IngredientRepository;
import ua.service.IngredientService;

@Service
public class IngredientServiceImpl extends CrudServiceImpl<Ingredient, Integer> implements IngredientService{

	public IngredientServiceImpl(IngredientRepository repository) {
		super(repository);
	}

}
