package core.less8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import core.less6.Gender;
import core.less6.Person;

public class Main {
	
	private static final List<Person> list = new ArrayList<>();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		list.add(new Person("Mariya", 21, Gender.FEMALE));
		list.add(new Person("Ivan", 18, Gender.MALE));
		list.add(new Person("Mykola", 21, Gender.MALE));
		list.add(new Person("Oksana", 19, Gender.FEMALE));
		list.add(new Person("Olya", 24, Gender.FEMALE));
		list.add(new Person("Petro", 30, Gender.MALE));
		list.add(new Person("Artem", 45, Gender.MALE));
		list.add(new Person("Ira", 38, Gender.FEMALE));
		list.add(new Person("Zlata", 40, Gender.FEMALE));
		list.add(new Person("Sergiy", 25, Gender.MALE));
		while(true){
			System.out.println("Enter 1 to rename");
			System.out.println("Enter 2 to find by letter");
			System.out.println("Enter 3 to delete by age");
			System.out.println("Enter 4 to find all indexes by sex");
			switch (sc.next()) {
			case "1":
				rename();
				break;
			case "2":
				findByLetter();
				break;
			case "3":
				deleteByAge();
				break;
			case "4":
				find();
				break;
			default:
				sc.close();
				return;
			}
		}
	}
	
	static void find(){
		System.out.println("Enter gender");
		Gender gender = Gender.valueOf(sc.next().toUpperCase());
		List<Integer> res = new ArrayList<>();
		ListIterator<Person> iter = list.listIterator();
		while(iter.hasNext()){
			if(iter.next().getGender()==gender){
				res.add(iter.nextIndex()-1);
			}
		}
		System.out.println(res);
	}
	
	static void deleteByAge(){
		System.out.println("Enter min age");
		int min = sc.nextInt();
		System.out.println("Enter max age");
		int max = sc.nextInt();
		Iterator<Person> iter = list.iterator();
		while (iter.hasNext()) {
			Person person = iter.next();
			if(person.getAge()>min&&person.getAge()<max){
				iter.remove();
			}
		}
		list.forEach(System.out::println);
	}
	
	static void findByLetter(){
		System.out.println("Enter letter");
		String letter = sc.next();
		for (Person person : list) {
			if(person.getName().toUpperCase().contains(letter.toUpperCase())){
				System.out.println(person);
			}
		}
	}
	
	static void rename(){
		list.forEach(System.out::println);
		System.out.println();
		if(!list.isEmpty()){
			Person tmp = list.get(0);
			for (Person person : list.subList(1, list.size())) {
				String tmpName = person.getName();
				person.setName(tmp.getName());
				tmp.setName(tmpName);
				tmp = person;
			}
		}
		list.forEach(System.out::println);
	}
}