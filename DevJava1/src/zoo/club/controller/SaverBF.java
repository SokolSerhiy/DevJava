package zoo.club.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import zoo.club.model.Person;
import zoo.club.model.Pet;

public class SaverBF implements Saver{

	@Override
	public void save(Map<Person, List<Pet>> map) {
		try(OutputStream os = new FileOutputStream(new File("save.bf"));
				ObjectOutputStream oos = new ObjectOutputStream(os)){
			oos.writeObject(map);
			oos.flush();
		} catch (IOException e) {
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<Person, List<Pet>> restore() {
		try(InputStream is = new FileInputStream(new File("save.bf"));
				ObjectInputStream ois = new ObjectInputStream(is)){
			Object obj = ois.readObject();
			return (Map<Person, List<Pet>>) obj;
		}catch (IOException | ClassNotFoundException | ClassCastException e) {
		}
		return new HashMap<>();
	}
}