package less04.strategy.validator.impl;

import java.lang.reflect.Field;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class FieldTypeNameValidator implements Validator{

	private final String fieldName;
	
	private final String fieldTypeName;
	
	private final Validator validator;
	
	public FieldTypeNameValidator(String fieldName, String fieldTypeName, Validator validator) {
		this.fieldName = fieldName;
		this.fieldTypeName = fieldTypeName;
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		try {
			Field field = objects[0].getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			if(!field.getType().getSimpleName().equals(fieldTypeName)){
				throw new ПомилкаГри("У класі поле "+fieldName+" має бути типу "+fieldTypeName);
			}
		} catch (NoSuchFieldException | SecurityException e) {
			throw new ПомилкаГри("У класі має бути поле "+fieldName);
		}
		
	}
}
