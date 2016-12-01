package core.less9;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import core.less6.Gender;
import core.less6.Person;

public class Main {

	public static void main(String[] args) {
		Set<Person> persons = new HashSet<>();
		persons.add(new Person(18, "Ivan", Gender.MALE));
		persons.add(new Person(25, "Petro", Gender.MALE));
		persons.add(new Person(30, "Mykola", Gender.MALE));
		System.out.println(persons);
		persons.add(new Person(30, "Mykola", Gender.MALE));
		System.out.println(persons);
		Set<String> set = new TreeSet<>();
		set.add("Ivan");
		set.add("Petro");
		set.add("Mykola");
		System.out.println(set);
	}
}