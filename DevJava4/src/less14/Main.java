package less14;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import less11.Gender;
import less11.Person;

public class Main {

	public static void main(String[] args) {
		Set<Person> persons = new TreeSet<>(new PersonComparatorByNameDesc());
		System.out.println(persons.add(new Person("Ivan", 18, Gender.MALE)));
		System.out.println(persons.add(new Person("Ivan", 19, Gender.MALE)));
		persons.add(new Person("Petro", 23, Gender.MALE));
		persons.add(new Person("Mykola", 25, Gender.MALE));
		System.out.println(persons);
		System.out.println("AaAaAaAa".hashCode());
		System.out.println("AaAaAaBB".hashCode());
		System.out.println("AaAaBBAa".hashCode());
		List<Person> personsList = new ArrayList<>();
		personsList.add(new Person("Ivan", 18, Gender.MALE));
		personsList.add(new Person("Petro", 23, Gender.MALE));
		personsList.add(new Person("Mykola", 25, Gender.MALE));
		for (Person person : personsList) {
			System.out.println(person);
		}
		System.out.println();
		personsList.sort(null);
		for (Person person : personsList) {
			System.out.println(person);
		}
		System.out.println();
		personsList.sort(new PersonComparatorByNameDesc());
		for (Person person : personsList) {
			System.out.println(person);
		}
		System.out.println();
		personsList.sort((o1,o2)->Integer.compare(o1.getAge(), o2.getAge()));
		for (Person person : personsList) {
			System.out.println(person);
		}
		System.out.println();
	}
}