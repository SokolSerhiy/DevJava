package less12;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static java.util.Comparator.*;

public class Main {

	public static void main(String[] args) {
		Set<Person> persons = new TreeSet<>(new PersonComparatorByNameAsc());
		System.out.println(persons.add(new Person(18, "Ivan")));
		System.out.println(persons.add(new Person(18, "Ivan")));
		persons.add(new Person(25, "Petro"));
		persons.add(new Person(23, "Mykola"));
		persons.forEach(System.out::println);
		System.out.println(new Person(18, "Ivan")==new Person(18, "Ivan"));
		System.out.println("--------------------------------------");
		List<Person> persons2 = new ArrayList<>();
		System.out.println(persons2.add(new Person(18, "Ivan")));
		System.out.println(persons2.add(new Person(18, "Ivan")));
		persons2.add(new Person(25, "Petro"));
		persons2.add(new Person(23, "Mykola"));
		persons2.sort(null);
		persons2.forEach(System.out::println);
		System.out.println(new Person(25, "Petro").compareTo(new Person(26, "Petro")));
		persons2.sort(new PersonComparatorByNameAsc());
		persons2.forEach(System.out::println);
		System.out.println();
		persons2.sort((o1, o2)->o2.getName().compareTo(o1.getName()));
		persons2.sort(comparing(Person::getName).reversed()
				.thenComparingInt(Person::getAge).reversed());
		persons2.forEach(System.out::println);
		//97-122
		List<Person> testList = new ArrayList<>();
		Set<Person> testSet = new HashSet<>();
		for(int i = 0; i < 1000000; i++){
			StringBuilder name = new StringBuilder("");
			for(int j = 0; j < 10; j++){
				name.append((char)random(97, 122));
			}
			Person person = new Person(random(18, 65), name.toString());
			testList.add(person);
			testSet.add(person);
		}
		long start = System.currentTimeMillis();
//		Iterator<Person> iterator = testList.iterator();
//		while(iterator.hasNext()){
//			if(iterator.next().getAge()>35){
//				iterator.remove();
//			}
//		}
		testList.removeIf(e->e.getAge()>35);
		long end = System.currentTimeMillis();
		testList.forEach(System.out::println);
		long listRes = end - start;
		start = System.currentTimeMillis();
		testSet.removeIf(e->e.getAge()>35);
		end = System.currentTimeMillis();
		testSet.forEach(System.out::println);
		long setRes = end - start;
		System.out.println("List res = "+listRes);
		System.out.println("Set res = "+setRes);
	}
			
	static int random(int min, int max){
		return (int)Math.round(Math.random()*(max-min)+min);
	}
}