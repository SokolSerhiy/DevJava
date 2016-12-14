package core.less14;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;

import core.less14.Person.Pet;

public class Main {

	public static void main(String[] args) {
		Person person = new Person(18, "Ivan", Gender.MALE);
		Person person1 = new Person(23, "Petro", Gender.MALE);
		Pet pet = person.new Pet("Barsik");
		person.getPets().add(pet);
		Pet pet1 = person1.new Pet("Barsik");
		System.out.println(pet.equals(pet1));
		Person person2 = new Person.Builder()
			.age(18)
			.gender(Gender.MALE)
			.name("Mykola")
			.pet("Barsik")
			.pet("Mursik")
			.pet("Komposter").build();
		System.out.println(person2);
		person2.getPets().sort(new Comparator<Pet>() {
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		local();
		
		Object object = new Object(){
			public boolean equals(Object obj) {
				System.out.println("Crazy object");
				return super.equals(obj);
			}
		};
		object.equals(person2);
	}

	static Serializable local(){
		class Asdf implements Serializable{
			public void print(){
				System.out.println("Hello");
				class Asdfg{
					public void print(){
						System.out.println("Crazy");
					}
				}
				new Asdfg().print();
			}
		}
		return new Asdf();
	}
}