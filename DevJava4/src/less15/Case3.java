package less15;

import java.util.List;
import java.util.Map;

import less11.Person;

public class Case3 implements Case{

	private final Map<Profession, List<Person>> map;

	public Case3(Map<Profession, List<Person>> map) {
		this.map = map;
	}

	@Override
	public boolean doWork() {
		for (Profession profession : map.keySet()){
			for (Person person : map.get(profession)){
				System.out.println(profession+" -> "+person);
			}
			if(map.get(profession).isEmpty()) System.out.println(profession);
		}
		return true;
	}
	
	
}
