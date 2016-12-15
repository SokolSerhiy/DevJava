package zoo.club.controller;

import java.util.List;
import java.util.Map;

import zoo.club.model.Person;
import zoo.club.model.Pet;

public interface Saver {

	void save(Map<Person, List<Pet>> map);
	
	Map<Person, List<Pet>> restore();
}
