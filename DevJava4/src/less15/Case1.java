package less15;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import less11.Person;

public class Case1 implements Case{

	private final Scanner sc;
	
	private final Map<Profession, List<Person>> map;

	public Case1(Scanner sc, Map<Profession, List<Person>> map) {
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
		return true;
	}
}
