package core.less15;

import java.util.ArrayList;
import java.util.List;

import core.less4.Circle;
import core.less4.Geometric;
import core.less4.Rectangle;

public class Main {

	public static void main(String[] args) {
		Container<String> container = new Container<>("Ivan");
		System.out.println(container.getElement());
		List<Geometric> list = new ArrayList<>();
		list.add(new Rectangle(4, 3));
		add(list, new Circle(5));
		print(list);
	}
	
	static void add(List<? super Geometric> list, Geometric geometric){
		list.add(geometric);
	}
	
	static void print(List<? extends Geometric> list){
		for (Geometric geometric : list) {
			geometric.print();
		}
	}
}