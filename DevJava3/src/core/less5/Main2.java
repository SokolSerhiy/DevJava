package core.less5;

public class Main2 {

	public static void main(String[] args) {
		Header header = new IndexHeader();
		Footer footer = new IndexFooter();
		Body body = new IndexBody();
		Body leftSide = new LeftSideBarBody();
		Body rightSide = new RightSideBarBody();
		Engine engine = new Engine(header, body, footer);
		engine.printPage();
		System.out.println();
		Engine left = new Engine(header, leftSide, footer);
		left.printPage();
		System.out.println();
		Engine right = new Engine(header, rightSide, footer);
		right.printPage();
		System.out.println();
		Engine leftWithoutFooter = new Engine(header, leftSide, null);
		leftWithoutFooter.printPage();
	}
}