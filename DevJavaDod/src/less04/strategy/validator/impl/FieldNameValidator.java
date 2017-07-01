package less04.strategy.validator.impl;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class FieldNameValidator implements Validator{

	private final String resName;
	
	private final Validator validator;
	
	public FieldNameValidator(String resName, Validator validator) {
		this.resName = resName;
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		try {
			objects[0].getClass().getDeclaredField(resName);
		} catch (NoSuchFieldException | SecurityException e) {
			throw new ПомилкаГри("У Human має бути поле "+resName);
		}
		System.out.println("Перевірка Resource пройдена");
	}
}
