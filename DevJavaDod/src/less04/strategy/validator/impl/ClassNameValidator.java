package less04.strategy.validator.impl;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class ClassNameValidator implements Validator{

	private final Validator validator;
	
	public ClassNameValidator(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		if(!objects[0].getClass().getSimpleName().equals("Human")){
			throw new ПомилкаГри("Усі люди мають бути одного класу Human");
		}
		System.out.println("Перевірка ClassName пройдена");
	}
}