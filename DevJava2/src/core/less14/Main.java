package core.less14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import core.less14.Person.Pet;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18, Gender.MALE);
		Person person1 = new Person("Petro", 25, Gender.MALE);
		Pet pet = person.new Pet("Barsik");
		Pet pet1 = person1.new Pet("Barsik");
		System.out.println(pet.equals(pet1));
		System.out.println(pet.getOuterType().equals(person));
		Person person2 = new Person.Builder()
			.age(18)
			.gender(Gender.MALE)
			.name("Mykola")
			.pet("Barsik")
			.pet("Tuzik")
			.pet("Komposter").build();
		System.out.println(person2);
		System.out.println(person);
		List<String> list = new ArrayList<>();
		list.sort(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		Object object = new Object(){
			@Override
			public boolean equals(Object obj) {
				System.out.println("Hello");
				return super.equals(obj);
			}
		};
		object.equals(person2);
		Comparator<String> comparator = local();
	}
	
	static Comparator<String> local(){
		class Asdf implements Comparator<String>{
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		}
		return new Asdf();
	}

}
