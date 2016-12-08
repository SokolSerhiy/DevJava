package core.less13;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.less10.Gender;
import core.less10.Person;

public class Controller {

	private final List<Person> persons = restore();
	
	public void add(Person person){
		persons.add(person);
	}
	
	public List<Person> read(String fileName){
		File file = new File(fileName+".txt");
		if(file.exists()){
			try(Scanner sc = new Scanner(new FileInputStream(file))){
				List<Person> list = new ArrayList<>();
				while(sc.hasNextLine()){
					String str = sc.nextLine();
					if(!str.isEmpty()){
						String[] array = str.split("\\ ");
						Person p = new Person(array[0], Integer.valueOf(array[1]), 
								Gender.valueOf(array[2]));
						list.add(p);
					}
				}
				return list;
			} catch (FileNotFoundException e) {
			}
		}
		return new ArrayList<>();
	}
	
	public void saveToTextFile(String fileName){
		try(FileWriter writer = new FileWriter(fileName+".txt")){
			for (Person person : persons) {
				String str = person.getName()+" "+person.getAge()+" "+person.getGender()+"\n";
				writer.write(str);
			}
		} catch (IOException e) {
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Person> restore(){
		File file = new File("asdf.ytry");
		if(file.exists()){
			try(InputStream is = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(is)){
				Object obj = ois.readObject();
				if(obj instanceof List){
					return (List<Person>) obj;
				}
			}catch (IOException | ClassNotFoundException e) {
			}
		}
		return new ArrayList<>();
	}
	
	public void save(){
		try(OutputStream os = new FileOutputStream(new File("asdf.ytry"));
				ObjectOutputStream oos = new ObjectOutputStream(os)){
			oos.writeObject(persons);
			oos.flush();
		}catch (IOException e) {
		}
		
//		OutputStream os = null;
//		ObjectOutputStream oos = null;
//		try{
//			os = new FileOutputStream(new File("asdf.ytry"));
//			oos = new ObjectOutputStream(os);
//			oos.writeObject(persons);
//			oos.flush();
//		}catch(IOException e){
//			
//		}finally{
//			if(oos!=null){
//				try {
//					oos.close();
//				} catch (IOException e) {
//				}
//			}
//			if(os!=null){
//				try {
//					os.close();
//				} catch (IOException e) {
//				}
//			}
//		}
	}

	public List<Person> getPersons() {
		return persons;
	}
}