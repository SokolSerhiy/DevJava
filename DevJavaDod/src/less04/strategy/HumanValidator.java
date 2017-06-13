package less04.strategy;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class HumanValidator {
	
	private final Object[] objects;
	
	private final Object object;
	
	private Field field;
	
	public HumanValidator(Object[] objects) {
		this.objects = objects;
		validateArrayLength();
		this.object = objects[0];
		validate();
	}

	public void validate(){
		validateSameClass();
		validateClassName();
		validateBellyful();
		validateCollectFood();
		validateOtherWorkMethods("collectWood", 15, 20);
		validateOtherWorkMethods("collectStone", 10, 15);
		validateOtherWorkMethods("collectIron", 5, 10);
	}
	
	private void validateOtherWorkMethods(String methodName, int min, int max){
		Method method = null;
		try {
			method = object.getClass().getDeclaredMethod(methodName);
			method.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ПомилкаГри("У Human має бути метод "+methodName+"()");
		}
		try {
			Object res = method.invoke(object);
			if(res==null) throw new ПомилкаГри("У Human метод "+methodName+"() має повертати int");
			if(!res.getClass().equals(Integer.class)) throw new ПомилкаГри("У Human метод "+methodName+"() має повертати int");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		}
		int[] array = new int[10000];
		int[] results = new int[10000];
		setBellyfulValue(100);
		for(int i = 0; i < 10000; i++){
			try {
				Object res = method.invoke(object);
				array[i]=(int)res;
				if(!((int)res>=min&&(int)res<=max)) throw new ПомилкаГри("У Human метод "+methodName+"() має повертати int від "+min+" до "+max+", а повернув "+res);
				int bellyful = 100-getBellyfulValue();
				if(!(bellyful>=1&&bellyful<=5)) throw new ПомилкаГри("У Human метод "+methodName+"() має зʼїдати від 1 до 5, а їсть "+bellyful);
				results[i] = bellyful;
				setBellyfulValue(100);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			}
		}
		Arrays.sort(results);
		Arrays.sort(array);
		if(array[0]!=min||array[9999]!=max) throw new ПомилкаГри("У Human метод "+methodName+"() має повертати int від "+min+" до "+max+", а повернув від "+array[0]+" до "+array[9999]);
		if(results[0]!=1||results[9999]!=5) throw new ПомилкаГри("У Human метод "+methodName+"() має зʼїдати від 1 до 5, а їсть від "+results[0]+" до "+results[9999]);
	}
	
	private int getBellyfulValue(){
		try {
			return field.getInt(object);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void setBellyfulValue(int value){
		try {
			field.set(object, value);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			throw new ПомилкаГри("У Human поле bellyful має бути не final");
		}
	}
	
	private void validateCollectFood(){
		Method method = null;
		try {
			method = object.getClass().getDeclaredMethod("collectFood");
			method.setAccessible(true);
		} catch (NoSuchMethodException | SecurityException e) {
			throw new ПомилкаГри("У Human має бути метод collectFood()");
		}
		try {
			Object res = method.invoke(object);
			if(res==null) throw new ПомилкаГри("У Human метод collectFood() має повертати int");
			if(!res.getClass().equals(Integer.class)) throw new ПомилкаГри("У Human метод collectFood() має повертати int");
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		}
		int[] array = new int[10000];
		for(int i = 0; i < 10000; i++){
			try {
				Object res = method.invoke(object);
				array[i]=(int)res;
				if(!((int)res>=5&&(int)res<=15)) throw new ПомилкаГри("У Human метод collectFood() має повертати int від 5 до 15, а повернув "+res);
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			}
		}
		Arrays.sort(array);
		if(array[0]!=5||array[9999]!=15) throw new ПомилкаГри("У Human метод collectFood() має повертати int від 5 до 15, а повернув від "+array[0]+" до "+array[9999]);
	}
	
	private void validateBellyful(){
		field = null;
		try {
			field = object.getClass().getDeclaredField("bellyful");
			field.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
			throw new ПомилкаГри("У Human має бути поле bellyful");
		}
		if(!field.getType().equals(int.class)){
			throw new ПомилкаГри("У Human поле bellyful має бути типу int");
		}
	}
	
	private void validateArrayLength(){
		if(objects.length==0) throw new ПомилкаГри("Потрібно передати хоча б один екземпляр Human");
	}
	
	private void validateClassName(){
		if(!object.getClass().getSimpleName().equals("Human")){
			throw new ПомилкаГри("Усі люди мають бути одного класу Human");
		}
	}
	
	private void validateSameClass(){
		if(objects[0]==null) throw new ПомилкаГри("Жоден екземпляр не може бути null");
		Object object = objects[0];
		for (int i = 1; i < objects.length; i++) {
			if(objects[i]!=null&&object.getClass()!=objects[i].getClass()){
				throw new ПомилкаГри("Усі люди мають бути одного класу Human");
			}
		}
	}
}
