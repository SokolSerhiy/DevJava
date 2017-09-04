package ua.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Ingredient;
import ua.repository.IngredientRepository;
import ua.service.IngredientService;

@Service
public class IngredientServiceImpl extends CrudServiceImpl<Ingredient, Integer> implements IngredientService{

	private final IngredientRepository repository;
	
	public IngredientServiceImpl(IngredientRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Ingredient> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
