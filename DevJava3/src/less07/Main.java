package less07;

public class Main {

	public static void main(final String[] args) {
		Person.printCount();
		Person person = new Person();
		person.setAge(18);
		person.setName("Ivan");
		System.out.println(person);
		System.out.println(person.getName()+" "+person.getAge());
		
		final ValueObject obj = new ValueObject(36, "Red");
		System.out.println(obj);
		ValueObject obj1 = obj.reColor("Black");
//		System.gc();
//		System.gc();
		System.out.println(obj1);
		Person person1 = new Person();
		Person.printCount();
	}
}
