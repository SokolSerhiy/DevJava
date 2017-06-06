package less13.tt;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Case5 implements Case {
	
	private final Scanner sc;
	
	private final Map<Profession, List<Person>> map;
	
	public Case5(Scanner sc, Map<Profession, List<Person>> map) {
		this.sc = sc;
		this.map = map;
	}

	@Override
	public boolean work() {
		System.out.println("Enter file name");
		try(Scanner scanner = new Scanner(new File(sc.next()+".txt"))){
			map.clear();
			while (scanner.hasNextLine()) {
				String string = scanner.nextLine();
				if(!string.isEmpty()){
					String[] words = string.split(" ");
					Profession profession =
					new Profession(words[0], Integer.valueOf(words[1]));
					if(!map.containsKey(profession)){
						map.put(profession, new ArrayList<>());
					}
					if(words.length>2){
						Person person =
						new Person(words[2], Integer.valueOf(words[3]));
						map.get(profession).add(person);
					}
				}
			}
		}catch (Exception e) {
		}
		return true;
	}

}
