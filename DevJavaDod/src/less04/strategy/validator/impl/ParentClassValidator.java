package less04.strategy.validator.impl;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class ParentClassValidator implements Validator{
	
	private final String parentClassName;

	private final Validator validator;
	
	public ParentClassValidator(String parentClassName, Validator validator) {
		this.parentClassName = parentClassName;
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		if(!objects[0].getClass().getSuperclass().getSimpleName().equals(parentClassName)){
			throw new ПомилкаГри("Клас повинен наслідуватись від "+parentClassName);
		}
	}
}