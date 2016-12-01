package core.less7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import core.less6.Gender;
import core.less6.Person;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Person> list = new ArrayList<>();
		list.add(new Person("Ivan", 18, Gender.MALE));
		list.add(new Person("Mykola", 25, Gender.MALE));
		list.add(new Person("Petro", 30, Gender.MALE));
		list.add(new Person("Petro", 30, Gender.MALE));
		Iterator<Person> iter;
		while (true) {
			System.out.println("Enter 1 to add person");
			System.out.println("Enter 2 to show all persons");
			System.out.println("Enter 3 to filter by age");
			System.out.println("Enter 4 to remove by age");
			System.out.println("Enter 5 to remove by name");
			System.out.println("Enter 6 to remove by gender");
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
				list.add(new Person(name, age, gender));
				break;
			case "2":
				list.forEach(System.out::println);
				break;
			case "3":
				System.out.println("Enter max age");
				int max = sc.nextInt();
				System.out.println("Enter min age");
				int min = sc.nextInt();
				list.stream()
				.filter((p)->p.getAge()<max)
				.filter((p)->p.getAge()>min)
				.forEach(System.out::println);
				break;
			case "4":
				System.out.println("Enter max age");
				int maxA = sc.nextInt();
				System.out.println("Enter min age");
				int minA = sc.nextInt();
				iter = list.iterator();
				while (iter.hasNext()) {
					Person person = iter.next();
					if(person.getAge()>minA&&person.getAge()<maxA){
						iter.remove();
					}
				}
//				list.removeIf((p)->p.getAge()>minA&&p.getAge()<maxA);
				break;
			case "5":
				System.out.println("Enter name");
				String name1 = sc.next();
				iter = list.iterator();
				while (iter.hasNext()) {
					if(iter.next().getName().equals(name1)){
						iter.remove();
					}
				}
//              list.removeIf((p)->p.getName().equals(name1))
				break;
			case "6":
				System.out.println("Enter 1 to male 2 to female");
				Gender gender1 = sc.nextInt()==1 ? Gender.MALE : Gender.FEMALE;
				iter = list.iterator();
				while (iter.hasNext()) {
					if(iter.next().getGender()==gender1){
						iter.remove();
					}
				}
//              list.removeIf((p)->p.getGender()==gender1)
				break;
			case "7":
//				Set<Person> set = new HashSet<>(list);
//				list = new ArrayList<Person>(set);
				
//				list = list.stream().collect(Collectors.toSet())
//				.stream().collect(Collectors.toList());
				
				for (int i = 0; i < list.size(); i++) {
					for (int j = 0; j < list.size(); j++) {
						if(list.get(i).equals(list.get(j))&&i!=j){
							list.remove(j);
							j--;
						}
					}
				}
				break;
			default:
				sc.close();
				System.exit(0);
				break;
			}
		}
	}
}