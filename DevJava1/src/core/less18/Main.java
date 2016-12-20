package core.less18;

import java.util.ArrayList;
import java.util.List;

import core.less14.Person;
import core.less14.Person.Pet;


public class Main {

	public static void main(String[] args) {
		print(i -> true);
		System.out.println();
		print(Main::divBy2);
		System.out.println();
		print(i -> i % 3 == 0);
		
		List<Person> list = new ArrayList<>();
		list.add(new Person.Builder()
			.pet("Gsgdfgsfdgf").pet("Gsgdfgsfdgf")
			.pet("Gsgdfgsfdgf").build());
		int sum = list.stream()
				.filter((person)->person.getPets().size()>=3)
				.map(Person::getPets)
				.flatMap(List::stream)
				.map(Pet::getName)
				.filter(str->str.length()>=10)
				.flatMapToInt(String::chars)
				.reduce(0, Integer::sum);
		int sum2 = 0;
		for (Person person : list) {
			if(person.getPets().size()>=3){
				for(Pet pet : person.getPets()){
					if(pet.getName().length()>=10){
						for(char ch : pet.getName().toCharArray()){
							sum2+=ch;
						}
					}
				}
			}
		}
		System.out.println(sum+" "+sum2);
	}
	
	class Add implements Filter{
		@Override
		public boolean accept(int i) {
			return Main.divBy2(i);
		}
	}
	
	static boolean divBy2(int i){
		return i % 2 == 0;
	}

	static void print(Filter filter) {
		for (int i = 1; i <= 10; i++) {
			if (filter.accept(i))
				System.out.println(i);
		}
	}
}