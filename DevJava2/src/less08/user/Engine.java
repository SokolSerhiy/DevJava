package less08.user;

import java.util.Scanner;

public class Engine {

	private final Scanner sc = new Scanner(System.in);

	private int choice;

	public Engine() {
		selectStorage();
		menu();
	}

	private void menu() {
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to select storage");
			System.out.println("Enter 2 to save user");
			System.out.println("Enter 3 to exit");
			switch (sc.next()) {
			case "1":
				selectStorage();
				break;
			case "2":
				saveUser();
				break;
			default:
				isRun = false;
			}
		}
	}

	private void saveUser() {
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter age");
		int age = sc.nextInt();
		User user = getUser(name, age);
		user.save();
	}

	private void selectStorage() {
		System.out.println("Enter 1 to select data base");
		System.out.println("Enter 2 to select text file");
		System.out.println("Enter 3 to select binary file");
		choice = sc.nextInt();
	}

	private User getUser(String name, int age) {
		switch (choice) {
		case 1: return new UserDB(age, name);
		case 2: return new UserTF(age, name);
		case 3: return new UserBF(age, name);
		default: throw new IllegalArgumentException("Choice can be 1-3");
		}
	}
}
