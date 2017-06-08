package less15;

import java.util.ArrayList;
import java.util.List;

import less08.figure.Figure;
import less08.figure.Rectangle;

public class Main {

	public static void main(String[] args) {
		Container<String> container = new Container<>("Hello");
		print(container);
		Container<Integer> container1 = new Container<>(12);
		print(container1);
		Container<Rectangle> container2 = new Container<>(new Rectangle(5, 8));
		printFigure(container2);
		String s = getSome("Hello");
		System.out.println(s);
	}
	
	static <T> T getSome(T t){
		return t;
	}
	
	static void changeFigure(Container<? super Figure> container, Figure figure){
		container.setElement(figure);
	}
	
	static void printFigure(Container<? extends Figure> container){
		container.getElement().print();
	}
	
	static void print(Container<?> container){
		System.out.println(container.getElement());
	}
}