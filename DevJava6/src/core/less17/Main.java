package core.less17;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntPredicate;

import core.less14.Person;

public class Main {
	
	static Person p = new Person("Ivan", 18);

	public static void main(String[] args) {
		print((int i) -> true);
		print((i) -> i%2==0);
		print(Main::test);
		printSomeFromPerson(Person::getPets);
		List<Person> list = new ArrayList<>();
		int sum = list.stream()
			.map(Person::getPets)
			.filter(l->l.size()>=3)
			.flatMap(List::stream)
			.map(Person.Pet::getName)
			.distinct()
			.filter(s->s.length()>=10)
			.flatMapToInt(String::chars)
			.reduce(0, Integer::sum);
		
		int sum2 = 0;
		for (Person person : list) {
			if(person.getPets().size()>=3){
				for(Person.Pet pet : person.getPets()){
					if(pet.getName().length()>=10){
						for(char ch : pet.getName().toCharArray()){
							sum2+=ch;
						}
					}
				}
			}
		}
		
	}
	
	static void printSomeFromPerson(Function<Person, ?> function){
		System.out.println(function.apply(p));
	}
	
	static boolean test(int i){
		//kjhfjhdfdjhf
		//ldkjfkdjf
		return i%3==0;
	}
	
	static void print(IntPredicate filter){
		for (int i = 1; i <= 10; i++) {
			if(filter.test(i))
			System.out.println(i);
		}
		System.out.println();
	}
	
	class Asdf implements IntPredicate{
		@Override
		public boolean test(int value) {
			return Main.test(value);
		}
	}
	
//	static void print1(){
//		for (int i = 1; i <= 10; i++) {
//			if(i%2==0)
//			System.out.println(i);
//		}
//		System.out.println();
//	}
//	
//	static void print2(){
//		for (int i = 1; i <= 10; i++) {
//			if(i%3==0)
//			System.out.println(i);
//		}
//		System.out.println();
//	}
}