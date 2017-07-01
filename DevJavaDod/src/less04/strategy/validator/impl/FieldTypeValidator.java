package less04.strategy.validator.impl;

import java.lang.reflect.Field;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class FieldTypeValidator implements Validator{

	private final Validator validator;
	
	private final Class<?> type;
	
	private final String fieldName;
	
	public FieldTypeValidator(Class<?> type,String fieldName, Validator validator) {
		this.validator = validator;
		this.type = type;
		this.fieldName = fieldName;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		try {
			Field field = objects[0].getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			if(!field.getType().equals(type)){
				throw new ПомилкаГри("У Human поле "+fieldName+" має бути типу int");
			}
		} catch (NoSuchFieldException | SecurityException e) {
			throw new ПомилкаГри("У Human має бути поле "+fieldName);
		}
	}

}
