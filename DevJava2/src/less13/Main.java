package less13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import less12.Person;

public class Main {

	public static void main(String[] args) {
//		Map<String, Person> map = new HashMap<>();
//		map.put("engineer", new Person(36, "Ivan"));
//		map.put("cleaner", new Person(19, "Petro"));
//		System.out.println(map);
//		map.put("engineer", new Person(35, "Mykola"));
//		System.out.println(map);
//		System.out.println(map.get("engineer"));
//		System.out.println("AaAaAaAa".hashCode());
//		System.out.println("AaAaAaBB".hashCode());
//		System.out.println("AaAaBBAa".hashCode());
//		System.out.println("AaAaBBBB".hashCode());
		Map<String, List<Person>> map = new HashMap<>();
		map.put("engineer", new ArrayList<>());
		map.get("engineer").add(new Person(36, "Ivan"));
		map.get("engineer").add(new Person(35, "Mykola"));
		map.put("cleaner", new ArrayList<>());
		map.get("cleaner").add(new Person(19, "Petro"));
		System.out.println(map);
		
		Set<Entry<String, List<Person>>> entrySet = map.entrySet();
		for (Entry<String, List<Person>> entry : entrySet) {
			for(Person person : entry.getValue()){
				System.out.println(entry.getKey()+" "+person);
			}
		}
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			for(Person person : map.get(key)){
				System.out.println(key+" "+person);
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
