package ua.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;

import ua.repository.BrandRepository;
import ua.validation.annotation.UniqueBrand;

@Component
public class BrandValidator implements ConstraintValidator<UniqueBrand, String>{

	private final BrandRepository repository;
	
	public BrandValidator(BrandRepository repository) {
		this.repository = repository;
	}

	@Override
	public void initialize(UniqueBrand arg0) { }

	@Override
	public boolean isValid(String name, ConstraintValidatorContext context) {
		return repository.findByName(name.trim())==null;
	}
}
