package core.less11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import core.less10.Gender;
import core.less10.Person;

public class Main {

	public static void main(String[] args) {
		Map<String, List<Person>> map = new HashMap<>();
//		map.put("Engeneer", new Person("Ivan", 25, Gender.MALE));
//		map.put("Manager", new Person("Petro", 20, Gender.MALE));
//		map.put("Engeneer", new Person("Mykola", 25, Gender.MALE));
//		System.out.println(map);
		map.put("Engeneer", new ArrayList<>());
		map.put("Manager", new ArrayList<>());
		map.get("Engeneer").add(new Person("Ivan", 25, Gender.MALE));
		map.get("Engeneer").add(new Person("Mykola", 25, Gender.MALE));
		map.get("Manager").add(new Person("Petro", 20, Gender.MALE));
		System.out.println(map);
		Set<Entry<String, List<Person>>> entrySet = map.entrySet();
		for (Entry<String, List<Person>> entry : entrySet) {
			String key = entry.getKey();
			for (Person person : entry.getValue()){
				System.out.println(key + " -> " + person);
			}
		}
		System.out.println();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			for (Person person : map.get(key)){
				System.out.println(key + " -> " + person);
			}
		}
		System.out.println();
		map.forEach((key, value)->value
			.forEach(person->System.out.println(key + " -> " + person)));
	}
}