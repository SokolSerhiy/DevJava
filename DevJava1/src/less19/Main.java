package less19;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

import org.omg.Messaging.SyncScopeHelper;

import less16.Person;

public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		print1(array, (int i)->true);
		System.out.println();
		print1(array, (i)->i%2==0);
		System.out.println();
		print1(array, e->e%3==0);
		List<Person> persons = new ArrayList<>();
		persons.sort(getComparator(0));
		persons.forEach((p)->System.out.println(p));
		persons.forEach(System.out::println);
		persons.sort(Comparator.comparing(p->p.getName()));
		persons.sort(Comparator.comparing(Person::getName).reversed());
		int sum = persons.stream()
			.filter(Objects::nonNull)
			.filter(p->p.getPets().size()>=3)
			.map(Person::getPets)
			.flatMap(List::stream)
			.filter(Objects::nonNull)
			.map(Person.Pet::getName)
			.flatMapToInt(String::chars)
			.reduce(0, Integer::sum);
		System.out.println(sum);
		int count = (int) persons.stream()
				.filter(p->p.getName().startsWith("A")).count();
		Set<Person> set = persons.stream().collect(Collectors.toSet());
	}
	
	static void print1(int[] array, IntPredicate filter){
		for (int i : array) {
			if(filter.test(i))System.out.print(i+" ");
		}
	}
	
	static Comparator<Person> getComparator(int key){
		switch (key) {
		case 0:return (o1, o2)->o1.getAge()-o2.getAge();
		case 1:return (o1, o2)->o2.getAge()-o1.getAge();
		case 2:return (o1, o2)->o1.getName().compareTo(o2.getName());
		default: throw new IllegalArgumentException("o-2");
		}
	}
	
	
//	static void print2(int[] array){
//		for (int i : array) {
//			if(i%2==0)System.out.print(i+" ");
//		}
//	}
//	
//	static void print3(int[] array){
//		for (int i : array) {
//			if(i%3==0)System.out.print(i+" ");
//		}
//	}
}
