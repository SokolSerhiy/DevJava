package core.less14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import core.less14.Person.Pet;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18);
		Person person1 = new Person("Petro", 26);
		Pet pet = person.new Pet("Barsik");
		Pet pet1 = person1.new Pet("Barsik");
		System.out.println(pet.equals(pet1));
		System.out.println(pet.getOuterType());
		Person person2 = new Person.Builder()
			.age(19)
			.name("Mykola")
			.addPet("Barsik")
			.addPet("Tuzik")
			.addPet("Komposter").build();
		System.out.println(person2);
//		person2.getPets().sort(new Comparator<Pet>() {
//			@Override
//			public int compare(Pet o1, Pet o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
		person2.getPets().sort(comparator());
		List<Map.Entry<Integer, String>> entries = 
				getEntries(Arrays.asList(person, person1, person2));
		System.out.println(entries);
	}
	
	public static Comparator<Pet> comparator(){
		return new Comparator<Pet>() {
			@Override
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
		};
	}
	
	static List<Map.Entry<Integer, String>>	getEntries(List<Person> list){
		class Entry implements Map.Entry<Integer, String>{
			
			Integer key;
			
			String value;

			Entry(Integer key, String value) {
				this.key = key;
				this.value = value;
			}
			@Override
			public Integer getKey() {
				return key;
			}
			@Override
			public String getValue() {
				return value;
			}
			@Override
			public String setValue(String value) {
				this.value = value;
				return value;
			}
			@Override
			public String toString() {
				return "Entry [key=" + key + ", value=" + value + "]";
			}
		}
		List<Map.Entry<Integer, String>> entries = new ArrayList<>();
		for (Person person : list) {
			entries.add(new Entry(person.getAge(), person.getName()));
		}
		return entries;
	}
}