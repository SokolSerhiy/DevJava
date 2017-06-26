package less15;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import less11.Person;

public class Case3 implements Case{

	private final Map<Profession, List<Person>> map;

	public Case3(Map<Profession, List<Person>> map) {
		this.map = map;
	}

	@Override
	public boolean doWork() {
		Set<Entry<Profession, List<Person>>> set = map.entrySet();
		for (Entry<Profession, List<Person>> entry : set) {
			for (Person person : entry.getValue()){
				System.out.println(entry.getKey()+ " "+ person);
			}
			if(entry.getValue().isEmpty()) System.out.println(entry.getKey());
		}
		return true;
	}
}
