package lesson4.view;

import java.util.Scanner;

import lesson4.controller.Controller;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Controller controller = new Controller();
		while (true) {
			System.out.println("Enter 1 to find by diametr");
			System.out.println("Enter 2 to find by diametr and color");
			System.out.println("Enter 3 to change helm");
			System.out.println("Enter 4 to increase wheel size");
			System.out.println("Enter 5 to change cars by diametr of wheels");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter diametr");
				int diametr = sc.nextInt();
				controller.findByDiametr(diametr).forEach(System.out::println);
				break;
			case "2":
				System.out.println("Enter diametr");
				diametr = sc.nextInt();
				System.out.println("Enter color");
				String color = sc.next();
				controller.findByDiametrAndColor(diametr, color).forEach(System.out::println);
				break;
			case "3":
				controller.changeHelm().forEach(System.out::println);
				break;
			case "4":
				controller.increase().forEach(System.out::println);
				break;
			case "5":
				System.out.println("Enter diametr");
				diametr = sc.nextInt();
				controller.changeCar(diametr).forEach(System.out::println);
				break;
			default:
				sc.close();
				return;
			}
		}

	}

}
