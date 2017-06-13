package less17;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import less16.Person;

public class Main {

	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> someObject = Class.forName("less16.Person");
		Field[] fields = someObject.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName()+" "+field.getGenericType());
		}
		Person person = new Person("Ivan", 18);
		Field ageField = someObject.getDeclaredField("age");
		ageField.setAccessible(true);
		Object age = ageField.get(person);
		System.out.println(age);
		Field nameField = someObject.getDeclaredField("name");
		nameField.setAccessible(true);
		Object name = nameField.get(person);
		System.out.println(name);
		
		Object personFromDB1 = someObject.newInstance();
		System.out.println(personFromDB1);
		ageField.set(personFromDB1, age);
		nameField.set(personFromDB1, name);
		System.out.println(personFromDB1);
		
		Method getAge = someObject.getDeclaredMethod("getAge");
		Method getName = someObject.getDeclaredMethod("getName");
		age = getAge.invoke(person);
		name = getName.invoke(person);
		System.out.println(name+" "+age);
		
		Method setAge = someObject.getDeclaredMethod("setAge", int.class);
		Method setName = someObject.getDeclaredMethod("setName", String.class);
		Object personFromDB2 = someObject.newInstance();
		setAge.invoke(personFromDB2, age);
		setName.invoke(personFromDB2, name);
		System.out.println(personFromDB2);
	}
}