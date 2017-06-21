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
		System.out.println(persons.add(new Person("Petro", 29, Gender.MALE)));
		System.out.println(persons.add(new Person("Mykola", 25, Gender.MALE)));
		System.out.println(persons);
		System.out.println("AaAaAaAa".hashCode());
		System.out.println("AaAaAaBB".hashCode());
		List<Person> personsList = new ArrayList<>();
		System.out.println(personsList.add(new Person("Ivan", 18, Gender.MALE)));
		System.out.println(personsList.add(new Person("Petro", 29, Gender.MALE)));
		System.out.println(personsList.add(new Person("Mykola", 25, Gender.MALE)));
		for (Person person : personsList) {
			System.out.println(person);
		}
		personsList.sort(null);
		System.out.println();
		for (Person person : personsList) {
			System.out.println(person);
		}
		personsList.sort(new PersonComparatorByNameDesc());
		System.out.println();
		for (Person person : personsList) {
			System.out.println(person);
		}
		personsList.sort((o1, o2)->Integer.compare(o1.getAge(), o2.getAge()));
		System.out.println();
		for (Person person : personsList) {
			System.out.println(person);
		}
	}
}