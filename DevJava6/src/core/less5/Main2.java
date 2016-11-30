package core.less5;

public class Main2 {

	public static void main(String[] args) {
//		Header header = new IndexHeader();
//		Body body = new IndexBody();
//		Footer footer = new IndexFooter();
//		Engine engine = new Engine(header, body, footer);
//		engine.printPage();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		Body leftSide = new LeftSideBarBody();
//		Engine left = new Engine(header, leftSide, footer);
//		left.printPage();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		Body rightSide = new RightSideBarBody();
//		Engine right = new Engine(header, rightSide, footer);
//		right.printPage();
//		System.out.println();
//		System.out.println();
//		System.out.println();
//		Engine rightWithoutFooter = new Engine(header, rightSide, null);
//		rightWithoutFooter.printPage();
		
		Engine engine = new Engine(new IndexHeader(), new IndexBody(), new IndexFooter());
		engine.printPage();
		System.out.println();
		System.out.println();
		System.out.println();
		Engine left = new Engine(engine, new LeftSideBarBody(), engine);
		left.printPage();
		System.out.println();
		System.out.println();
		System.out.println();
		Engine right = new Engine(engine, new RightSideBarBody(), engine);
		right.printPage();
		System.out.println();
		System.out.println();
		System.out.println();
		Engine rightWithoutFooter = new Engine(engine, right, null);
		rightWithoutFooter.printPage();
	}
}