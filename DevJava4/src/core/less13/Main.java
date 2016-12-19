package core.less13;

import java.util.Scanner;

import core.less6.Gender;
import core.less6.Person;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		while (true) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to show all persons");
			System.out.println("Enter 3 to save to text file");
			System.out.println("Enter 4 to restore from text file");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				System.out.println("Enter gender");
				Gender gender = Gender.valueOf(sc.next().toUpperCase());
				controller.add(new Person(name, age, gender));
				break;
			case "2":
				controller.print();
				break;
			case "3":
				System.out.println("Enter file name");
				controller.write(sc.next());
				break;
			case "4":
				System.out.println("Enter file name");
				controller.restore(sc.next());
				break;
			default:
				sc.close();
				return;
			}
		}
	}

}
