package core.less9;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import core.less6.Gender;
import core.less6.Person;

public class Main {

	public static void main(String[] args) {
		Set<Person> set = new HashSet<>();
		set.add(new Person("Ivan", 18, Gender.MALE));
		set.add(new Person("Mykola", 25, Gender.MALE));
		set.add(new Person("Petro", 30, Gender.MALE));
		System.out.println(set);
		set.add(new Person("Petro", 30, Gender.MALE));
		System.out.println(set);
		Set<String>	set2 = new TreeSet<>();
		set2.add("Mykola");
		set2.add("Ivan");
		set2.add("Petro");
		System.out.println(set2);
	}
}