package less15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import less11.Gender;
import less11.Person;

public class Case2 implements Case{

	private final Scanner sc;
	
	private final Map<Profession, List<Person>> map;

	public Case2(Scanner sc, Map<Profession, List<Person>> map) {
		this.sc = sc;
		this.map = map;
	}

	@Override
	public boolean doWork() {
		System.out.println("Enter profession name");
		String name = sc.next();
		Profession profession = new Profession(name);
		if(!map.containsKey(profession)){
			map.put(profession, new ArrayList<>());
		}
		System.out.println("Enter name");
		String personName = sc.next();
		System.out.println("Enter age");
		int age = sc.nextInt();
		System.out.println("Enter gender");
		Gender gender = Gender.valueOf(sc.next().toUpperCase());
		map.get(profession).add(new Person(personName, age, gender));
		return true;
	}
	
	
}
