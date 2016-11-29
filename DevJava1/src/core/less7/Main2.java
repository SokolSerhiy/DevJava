package core.less7;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import core.less6.Gender;
import core.less6.Person;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Person> persons = new ArrayList<>();
		while (true) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to show all persons");
			System.out.println("Enter 0 to exit");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter age");
				int age = sc.nextInt();
				System.out.println("Enter 1 to male 2 to female");
				Gender gender = sc.nextInt()==1 ? Gender.MALE : Gender.FEMALE;
				persons.add(new Person(age, name, gender));
				break;
			case "2":
				persons.forEach(System.out::println);
				break;
			case "3":
				System.out.println("Enter max age");
				int max = sc.nextInt();
				System.out.println("Enter min age");
				int min = sc.nextInt();
				persons.stream()
				.filter((p)->p.getAge()<max)
				.filter((p)-> p.getAge()>min)
				.forEach(System.out::println);
				break;
			default:
				System.exit(0);
			}
		}
	}
}