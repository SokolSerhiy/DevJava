package less15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import less11.Gender;
import less11.Person;

public class Main {

	public static void main(String[] args) {
//		Map<String, Person> map = new HashMap<>();
//		map.put("engineer", new Person("Ivan", 18, Gender.MALE));
//		System.out.println(map);
//		System.out.println(map.get("engineer"));
//		map.put("engineer", new Person("Mykola", 26, Gender.MALE));
//		System.out.println(map);
		Map<String, List<Person>> map = new HashMap<>();
		map.put("engineer", new ArrayList<>());
		map.get("engineer").add(new Person("Ivan", 18, Gender.MALE));
		map.get("engineer").add(new Person("Mykola", 26, Gender.MALE));
		System.out.println(map);
		
		Set<Entry<String, List<Person>>> entrySet = map.entrySet();
		for (Entry<String, List<Person>> entry : entrySet) {
			for(Person person : entry.getValue()){
				System.out.println(entry.getKey() + " " + person);
			}
		}
		
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			for(Person person : map.get(key)){
				System.out.println(key + " " + person);
			}
		}
		
		System.out.println(map.remove("engineer"));
		System.out.println(map);
	}
}