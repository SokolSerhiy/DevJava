package core.less10;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		final Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		while (true) {
			System.out.println("Enter 1 to show all persons");
			System.out.println("Enter 2 to sort by name asc");
			System.out.println("Enter 3 to sort by name desc");
			System.out.println("Enter 4 to sort by age asc");
			System.out.println("Enter 5 to sort by age desc");
			System.out.println("Enter 6 to sort by gender asc");
			System.out.println("Enter 7 to sort by gender desc");
			switch (sc.next()) {
			case "1":
				controller.getPersons().forEach(System.out::println);
				break;
			case "2":
				controller.sortByNameASC().forEach(System.out::println);
				break;
			case "3":
				controller.sortByNameDESC().forEach(System.out::println);
				break;
			case "4":
				controller.sortByAgeASC().forEach(System.out::println);
				break;
			case "5":
				controller.sortByAgeDESC().forEach(System.out::println);
				break;
			case "6":
				controller.sortByGenderASC().forEach(System.out::println);
				break;
			case "7":
				controller.sortByGenderDESC().forEach(System.out::println);
				break;
			default:
				sc.close();
				return;
			}
		}
	}
}