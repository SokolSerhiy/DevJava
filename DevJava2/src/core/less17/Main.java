package core.less17;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> personClass = 
				Class.forName("core.less17.Person");
		for(Field field : personClass.getDeclaredFields()){
			System.out.println(field.getName());
		}
		
		Person person = new Person();
		person.setAge(18);
		person.setName("Ivan");
		
		Field ageField = personClass.getDeclaredField("age");
		ageField.setAccessible(true);
		Object age = ageField.get(person);
		System.out.println(age);
		Field nameField = personClass.getDeclaredField("name");
		nameField.setAccessible(true);
		Object name = nameField.get(person);
		System.out.println(name);
		
		Object person1 = personClass.newInstance();
		System.out.println(person1);
		
		ageField.set(person1, age);
		nameField.set(person1, name);
		System.out.println(person1);
		
		Method getAge = personClass.getDeclaredMethod("getAge");
		Method getName = personClass.getDeclaredMethod("getName");
		
		Object age1 = getAge.invoke(person);
		Object name1 = getName.invoke(person);
		
		System.out.println(age1);
		System.out.println(name1);
		
		Method setAge = personClass.getDeclaredMethod("setAge", int.class);
		Method setName = personClass.getDeclaredMethod("setName", String.class);
		
		Object person2 = personClass.newInstance();
		setAge.invoke(person2, age1);
		setName.invoke(person2, name1);
		System.out.println(person2);
	}
}