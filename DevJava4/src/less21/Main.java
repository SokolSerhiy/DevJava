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
		
		Object person = new Person("Ivan", 18);
		
		Field ageField = personClass.getDeclaredField("age");
		Field nameField	= personClass.getDeclaredField("name");
		ageField.setAccessible(true);
		nameField.setAccessible(true);
		Object age = ageField.get(person);
		Object name = nameField.get(person);
		System.out.println(name+" "+age);
		
		Object person2 = personClass.newInstance();
		ageField.set(person2, age);
		nameField.set(person2, name);
		System.out.println(person2);
		
		Method getName = personClass.getMethod("getName");
		Method getAge = personClass.getMethod("getAge");
		
		Object age1 = getAge.invoke(person);
		Object name1 = getName.invoke(person);
		System.out.println(name1+" "+age1);
		
		Object person3 = personClass.newInstance();
		Method setName = personClass.getMethod("setName", String.class);
		Method setAge = personClass.getMethod("setAge", int.class);
		
		setAge.invoke(person3, age1);
		setName.invoke(person3, name1);
		System.out.println(person3);
		
		Object work = Work.class.newInstance();
		IWork iWork = (IWork)Proxy.newProxyInstance(
				Work.class.getClassLoader(),
				Work.class.getInterfaces(),
				new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Method classMethod = Work.class.getDeclaredMethod(method.getName(), method.getParameterTypes());
						if(classMethod.isAnnotationPresent(Wrapper.class)){
							System.out.println(classMethod.getAnnotation(Wrapper.class).before());
							Object res = method.invoke(work, args);
							System.out.println(classMethod.getAnnotation(Wrapper.class).after());
							return res;
						}
						return method.invoke(work, args);
					}
				});
		iWork.doWork1();
		iWork.doWork2();
		int[] arr = {1, 2};
		add(arr);
	}
	
	static void add(Integer a, Integer b){
		System.out.println("Integer");
	}
	
	static void add(long a, long b){
		System.out.println("long");
	}
	
	static void add(int... a){
		System.out.println("int array");
	}
}