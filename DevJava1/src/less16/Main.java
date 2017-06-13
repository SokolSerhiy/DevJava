package less16;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import less08.figure.Figure;
import less16.Person.Pet;

public class Main {

	public static void main(String[] args) {
		Person person = new Person("Ivan", 18);
		System.out.println(person);
		Pet pet = person.new Pet("Barsik");
		System.out.println(person);
//		person.getPets().add(pet);
		System.out.println(person);
		Person person2 = new Person("Mykola", 25);
		Pet pet2 = person2.new Pet("Barsik");
		System.out.println(pet2.equals(pet));
		System.out.println(person2);
		Person person3 = new Person.Builder()
				.age(36)
				.name("Petro")
				.pet("Barsik")
				.pet("Tuzik")
				.pet("Komposter")
				.build();
		System.out.println(person3);
		person3.getPets().sort(petComparatorByNameDesc(1));
		person3.getPets().sort(Comparator.comparing(Pet::getName).reversed());
	}
	
	static Comparator<Pet> petComparatorByNameDesc(final int a){
		return new Comparator<Pet>() {
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}.reversed();
	}
	
	static Comparator<Pet> petComparatorByNameAsc(){
		class PetComparatorByNameAsc implements Comparator<Pet>{
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		}
		return new PetComparatorByNameAsc();
	}
	
	static List<Figure> convertToFigure1(int[] radiuses){
		class Circle implements Figure{
			int r;
			Circle(int r){
				this.r = r;
			}
			public double perimetr() {
				return 2*Math.PI*r;
			}
			public double square() {
				return Math.PI*r*r;
			}
		}
		List<Figure> figures = new ArrayList<>();
		for (int i : radiuses) {
			figures.add(new Circle(i));
		}
		return figures;
	}
	
	static List<Figure> convertToFigure2(int[] radiuses){
		List<Figure> figures = new ArrayList<>();
		for (int i : radiuses) {
			figures.add(new Figure(){
				public double perimetr() { return 2*Math.PI*i; }
				public double square() { return Math.PI*i*i; }
			});
		}
		return figures;
	}
}