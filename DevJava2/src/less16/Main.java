package less16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
				.pet("Komposter")
				.pet("Tuzik")
				.build();
		System.out.println(person3);
		person3.getPets().sort(petComparatorByNameDesc());
		
	}
	
	static Comparator<Pet> petComparatorByNameDesc(){
		return new Comparator<Pet>() {
			@Override
			public int compare(Pet o1, Pet o2) {
				return o1.getName().compareTo(o2.getName());
			}
		}.reversed();
	}
	
	static List<Figure> convertToFigure(int[] radiuses){
		class Circle implements Figure{
			final int r;
			public Circle(int r) {
				this.r = r;
			}
			public double perimetr() {
				return 2*Math.PI*r;
			}
			public double square() {
				return Math.PI*r*r;
			}
		}
		List<Figure> figures = new ArrayList<>(radiuses.length);
		for (int r : radiuses) figures.add(new Circle(r));
//		return figures;
		return Arrays.stream(radiuses)
				.mapToObj(r->new Circle(r))
				.collect(Collectors.toList());
	}
}
