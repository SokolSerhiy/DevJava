package zoo.club.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import zoo.club.model.Person;
import zoo.club.model.Pet;
import zoo.club.model.Type;

public class Controller {

	private Map<Person, List<Pet>> map;

	private Saver saver;

	public Controller(int restore) {
		saver = fabric(restore);
		map = saver.restore();
	}

	public void addPerson(String name, int age) {
		map.put(new Person(age, name), new ArrayList<>());
		save();
	}

	public void addPet(String name, int age, String petName, String type) {
		List<Pet> pets = map.get(new Person(age, name));
		if (pets != null) {
			pets.add(new Pet(petName, Type.valueOf(type.toUpperCase())));
			save();
		}
	}

	public void deletePet(String name, int age, String petName, String type) {
		List<Pet> pets = map.get(new Person(age, name));
		if (pets != null) {
			pets.removeIf((pet) -> pet.getName().equals(petName)
					&& pet.getType() == Type.valueOf(type.toUpperCase()));
			save();
		}
	}

	public void deletePerson(String name, int age) {
		map.remove(new Person(age, name));
		save();
	}

	public void deletePetFromAllPersons(String petName, String type) {
		map.forEach((key, value) -> value.removeIf((pet) -> pet.getName()
				.equals(petName)
				&& pet.getType() == Type.valueOf(type.toUpperCase())));
		save();
	}

	public void print() {
//		map.forEach((key, value) -> value.forEach((pet) -> System.out
//				.println(key + " -> " + pet)));
		map.forEach((key, value) -> System.out.println(key+" -> "+value));
	}
	
	private void save(){
		saver.save(map);
	}

	private Saver fabric(int restore) {
		switch (restore) {
		case 1:
			return new SaverTF();
		case 2:
			return new SaverBF();
		default:
			throw new IllegalArgumentException();
		}
	}

	public void sw(int select) {
		saver = fabric(select);
		map = saver.restore();
	}
}