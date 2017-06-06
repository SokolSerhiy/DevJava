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
		try(InputStream is = new FileInputStream(new File("save.sdkfyt"));
			ObjectInputStream ois = new ObjectInputStream(is)){
			return (Engine) ois.readObject();
		}catch (Exception e) {
			System.out.println("New Engine");
		}
		return new Engine();
	}
	
	public void save(){
		try(OutputStream os = new FileOutputStream(new File("save.sdkfyt"));
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
			System.out.println("Enter 4 to write to text file");
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
//				System.out.println("Enter profession title");
//				String name = sc.next();
//				if(map.containsKey(new Profession(name))){
//					System.out.println("That profession already exist");
//				}else{
//					System.out.println("Enter min payment");
//					int minPayment = sc.nextInt();
//					map.put(new Profession(name, minPayment), new ArrayList<>());
//				}
//				break;
//			}
//			case "2": {
//				System.out.println("Enter profession title");
//				String name = sc.next();
//				Profession current = new Profession(name);
//				if(map.containsKey(current)){
//					Set<Profession> keySet = map.keySet();
//					for (Profession profession : keySet) {
//						if(profession.equals(current)){
//							current = profession;
//						}
//					}
//					System.out.println("Enter person name");
//					String personName = sc.next();
//					System.out.println("Enter min payment bigger then "+current.getMinPayment());
//					int payment = sc.nextInt();
//					map.get(current).add(new Person(personName, payment));
//				}else{
//					System.out.println("That profession does not exist");
//				}
//				break;
//			}
//			case "3": {
//				Set<Profession> keySet = map.keySet();
//				for (Profession key : keySet) {
//					for(Person person : map.get(key)){
//						System.out.println(key+" "+person);
//					}
//					if(map.get(key).isEmpty()){
//						System.out.println(key);
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
