package core.less8;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import core.less6.Gender;
import core.less6.Person;

public class Main {

	private static final Scanner SC = new Scanner(System.in);
	private static final List<Person> list = new ArrayList<>();

	public static void main(String[] args) {
		list.add(new Person("Mariya", 21, Gender.FEMALE));
		list.add(new Person("Ivan", 18, Gender.MALE));
		list.add(new Person("Oksana", 19, Gender.FEMALE));
		list.add(new Person("Mykola", 21, Gender.MALE));
		list.add(new Person("Olya", 24, Gender.FEMALE));
		list.add(new Person("Petro", 30, Gender.MALE));
		list.add(new Person("Artem", 45, Gender.MALE));
		list.add(new Person("Ira", 38, Gender.FEMALE));
		list.add(new Person("Zlata", 40, Gender.FEMALE));
		list.add(new Person("Sergiy", 25, Gender.MALE));
		while (true) {
			System.out.println("Enter 1 to find by age");
			System.out.println("Enter 2 to find by letter");
			System.out.println("Enter 3 to delete by age");
			System.out.println("Enter 4 to change by name");
			switch (SC.next()) {
			case "1":
				findByAge();
				break;
			case "2":
				findByLetter();
				break;
			case "3":
				deleteByAge();
				break;
			case "4":
				changeByName();
				break;
			default:
				SC.close();
				return;
			}
		}

	}
	
	static void changeByName(){
		System.out.println("Enter name");
		String name = SC.next();
		ListIterator<Person> iter = list.listIterator();
		Person person = new Person("Deafault", 0, null);
		while(iter.hasNext()){
			if(iter.next().getName().equalsIgnoreCase(name)){
				iter.set(person);
			}
		}
		list.forEach(System.out::println);
	}
	
	static void deleteByAge(){
		System.out.println("Enter min age");
		int min = SC.nextInt();
		System.out.println("Enter max age");
		int max = SC.nextInt();
		Iterator<Person> iter = list.iterator();
		while (iter.hasNext()) {
			Person person = iter.next();
			if(person.getAge()>min&&person.getAge()<max){
				iter.remove();
			}
		}
		list.forEach(System.out::println);
	}

	static void findByAge() {
		System.out.println("Enter max age");
		int age = SC.nextInt();
		for (Person person : list) {
			if(person.getAge()<age){
//				if(person.getGender()==Gender.FEMALE){
//					person.setGender(Gender.MALE);
//				}else{
//					person.setGender(Gender.FEMALE);
//				}
				System.out.println(person);
			}
		}
	}
	
	static void findByLetter(){
		System.out.println("Enter letter");
		String letter = SC.next();
		for (Person person : list) {
			if(person.getName().contains(letter)){
				System.out.println(person);
			}
		}
	}
}