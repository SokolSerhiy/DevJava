package less19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import less16.Person;
import less16.Person.Pet;

public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		print(array, (int i) -> true);
		System.out.println();
		print(array, (i) -> i%2==0);
		System.out.println();
		print(array, e -> e%3==0);
		List<Person> persons = new ArrayList<>();
		persons.forEach((p)->System.out.println(p));
		persons.forEach(System.out::println);
		persons.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
		persons.sort(Comparator.comparing(Person::getName));
		Person person1 = new Person.Builder()
				.age(18)
				.name("Ivan")
				.pet("Barsik")
				.pet("Tuzik")
				.pet("Komposter")
				.build();
		persons.add(person1);
		int sum = 0;
		for (Person person : persons) {
			if(person.getPets()!=null&&person.getPets().size()>=3){
				for(Person.Pet pet : person.getPets()){
					if(pet.getName()!=null){
						for(int i = 0; i < pet.getName().length(); i++){
							sum+=pet.getName().codePointAt(i);
						}
					}
				}
			}
		}
		System.out.println();
		sum = persons.stream()
				.map(Person::getPets)
				.filter(Objects::nonNull)
				.filter(l->l.size()>=3)
				.flatMap(List::stream)
				.map(Person.Pet::getName)
				.filter(Objects::nonNull)
				.flatMapToInt(String::chars)
				.reduce(0, (acc, e)->{
					System.out.println(acc+" "+e+" "+(char)e);
					return acc+e;
				});
		System.out.println(sum);
		Set<Person> set = persons.stream().collect(Collectors.toSet());
		long count = persons.stream()
				.filter(p->p.getName().startsWith("A")||p.getName().startsWith("a")).count();
		persons = persons.stream().distinct().collect(Collectors.toList());
		Optional<List<Pet>> optional = persons.stream()
				.map(Person::getPets)
				.max(Comparator.comparingInt(List::size));
		
	}
	
	static boolean nonNull(Object o){
		return o!=null;
	}
	
	
	static void print(int[] array, IntPredicate filter){
		for (int i : array) {
			if(filter.test(i))System.out.print(i+" ");
		}
	}
}
