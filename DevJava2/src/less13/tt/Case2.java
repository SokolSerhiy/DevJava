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
		System.out.println("Enter profession title");
		String name = sc.next();
		Profession current = new Profession(name);
		if(map.containsKey(current)){
			Set<Profession> keySet = map.keySet();
			for (Profession profession : keySet) {
				if(profession.equals(current)){
					current = profession;
				}
			}
			System.out.println("Enter person name");
			String personName = sc.next();
			System.out.println("Enter min payment bigger then "+current.getMinPayment());
			int payment = sc.nextInt();
			map.get(current).add(new Person(personName, payment));
		}else{
			System.out.println("That profession does not exist");
		}
		return true;
	}
}
