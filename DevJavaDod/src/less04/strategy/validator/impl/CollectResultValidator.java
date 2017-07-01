package less04.strategy.validator.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import less04.strategy.exception.ПомилкаГри;
import less04.strategy.validator.Validator;

public class CollectResultValidator implements Validator{

	private final int min;
	
	private final int max;
	
	private final String methodName;
	
	private final Validator validator;

	public CollectResultValidator(int min, int max, String methodName, Validator validator) {
		this.min = min;
		this.max = max;
		this.methodName = methodName;
		this.validator = validator;
	}

	@Override
	public void validate(Object[] objects) {
		validator.validate(objects);
		try {
			Method method = objects[0].getClass().getDeclaredMethod(methodName);
			method.setAccessible(true);
			Object res = method.invoke(objects[0]);
			if(res==null) throw new ПомилкаГри("У Human метод "+methodName+"() має повертати int");
			if(!res.getClass().equals(Integer.class)) throw new ПомилкаГри("У Human метод "+methodName+"() має повертати int");
			int[] array = new int[10000];
			for(int i = 0; i < 10000; i++){
				res = method.invoke(objects[0]);
				array[i]=(int)res;
				if(!((int)res>=min&&(int)res<=max)) throw new ПомилкаГри("У Human метод "+methodName+"() має повертати int від "+min+" до "+max+", а повернув "+res);
			}
			Arrays.sort(array);
			if(array[0]!=min||array[9999]!=max) throw new ПомилкаГри("У Human метод collectFood() має повертати int від "+min+" до "+max+", а повернув від "+array[0]+" до "+array[9999]);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new ПомилкаГри("У класі має бути метод "+methodName+"()");
		}
		System.out.println("Перевірка CollectResult пройдена");
	}
}
