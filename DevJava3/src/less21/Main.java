package less21;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import less18.Person;

public class Main {

	public static void main(String[] args) throws ReflectiveOperationException {
		Class<?> personClass = Class.forName("less18.Person");
		Field[] fields = personClass.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName()+" "+field.getType());
		}
		Person person = new Person("Ivan", 18);
		
		Field nameField = personClass.getDeclaredField("name");
		nameField.setAccessible(true);
		Object name = nameField.get(person);
		
		Field ageField = personClass.getDeclaredField("age");
		ageField.setAccessible(true);
		Object age = ageField.get(person);
		System.out.println(name + " " + age);
		
		Object person1 = personClass.newInstance();
		
		ageField.set(person1, age);
		nameField.set(person1, name);
		System.out.println(person1);
		
		Method getName = personClass.getDeclaredMethod("getName");
		Method getAge = personClass.getDeclaredMethod("getAge");
		
		Object name1 = getName.invoke(person);
		Object age1 = getAge.invoke(person);
		System.out.println(name1 + " " + age1);
		
		Method setName = personClass.getDeclaredMethod("setName", String.class);
		Method setAge = personClass.getDeclaredMethod("setAge", int.class);
		
		Object person2 = personClass.newInstance();
		
		setName.invoke(person2, name1);
		setAge.invoke(person2, age1);
		System.out.println(person2);
		
		Object obj = Class1.class.newInstance();
		Interf interf = (Interf)Proxy.newProxyInstance(
				Class1.class.getClassLoader(),
				Class1.class.getInterfaces(),
				new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				Method classMethod = Class1.class.getDeclaredMethod(method.getName(), method.getParameterTypes());
				if(classMethod.isAnnotationPresent(Annotat.class)){
					System.out.println("Before");
					Object res = method.invoke(obj, args);
					System.out.println("After");
					return res;
				}else {
					return method.invoke(obj, args);
				}
			}
		});
		interf.doSome();
		interf.doSome2();
	}
}