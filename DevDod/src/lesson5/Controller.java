package lesson5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Controller {

	private final Map<String, List<Person>> map = new HashMap<>();
	
	public void addProffesion(String proffesion){
		map.put(proffesion, new ArrayList<>());
	}
	
	public void addPerson(String proffesion, String name, int age){
		if(map.containsKey(proffesion)){
			map.get(proffesion).add(new Person(name, age));
		}
	}
	
	public void deletePerson(String proffesion, String name, int age){
		if(map.containsKey(proffesion)){
			List<Person> list = map.get(proffesion);
			Iterator<Person> iter = list.iterator();
			while (iter.hasNext()) {
				Person person = iter.next();
				if(person.getAge()==age&&person.getName().equals(name)){
					iter.remove();
				}
			}
		}
	}
	
	public void print(){
		map.forEach((key, value)->value.forEach(person->System.out.println(key+" -> "+person)));
	}
}
