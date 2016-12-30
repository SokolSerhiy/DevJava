package core.less18;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import core.less14.Person;

public class Main {

	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> personClass = Class.forName("core.less14.Person");
		for(Field field : personClass.getDeclaredFields()){
			System.out.println(field.getName());
		}
		Person person = new Person.Builder().age(18).name("Ivan").build();
		System.out.println(person);
		
		Field ageField = personClass.getDeclaredField("age");
		Field nameField = personClass.getDeclaredField("name");
		ageField.setAccessible(true);
		nameField.setAccessible(true);
		Object age = ageField.get(person);
		Object name = nameField.get(person);
		System.out.println(age+" "+name);
		
		Object person1 = personClass.newInstance();
		System.out.println(person1);
		ageField.set(person1, age);
		nameField.set(person1, name);
		System.out.println(person1);
		
		Method getAge = personClass.getMethod("getAge");
		Method getName = personClass.getMethod("getName");
		age = getAge.invoke(person);
		name = getName.invoke(person);
		System.out.println(age+" "+name);
		
		Object person2 = personClass.newInstance();
		Method setAge = personClass.getMethod("setAge", int.class);
		Method setName = personClass.getMethod("setName", String.class);
		setAge.invoke(person2, age);
		setName.invoke(person2, name);
		System.out.println(person2);
	}
}