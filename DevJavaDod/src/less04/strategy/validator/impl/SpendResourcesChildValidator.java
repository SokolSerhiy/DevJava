package less04.strategy.validator.impl;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class SpendResourcesChildValidator implements Validator{

	private final int min;
	
	private final int max;
	
	private final String resName;
	
	private final String methodName;
	
	private final Validator validator;
	
	public SpendResourcesChildValidator(int min, int max, String resName, String methodName, Validator validator) {
		this.min = min;
		this.max = max;
		this.resName = resName;
		this.methodName = methodName;
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		try {
			Method method = objects[0].getClass().getDeclaredMethod(methodName);
			method.setAccessible(true);
			int[] results = new int[10000];
			Field field = objects[0].getClass().getSuperclass().getDeclaredField(resName);
			field.setAccessible(true);
			setResourceValue(100, objects[0], field);
			for(int i = 0; i < 10000; i++){
					method.invoke(objects[0]);
					int spendRes = 100-getResourceValue(objects[0], field);
					if(!(spendRes>=min&&spendRes<=max)) throw new ПомилкаГри("У Human метод "+methodName+"() має зʼїдати від "+min+" до "+max+", а їсть "+spendRes);
					results[i] = spendRes;
					setResourceValue(100, objects[0], field);
			}
			Arrays.sort(results);
			if(results[0]!=min||results[9999]!=max) throw new ПомилкаГри("У Human метод "+methodName+"() має зʼїдати від "+min+" до "+max+", а їсть від "+results[0]+" до "+results[9999]);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchFieldException e) {
			throw new ПомилкаГри("У Human має бути метод "+methodName+"()");
		}
		System.out.println("Перевірка SpendResources пройдена");
	}

	private int getResourceValue(Object object, Field field){
		try {
			return field.getInt(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void setResourceValue(int value, Object object, Field field){
		try {
			field.set(object, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ПомилкаГри("У Human поле "+resName+" має бути не final");
		}
	}
}
