package less13.tt;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Case1 implements Case{

	private final Scanner sc;

	private final Map<Profession, List<Person>> map;
	
	public Case1(Scanner sc, Map<Profession, List<Person>> map) {
		this.sc = sc;
		this.map = map;
	}

	@Override
	public boolean work() {
		System.out.println("Enter profession title");
		String name = sc.next();
		if(map.containsKey(new Profession(name))){
			System.out.println("That profession already exist");
		}else{
			System.out.println("Enter min payment");
			int minPayment = sc.nextInt();
			map.put(new Profession(name, minPayment), new ArrayList<>());
		}
		return true;
	}

}
