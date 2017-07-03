package less18;

import java.util.Comparator;

import less18.Person.Pet;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18);
		Pet pet = person.new Pet("Barsik");
		Person person2 = new Person("Mykola", 26);
		Pet pet2 = person2.new Pet("Barsik");
		System.out.println(pet.equals(pet2));
//		person.getPets().add(pet);
		System.out.println(person);
		Person person3 = new Person.Builder()
				.name("Petro")
				.age(19)
				.pet("Barsik")
				.pet("Tuzik")
				.pet("Komposter")
				.build();
		System.out.println(person3);
		person3.getPets().sort(getComparator(-1));
		System.out.println(person3);
	}
	
	static Comparator<Pet> getComparator(int rev){
		return new Comparator<Pet>() {
			public int compare(Pet o1, Pet o2) {
				return rev*o1.getName().compareTo(o2.getName());
			}
		};
	}
	
	static Comparator<Pet> getComparator(){
		class Comp implements Comparator<Pet> {
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}
		return new Comp();
	}
}