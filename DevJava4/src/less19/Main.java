package less19;

import less09.Circle;
import less09.Figure;
import less09.Rectangle;

public class Main {

	public static void main(String[] args) {
		Container<String> container = new Container<>("Hello");
		System.out.println(container.getElement().charAt(0));
		Rectangle rectangle = new Rectangle(5, 4);
		Container<Figure> container2 = new Container<>(rectangle);
		print(rectangle);
		print(container2);
		print(container2.getElement());
		changeFigure(container2, new Circle(5));
		changeFigure(new Container<Object>(new Circle(5)), new Circle(5));
	}
	
	static void changeFigure(Container<? super Figure> container, Figure figure){
		container.setElement(figure);
	}
	
	static void print(Container<? extends Figure> container){
		container.getElement().print();
	}
	
	static void print(Figure figure){
		figure.print();
	}
	
	static void print(Iterable<?> iterable){
		for (Object object : iterable) {
			System.out.println(object);
		}
	}
}