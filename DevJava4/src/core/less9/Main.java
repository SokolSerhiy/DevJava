package core.less9;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import core.less6.Gender;
import core.less6.Person;

public class Main {

	public static void main(String[] args) {
		Set<Person> set = new LinkedHashSet<>();
		set.add(new Person("Mariya", 21, Gender.FEMALE));
		set.add(new Person("Ivan", 18, Gender.MALE));
		set.add(new Person("Mykola", 21, Gender.MALE));
		System.out.println(set.add(new Person("Mykola", 21, Gender.MALE)));
		System.out.println(set);
		Set<String> tree = new TreeSet<>();
		tree.add("Mariya");
		tree.add("Ivan");
		tree.add("Mykola");
		System.out.println(tree);
	}
}