package core.less18;

import java.lang.reflect.*;

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
		ageField.setAccessible(true);
		Field nameField = personClass.getDeclaredField("name");
		nameField.setAccessible(true);
		Object age = ageField.get(person);
		Object name = nameField.get(person);
		System.out.println(age+" "+name);
		
		Object person1 = personClass.newInstance();
		System.out.println(person1);
		ageField.set(person1, age);
		nameField.set(person1, name);
		System.out.println(person1);
		
		Method getName = personClass.getMethod("getName");
		Method getAge = personClass.getMethod("getAge");
		name = getName.invoke(person);
		age = getAge.invoke(person);
		System.out.println(age+" "+name);
		
		Method setName = personClass.getMethod("setName", String.class);
		Method setAge = personClass.getMethod("setAge", int.class);
		Object person2 = personClass.newInstance();
		setName.invoke(person2, name);
		setAge.invoke(person2, age);
		System.out.println(person2);
	}
}