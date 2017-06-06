package less13.tt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Engine implements Serializable {

	private static final long serialVersionUID = -5041919954216534998L;

	private transient Scanner sc;

	private Map<Profession, List<Person>> map = new HashMap<>();
	
	public static Engine restore(){
		try(InputStream is = new FileInputStream(new File("save.ksdfhhj"));
			ObjectInputStream ois = new ObjectInputStream(is)){
			return (Engine) ois.readObject();
		}catch (Exception e) {
		}
		return new Engine();
	}
	
	public void save(){
		File file = new File("save.ksdfhhj");
		try(OutputStream os = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(os)){
			oos.writeObject(this);
			oos.flush();
		}catch (Exception e) {
		}
	}

	public void start() {
		sc = new Scanner(System.in);
		Map<String, Case> menu = new HashMap<>();
		menu.put("1", new Case1(sc, map));
		menu.put("2", new Case2(sc, map));
		menu.put("3", new Case3(map));
		menu.put("4", new Case4(sc, map));
		menu.put("5", new Case5(sc, map));
		do {
			System.out.println("Enter 0 to exit");
			System.out.println("Enter 1 to add profession");
			System.out.println("Enter 2 to add person");
			System.out.println("Enter 3 to show all");
			System.out.println("Enter 4 to save to text file");
			System.out.println("Enter 5 to restore from text file");
			save();
		} while (menu.getOrDefault(sc.next(), ()->false).work());
//		boolean isRun = true;
//		while (isRun) {
//			System.out.println("Enter 0 to exit");
//			System.out.println("Enter 1 to add profession");
//			System.out.println("Enter 2 to add person");
//			System.out.println("Enter 3 to show all");
//			switch (sc.next()) {
//			case "1": {
//				System.out.println("Enter title of profession");
//				String name = sc.next();
//				if(map.containsKey(new Profession(name))){
//					System.out.println("That profession already exist");
//				}else{
//					System.out.println("Enter min payment to this profession");
//					int minPayment = sc.nextInt();
//					map.put(new Profession(name, minPayment), new ArrayList<>());
//				}
//				break;
//			}
//			case "2": {
//				System.out.println("Enter title of profession");
//				String name = sc.next();
//				if(map.containsKey(new Profession(name))){
//					Set<Profession> professions = map.keySet();
//					Profession curent = null;
//					for (Profession profession : professions) {
//						if(profession.equals(new Profession(name))){
//							curent = profession;
//						}
//					}
//					System.out.println("Enter name of person");
//					String personName = sc.next();
//					System.out.println("Enter payment bigger that "+curent.getMinPayment());
//					int payment = sc.nextInt();
//					map.get(curent).add(new Person(personName, payment));
//				}else{
//					System.out.println("That profession does not exist");
//				}
//				break;
//			}
//			case "3": {
//				Set<Profession> keys = map.keySet();
//				for (Profession key : keys) {
//					for(Person person : map.get(key)){
//						System.out.println(key+" "+person);
//					}
//				}
//				break;
//			}
//			default:
//				isRun = false;
//			}
//		}
	}
}
