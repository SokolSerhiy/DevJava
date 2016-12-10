package core.less10;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import core.less6.Gender;
import core.less6.Person;

public class Main {

	private static final Scanner SC = new Scanner(System.in);
	private static final List<Person> list = new ArrayList<>();
	
	public static void main(String[] args) {
		list.add(new Person("Mariya", 21, Gender.FEMALE));
		list.add(new Person("Ivan", 18, Gender.MALE));
		list.add(new Person("Oksana", 19, Gender.FEMALE));
		list.add(new Person("Mykola", 21, Gender.MALE));
		list.add(new Person("Olya", 24, Gender.FEMALE));
		list.add(new Person("Petro", 30, Gender.MALE));
		list.add(new Person("Artem", 45, Gender.MALE));
		list.add(new Person("Ira", 38, Gender.FEMALE));
		list.add(new Person("Zlata", 40, Gender.FEMALE));
		list.add(new Person("Sergiy", 25, Gender.MALE));
		while (true) {
			System.out.println("Enter 1 to sort by name asc");
			System.out.println("Enter 2 to sort by name desc");
			System.out.println("Enter 3 to sort by age asc");
			System.out.println("Enter 4 to sort by age desc");
			switch (SC.next()) {
			case "1":
				sortByNameAsc().forEach(System.out::println);
				break;
			case "2":
				sortByNameDesc().forEach(System.out::println);
				break;
			case "3":
				sortByAgeAsc().forEach(System.out::println);
				break;
			case "4":
				sortByAgeDesc().forEach(System.out::println);
				break;
			default:
				SC.close();
				return;
			}
		}
	}
	
	static Stream<Person> sortByNameAsc(){
//		List<Person> persons = new ArrayList<>(list);
//		persons.sort(null);
//		return persons;
		return list.stream().sorted();
	}
	
	static Stream<Person> sortByNameDesc(){
//		List<Person> persons = new ArrayList<>(list);
//		persons.sort(new PersonComparatorByNemaDesc());
//		return persons;
		return list.stream()
				.sorted((o1, o2)->o2.getName().compareTo(o1.getName()));
	}
	
	static Stream<Person> sortByAgeAsc(){
		return list.stream()
		.sorted(comparingInt(Person::getAge));
	}
	
	static Stream<Person> sortByAgeDesc(){
		return list.stream()
		.sorted(comparingInt(Person::getAge).reversed());
	}
	
	static Stream<Person> sortByAllDesc(){
		return list.stream()
		.sorted(comparing(Person::getName).reversed()
		.thenComparing(comparingInt(Person::getAge)).reversed()
		.thenComparing(Person::getGender).reversed());
	}
}
