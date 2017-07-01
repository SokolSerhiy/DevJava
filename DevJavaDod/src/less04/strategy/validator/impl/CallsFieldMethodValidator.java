package less04.strategy.validator.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import less04.strategy.validator.Validator;

public class CallsFieldMethodValidator implements Validator{

	private final String fieldName;
	
	private final String fieldMethodName;
	
	private final String methodName;
	
	private final Validator validator;
	
	public CallsFieldMethodValidator(String fieldName, String fieldMethodName, String methodName, Validator validator) {
		this.fieldName = fieldName;
		this.fieldMethodName = fieldMethodName;
		this.methodName = methodName;
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		try {
			Field field = objects[0].getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			Object object = field.get(objects[0]);
			Method method = objects[0].getClass().getDeclaredMethod(methodName);
			method.invoke(objects[0]);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	
}
