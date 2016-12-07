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
			System.out.println("Enter 1 by letter and gender");
			System.out.println("Enter 2 to delete by age");
			System.out.println("Enter 3 to find all indexes by gender");
			switch (sc.next()) {
			case "1":
				find();
				break;
			case "2":
				remove();
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
		System.out.println("Enter gender");
		Gender gender = Gender.valueOf(sc.next().toUpperCase());
		List<Integer> res = new ArrayList<>();
		ListIterator<Person> iter = list.listIterator(list.size());
		while(iter.hasPrevious()){
			if(iter.previous().getGender()==gender){
				res.add(iter.previousIndex()+1);
			}
		}
		System.out.println(res);
	}
	
	static void remove(){
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
	
	static void find(){
		System.out.println("Enter letter");
		String letter = sc.next().toUpperCase();
		System.out.println("Enter gender");
		Gender gender = Gender.valueOf(sc.next().toUpperCase());
		for (Person person : list) {
			if(person.getName().toUpperCase().contains(letter)
					&&person.getGender()==gender){
				System.out.println(person);
			}
		}
	}
}