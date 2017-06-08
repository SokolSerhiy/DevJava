package less15;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import less08.figure.Figure;
import less08.figure.Rectangle;

public class Main {

	public static void main(String[] args) {
		Container<String> container = new Container<>("Hello");
		System.out.println(container.getElement().charAt(0));
		Container<Integer> container1 = new Container<>(12);
		System.out.println(container1.getElement()==12);
		Rectangle rectangle = new Rectangle(5, 8);
		Container<Figure> container2 = new Container<>(rectangle);
		print(rectangle);
		print(container2);
		List<String> list = new ArrayList<>();
		print(list);
		set(container2, rectangle);
		Container<Figure> container3 = ret();
		container3.getElement().print();
//		Container<? super Figure> container4 = ret1();
	}
	
	static Container<? super Figure> ret1(){
		return new Container<Figure>(new Rectangle(5, 8));
	}
	
	static Container<Figure> ret(){
		return new Container<Figure>(new Rectangle(5, 8));
	}
	
	static void set(Container<? super Figure> container, Figure figure){
		container.setElement(figure);
	}
	
	static void print(Iterable<?> iterable){
		for (Object object : iterable) {
			System.out.println(object);
		}
	}
	
	static void print(Collection<?> iterable){
		for (Object object : iterable) {
			System.out.println(object);
		}
	}
	
	static void print(Figure figure){
		figure.print();
	}
	
	static void print(Container<? extends Figure> container){
		container.getElement().print();
	}
}