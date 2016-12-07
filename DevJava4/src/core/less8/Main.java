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
			System.out.println("Enter 1 to find by age");
			System.out.println("Enter 2 to delete by first letter");
			System.out.println("Enter 3 to find indexes by letter");
			switch (sc.next()) {
			case "1":
				findByAge();
				break;
			case "2":
				deleteByFirstLetter();
				break;
			case "3":
				findIndexes();
				break;
			default:
				sc.close();
				return;
			}
		}
	}
	
	static void findIndexes(){
		System.out.println("Enter letter");
		String letter = sc.next();
		ListIterator<Person> iter = list.listIterator();
		List<Integer> list = new ArrayList<>();
		while(iter.hasNext()){
			Person person = iter.next();
			if(person.getName().contains(letter)){
				list.add(iter.nextIndex()-1);
			}
		}
		System.out.println(list);
	}
	
	static void deleteByFirstLetter(){
		System.out.println("Enter letter");
		String letter = sc.next();
		Iterator<Person> iter = list.iterator();
		while (iter.hasNext()) {
			Person person = iter.next();
			if(person.getName().startsWith(letter)){
				iter.remove();
			}
		}
		list.forEach(System.out::println);
	}
	
	static void findByAge(){
		System.out.println("Enter min age");
		int min = sc.nextInt();
		System.out.println("Enter max age");
		int max = sc.nextInt();
		for (Person person : list) {
			if(person.getAge()>min&&person.getAge()<max){
				System.out.println(person);
			}
		}
	}
}