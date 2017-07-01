package less04.strategy.validator.impl;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class ClassNameValidator implements Validator{

	private final Validator validator;
	
	private final String className;
	
	public ClassNameValidator(String className, Validator validator) {
		this.validator = validator;
		this.className = className;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		if(!objects[0].getClass().getSimpleName().equals(className)){
			throw new ПомилкаГри("Усі люди мають бути одного класу "+className);
		}
		System.out.println("Перевірка ClassName пройдена");
	}
}