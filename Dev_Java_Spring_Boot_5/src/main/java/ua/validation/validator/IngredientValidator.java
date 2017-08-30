package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.IngredientRepository;
import ua.validation.annotation.UniqueIngredient;

@Component
public class IngredientValidator implements ConstraintValidator<UniqueIngredient, String>{

	private final IngredientRepository repository;
	
	public IngredientValidator(IngredientRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueIngredient constraintAnnotation) { }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !repository.existsByName(value);
	}

}
