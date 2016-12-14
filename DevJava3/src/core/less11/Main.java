package core.less11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import core.less6.Gender;
import core.less6.Person;

public class Main {

	public static void main(String[] args) {
		Map<String, List<Person>> map = new HashMap<>();
		// map.put("Manager", new Person("Ivan", 18, Gender.MALE));
		// map.put("Engeneer", new Person("Mykola", 25, Gender.MALE));
		// map.put("Manager", new Person("Petro", 23, Gender.MALE));
		// System.out.println(map.get("Manager"));
		// map.put("Manager", new ArrayList<>());
		// map.put("Engeneer", new ArrayList<>());
		// map.get("Manager").add(new Person("Ivan", 18, Gender.MALE));
		// map.get("Manager").add(new Person("Petro", 23, Gender.MALE));
		// map.get("Engeneer").add(new Person("Mykola", 25, Gender.MALE));
		// System.out.println(map);
		// Set<Entry<String, List<Person>>> entrySet = map.entrySet();
		// for (Entry<String, List<Person>> entry : entrySet) {
		// String key = entry.getKey();
		// for (Person person : entry.getValue()) {
		// System.out.println(key+" -> "+person);
		// }
		// }
		// System.out.println();
		// Set<String> keySet = map.keySet();
		// for (String key : keySet) {
		// for(Person person : map.get(key)){
		// System.out.println(key+" -> "+person);
		// }
		// }
		// System.out.println();
		// map.forEach((key, value)->value
		// .forEach(person->System.out.println(key+" -> "+person)));
		//
		// Integer a = 50;
		// Integer b = 50;
		// Integer a1 = 200;
		// Integer b1 = 200;
		// System.out.println(a==b);
		// System.out.println(a1==b1);
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter 1 to add proffesion");
			System.out.println("Enter 2 to add person");
			System.out.println("Enter 3 to show all persons");
			System.out.println("Enter 4 to show persons by proffesion");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter proffesion");
				map.put(sc.next(), new ArrayList<>());
				break;
			case "2":
				System.out.println("Enter proffesion");
				String prof = sc.next();
				if(map.containsKey(prof)){
					System.out.println("Enter name");
					String name = sc.next();
					System.out.println("Enter age");
					int age = sc.nextInt();
					System.out.println("Enter gender");
					Gender gender = Gender.valueOf(sc.next().toUpperCase());
					map.get(prof).add(new Person(name, age, gender));
				}else{
					System.out.println("Proffesion does not exist");
				}
				break;
			case "3":
				map.forEach((key, value)->value
						.forEach(person->System.out.println(key+" -> "+person)));
				break;
			case "4":
				System.out.println("Enter proffesion");
				List<Person> list = map.get(sc.next());
				if(list!=null)list.forEach(System.out::println);
				break;
			default:
				sc.close();
				return;
			}
		}
	}
}