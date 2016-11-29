package core.less7;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Ivan");//0
		list.add("Petro");//1
		list.add(1, "Mykola");//1
		for(String str : list){
			System.out.println(str);
		}
		System.out.println(list);
		
		System.out.println(list.contains("Ivan"));
		list.forEach(System.out::println);
		System.out.println(list.get(1));
		System.out.println(list.indexOf("Mykola"));
		System.out.println(list.remove(1));
		System.out.println();
		list.forEach(System.out::println);
		list.removeIf(Main::remove);
		System.out.println();
		list.forEach(System.out::println);
		System.out.println(list.set(0, "Mykola"));
		System.out.println();
		list.forEach(System.out::println);
	}
	
	static boolean remove(String str){
		return str.startsWith("I");
	}
}