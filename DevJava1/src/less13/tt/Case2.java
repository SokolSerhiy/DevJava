package less13.tt;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Case2 implements Case{

	private final Scanner sc;
	
	private final Map<Profession, List<Person>> map;
	
	public Case2(Scanner sc, Map<Profession, List<Person>> map) {
		this.sc = sc;
		this.map = map;
	}
	
	@Override
	public boolean work() {
		System.out.println("Enter title of profession");
		String name = sc.next();
		if(map.containsKey(new Profession(name))){
			Set<Profession> professions = map.keySet();
			Profession curent = null;
			for (Profession profession : professions) {
				if(profession.equals(new Profession(name))){
					curent = profession;
				}
			}
			System.out.println("Enter name of person");
			String personName = sc.next();
			System.out.println("Enter payment bigger that "+curent.getMinPayment());
			int payment = sc.nextInt();
			map.get(curent).add(new Person(personName, payment));
		}else{
			System.out.println("That profession does not exist");
		}
		return true;
	}
}
