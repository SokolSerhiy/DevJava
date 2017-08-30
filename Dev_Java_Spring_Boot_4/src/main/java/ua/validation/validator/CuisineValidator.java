package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.CuisineRepository;
import ua.validation.annotation.UniqueCuisine;

@Component
public class CuisineValidator implements ConstraintValidator<UniqueCuisine, String>{

	private final CuisineRepository repository;
	
	public CuisineValidator(CuisineRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueCuisine constraintAnnotation) { }

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return !repository.existsByName(value);
	}
}