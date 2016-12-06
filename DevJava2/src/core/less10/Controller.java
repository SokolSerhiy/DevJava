package core.less10;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Controller {

	private final List<Person> persons = new ArrayList<>();

	{
		persons.add(new Person("Mariya", 21, Gender.FEMALE));
		persons.add(new Person("Ivan", 18, Gender.MALE));
		persons.add(new Person("Oksana", 19, Gender.FEMALE));
		persons.add(new Person("Mykola", 21, Gender.MALE));
		persons.add(new Person("Olya", 24, Gender.FEMALE));
		persons.add(new Person("Petro", 30, Gender.MALE));
		persons.add(new Person("Artem", 45, Gender.MALE));
		persons.add(new Person("Ira", 38, Gender.FEMALE));
		persons.add(new Person("Zlata", 40, Gender.FEMALE));
		persons.add(new Person("Sergiy", 25, Gender.MALE));
	}
	
	public List<Person> sortByNameASC(){
//		List<Person> list = new ArrayList<>(persons);
//		list.sort(null);
		return persons.stream().sorted().collect(Collectors.toList());
	}
	
	public List<Person> sortByNameDESC(){
//		List<Person> list = new ArrayList<>(persons);
//		list.sort(new PersonComparatorByNameDESC());
		return persons.stream()
			.sorted(Comparator.comparing(Person::getName)
			.reversed()).collect(Collectors.toList());
	}
	
	public Stream<Person> sortByAgeASC(){
		return persons.stream()
				.sorted(Comparator.comparingInt(Person::getAge));
	}
	
	public Stream<Person> sortByAgeDESC(){
		return persons.stream()
				.sorted(Comparator.comparingInt(Person::getAge).reversed());
	}
	
	public Stream<Person> sortByGenderASC(){
		return persons.stream()
				.sorted(Comparator.comparing(Person::getGender));
	}
	
	public Stream<Person> sortByGenderDESC(){
		return persons.stream()
				.sorted(Comparator.comparing(Person::getGender).reversed());
	}
	
	public Stream<Person> sortByAllFieldsDESC(){
		return persons.stream()
		.sorted(Comparator.comparing(Person::getName).reversed()
		.thenComparing(Comparator.comparingInt(Person::getAge).reversed()
		.thenComparing(Comparator.comparing(Person::getGender).reversed())));
	}

	public List<Person> getPersons() {
		return persons;
	}
}