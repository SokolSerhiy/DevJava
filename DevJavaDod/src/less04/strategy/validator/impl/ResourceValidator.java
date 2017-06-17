package less04.strategy.validator.impl;

import java.lang.reflect.Field;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class ResourceValidator implements Validator{

	private final String resName;
	
	private final Validator validator;
	
	public ResourceValidator(String resName, Validator validator) {
		this.resName = resName;
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		try {
			Field field = objects[0].getClass().getDeclaredField(resName);
			field.setAccessible(true);
			if(!field.getType().equals(int.class)){
				throw new ПомилкаГри("У Human поле "+resName+" має бути типу int");
			}
		} catch (NoSuchFieldException | SecurityException e) {
			throw new ПомилкаГри("У Human має бути поле "+resName);
		}
		System.out.println("Перевірка Resource пройдена");
	}
}
