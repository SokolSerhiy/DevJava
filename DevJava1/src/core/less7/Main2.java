package core.less7;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import core.less6.Gender;
import core.less6.Person;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Person> persons = new ArrayList<>();
		persons.add(new Person(18, "Ivan", Gender.MALE));
		persons.add(new Person(30, "Mykola", Gender.MALE));
		persons.add(new Person(25, "Petro", Gender.MALE));
		persons.add(new Person(30, "Mykola", Gender.MALE));
		Iterator<Person> iter;
		while (true) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to show all persons");
			System.out.println("Enter 3 to filter by age");
			System.out.println("Enter 4 to delete by age");
			System.out.println("Enter 5 to delete by first letter");
			System.out.println("Enter 6 to delete by gender");
			System.out.println("Enter 7 to clear from duplicate");
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
			case "4":
				System.out.println("Enter max age");
				int maxA = sc.nextInt();
				System.out.println("Enter min age");
				int minA = sc.nextInt();
				iter = persons.iterator();
				while(iter.hasNext()){
					Person person = iter.next();
					if(person.getAge()<maxA&&person.getAge()>minA){
						iter.remove();
					}
				}
				break;
			case "5":
				System.out.println("Enter first letter");
				String letter = sc.next();
				iter = persons.iterator();
				while(iter.hasNext()){
					if(iter.next().getName().startsWith(letter)){
						iter.remove();
					}
				}
				break;
			case "6":
				System.out.println("Enter 1 to male 2 to female");
				Gender remove = sc.nextInt()==1 ? Gender.MALE : Gender.FEMALE;
				iter = persons.iterator();
				while(iter.hasNext()){
					if(iter.next().getGender()==remove){
						iter.remove();
					}
				}
				break;
			case "7":
//				for (int i = 0; i < persons.size(); i++) {
//					for (int j = 0; j < persons.size(); j++) {
//						if(persons.get(i).equals(persons.get(j))&&i!=j){
//							persons.remove(j);
//						}
//					}
//				}
				
//				Set<Person> set = new HashSet<>(persons);
//				persons = new ArrayList<>(set);
				
				persons = persons.stream()
				.collect(Collectors.toSet()).stream()
				.collect(Collectors.toList());
				
				persons.forEach(System.out::println);
				break;
			default:
				sc.close();
				System.exit(0);
			}
		}
	}
}