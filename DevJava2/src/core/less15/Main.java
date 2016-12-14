package core.less15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import core.less4.Circle;
import core.less4.Geometric;
import core.less4.Rectangle;
import core.less4.RoundGeometric;



public class Main {

	public static void main(String[] args) {
		MyArrayList<String> list = new MyArrayList<>();
		list.add("Ivan");
		list.add("Petro");
		list.add("Mykola");
		System.out.println(list);
		for (String object : list) {
			System.out.println(object.substring(0, 1));
		}
		List<RoundGeometric> list2 = 
		new ArrayList<>(Arrays.asList(new Circle(5)));
		print(list2);
	}
	
	static void print(Iterable<? extends Geometric> iterable){
		for (Geometric geometric : iterable) {
			geometric.print();
		}
	}
}