package less21.mysql;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		Person person1  = new Person(26, "Artem");
		person1.save();
		List<Person> persons = Person.findAll();
		for (Person person : persons) {
			System.out.println(person);
		}
	}

}
