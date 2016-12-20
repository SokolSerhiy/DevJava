package core.less18;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntPredicate;

import core.less14.Person;

public class Main {

	public static void main(String[] args) {
		print(i -> true);
		System.out.println();
		print(Main::support);
//		System.out.println();
//		print(new Support());
		System.out.println();
		print(i -> i % 3 == 0);
		
		List<Person> list = new ArrayList<>();
		int sum = list.stream()
//			.filter(p->p.getPets().size()>=3)
			.map(Person::getPets)
			.filter(Objects::nonNull)
			.filter(l->l.size()>=3)
			.flatMap(List::stream)
//			.filter(p->p.getName().length()>=10)
			.map(Person.Pet::getName)
			.filter(Objects::nonNull)
			.filter(n->n.length()>=10)
			.flatMapToInt(String::chars)
			.reduce(0, Integer::sum);
		
		int sum2 = 0;
		for (Person person : list) {
			if(person.getPets()!=null&&person.getPets().size()>=3){
				for(Person.Pet pet : person.getPets()){
					if(pet.getName()!=null&&pet.getName().length()>=10){
						for(char ch : pet.getName().toCharArray()){
							sum2+=ch;
						}
					}
				}
			}
		}
		
	}
	
	static class Support implements Filter{
		@Override
		public boolean test(int i) {
			return Main.support(i);
		}
	}
	
	static boolean support(int i){
		return i % 2 == 0;
	}
	
	static void print(IntPredicate filter){
		for (int i = 1; i <= 10; i++) {
			if(filter.test(i))
			System.out.println(i);
		}
	}
}