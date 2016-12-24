package lesson5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		while (true) {
			System.out.println("Enter 1 to add proffesion");
			System.out.println("Enter 2 to add person");
			System.out.println("Enter 3 to remove person");
			System.out.println("Enter 4 to show all");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter proffesion");
				String proffesion = sc.next();
				controller.addProffesion(proffesion);
				break;
			case "2":
				System.out.println("Enter proffesion");
				proffesion = sc.next();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				controller.addPerson(proffesion, name, age);
				break;
			case "3":
				System.out.println("Enter proffesion");
				proffesion = sc.next();
				System.out.println("Enter name");
				name = sc.next();
				System.out.println("Enter age");
				age = sc.nextInt();
				controller.deletePerson(proffesion, name, age);
				break;
			case "4":
				controller.print();
				break;
			default:
				sc.close();
				return;
			}
		}
	}
}