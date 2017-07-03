package less18;

import java.util.Comparator;

import less18.Person.Pet;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18);
		Pet pet = person.new Pet("Barsik");
		Person person2 = new Person("Mykola", 25);
		Pet pet2 = person2.new Pet("Barsik");
		System.out.println(pet.equals(pet2));
		System.out.println(person);
//		person.getPets().add(pet);
//		System.out.println(person);
		Person person3 = new Person.Builder()
				.age(26)
				.name("Petro")
				.pet("Barsik")
				.pet("Tuzik")
				.pet("Komposter")
				.build();
		System.out.println(person3);
		person3.getPets().sort(getComparator(1));
		System.out.println(person3);
	}

	static Comparator<Pet> getComparator(final int rev){
		return new Comparator<Pet>() {
			@Override
			public int compare(Pet o1, Pet o2) {
				return rev*o1.getName().compareTo(o2.getName());
			}
		};
	}
	
	static Comparator<Pet> getComparator1(int rev){
		class Comp implements Comparator<Pet>{
			@Override
			public int compare(Pet o1, Pet o2) {
				return rev*o1.getName().compareTo(o2.getName());
			}
		}
		return new Comp();
	}
}
