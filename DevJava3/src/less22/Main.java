package less22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;

import less18.Person;

public class Main {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		print(array, (int element) -> true);
		System.out.println();
		print(array, (e) -> e % 2 == 0);
		System.out.println();
		print(array, e -> e % 3 == 0);
		Person person = new Person.Builder()
				.age(18)
				.name("Ivan")
				.pet("Barsik")
				.pet("Tuzik")
				.pet("Barbos")
				.build();
		List<Person> persons = new ArrayList<>(Arrays.asList(person));
		int sum = persons.parallelStream()
			.map(Person::getPets)
			.filter(Objects::nonNull)
			.filter(list->list.size()>=3)
			.flatMap(List::stream)
			.map(Person.Pet::getName)
			.filter(Objects::nonNull)
			.flatMapToInt(String::chars)
			.reduce(0, (acc, e)->{
				System.out.println(acc+" "+e);
				return acc+e;
			});
		System.out.println(sum);
		sum = 0;
		for (Person person2 : persons) {
			List<Person.Pet> pets = person2.getPets();
			if(pets!=null&&pets.size()>=3){
				for (Person.Pet pet : pets) {
					if(pet.getName()!=null){
						for(int i = 0; i < pet.getName().length(); i++){
							sum+=pet.getName().codePointAt(i);
						}
					}
				}
			}
		}
		System.out.println(sum);
		persons.stream()
			.filter(p->p.getName().startsWith("A"))
			.forEach(Main::changeSome);
		persons.sort(Comparator.comparing(Person::getName).reversed().thenComparingInt(Person::getAge).reversed());
	}
	
	static void changeSome(Person person){
		person.setAge(3);
	}
	
	static void print(int[] array, IntPredicate filter) {
		for (int i = 0; i < array.length; i++) {
			if (filter.test(array[i]))
				System.out.println(array[i]);
		}
	}

}