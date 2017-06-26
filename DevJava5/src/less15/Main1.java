package less15;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import less11.Person;

public class Main1 {

	public static void main(String[] args) {
		Map<Profession, List<Person>> map = new HashMap<>();
		Map<String, Case> menu = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		menu.put("0", ()->false);
		menu.put("1", new Case1(sc, map));
		menu.put("2", new Case2(sc, map));
		menu.put("3", new Case3(map));
		do{
			System.out.println("Enter 0 to exit");
			System.out.println("Enter 1 to add Profession");
			System.out.println("Enter 2 to add Person");
			System.out.println("Enter 3 to show all");
		}while(menu.getOrDefault(sc.next(), ()->{
			System.err.println("Wrong input, try again");
			return true;
		}).doWork());
	}

}
