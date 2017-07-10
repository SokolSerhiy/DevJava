package less21;

import java.lang.reflect.Constructor;
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
		
		Object person = new Person("Ivan", 18);
		Field ageField = personClass.getDeclaredField("age");
		Field nameField = personClass.getDeclaredField("name");
		ageField.setAccessible(true);
		nameField.setAccessible(true);
		Object age = ageField.get(person);
		Object name = nameField.get(person);
		System.out.println(name+" "+age);
		
		Object person2 = personClass.newInstance();
		ageField.set(person2, age);
		nameField.set(person2, name);
		System.out.println(person2);
		
		Method getAge = personClass.getMethod("getAge");
		Method getName = personClass.getMethod("getName");
		
		Object age1 = getAge.invoke(person);
		Object name1 = getName.invoke(person);
		
		System.out.println(name1+" "+age1);
		
		Method setAge = personClass.getMethod("setAge", int.class);
		Method setName = personClass.getMethod("setName", String.class);
		
		Object person3 = personClass.newInstance();
		setAge.invoke(person3, age1);
		setName.invoke(person3, name1);
		System.out.println(person3);
		
		Class<?>[] params = {String.class, int.class};
		Constructor<?> constructor = personClass.getConstructor(params);
		Object person4 = constructor.newInstance(name1, age1);
		System.out.println(person4);
		
		Object obj = Work.class.newInstance();
		IWork iWork = (IWork)Proxy.newProxyInstance(
				Work.class.getClassLoader(),
				Work.class.getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Method classMethod = Work.class.getDeclaredMethod(method.getName(), method.getParameterTypes());
						if(classMethod.isAnnotationPresent(Wrapper.class)){
							System.out.println(classMethod.getAnnotation(Wrapper.class).before());
							Object res = method.invoke(obj, args);
							System.out.println(classMethod.getAnnotation(Wrapper.class).after());
							return res;
						}
						return method.invoke(obj, args);
					}
				});
		System.out.println();
		iWork.doWork1();
		iWork.doWork2();
	}
}