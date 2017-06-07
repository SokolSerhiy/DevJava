package less07;

public class Main {

	public static void main(String[] args) {
		System.out.println(Person.count);
		Person person = new Person();
		person.setAge(18);
		person.setName("Ivan");
		System.out.println(person);
		System.out.println(person.getName()+" "+person.getAge());
		
		final ValueObject obj = new ValueObject(36, "Red");
		System.out.println(obj);
		final ValueObject obj1 = obj.reColor("Black");
		System.runFinalizersOnExit(true);
		System.gc();
		System.gc();
		System.out.println(obj1);
		System.out.println(Person.count);
	}
}