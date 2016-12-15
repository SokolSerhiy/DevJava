package zoo.club.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import zoo.club.model.Person;
import zoo.club.model.Pet;
import zoo.club.model.Type;

public class SaverTF implements Saver{

	@Override
	public void save(Map<Person, List<Pet>> map) {
		try(FileWriter writer = new FileWriter("zoo.txt")){
			Set<Person> persons = map.keySet();
			for (Person person : persons) {
				for(Pet pet : map.get(person)){
//					writer.write(""+person+pet);
					writer.write(person.toString()+pet+"\n");
				}
			}
		} catch (IOException e) {
		}
	}
	
	@Override
	public Map<Person, List<Pet>> restore() {
		Map<Person, List<Pet>> map = new HashMap<>();
		try(Scanner sc = new Scanner(new File("zoo.txt"))){
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				if(!line.isEmpty()){
					String[] array = line.split("\\ ");
					Person person = new Person(Integer.valueOf(array[0]), array[1]);
					if(!map.containsKey(person)){
						map.put(person, new ArrayList<>());
					}
					map.get(person).add(new Pet(array[2], Type.valueOf(array[3])));
				}
			}
		}catch (IOException e) {
		}
		return map;
	}

}
