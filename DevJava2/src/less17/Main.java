package less17;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import less16.Person;

public class Main {

	public static void main(String[] args) throws ReflectiveOperationException {
		String fullClassName = "less16.Person";
		Class<?> someClass = Class.forName(fullClassName);
		Field[] fields = someClass.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName()+" "+field.getGenericType());
		}
		
		Object person = new Person("Ivan", 18);
		System.out.println(person);
		
		Field ageField = someClass.getDeclaredField("age");
		ageField.setAccessible(true);
		Object age = ageField.get(person);
		System.out.println(age);
		
		Field nameField = someClass.getDeclaredField("name");
		nameField.setAccessible(true);
		Object name = nameField.get(person);
		System.out.println(name);
		
		Object personFromDB1 = someClass.newInstance();
		System.out.println(personFromDB1);
		ageField.set(personFromDB1, age);
		nameField.set(personFromDB1, name);
		System.out.println(personFromDB1);
		
		Method getAge = someClass.getDeclaredMethod("getAge");
		Method getName = someClass.getDeclaredMethod("getName");
		age = getAge.invoke(person);
		name = getName.invoke(person);
		System.out.println(name+" "+age);
		System.out.println(age.getClass().getName());
		
		Method setAge = someClass.getDeclaredMethod("setAge", int.class);
		Method setName = someClass.getDeclaredMethod("setName", String.class);
		Person personFromDB2 = Person.class.newInstance();
		setAge.invoke(personFromDB2, age);
		setName.invoke(personFromDB2, name);
		System.out.println(personFromDB2);
		
		SomeI some = new SomeC();
		some.aaaa();
		some.bbbb();
		some.cccc();
		
		SomeI someProxy = (SomeI) Proxy.newProxyInstance(some.getClass().getClassLoader(), some.getClass().getInterfaces(), new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				if(some.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(CustomLogic.class)) System.out.println("before");
				Object res = method.invoke(some, args);
				if(some.getClass().getMethod(method.getName(), method.getParameterTypes()).isAnnotationPresent(CustomLogic.class))  System.out.println("after");
				return res;
			}
		});
		System.out.println();
		someProxy.aaaa();
		someProxy.bbbb();
		someProxy.cccc();
	}
}