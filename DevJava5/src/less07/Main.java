package less07;

public class Main {

	public static void main(String[] args) {
		System.out.println(Person.count);
		Person person = new Person();
		person.setAge(18);
		person.setName("Ivan");
		System.out.println(person);
		System.out.println(person.getName()+" "+person.getAge());
		
		ValueObject obj = new ValueObject(36, "Red");
		System.out.println(obj);
		System.runFinalizersOnExit(true);
		obj = obj.reColor("Black");
		System.out.println(obj);
		System.out.println(Person.count);
	}
}