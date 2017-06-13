package less10;

public class Main {

	public static void main(String[] args) {
		Header header = new SimpleHeader();
		Body body = new SimpleBody();
		Footer footer = new SimpleFooter();
		Page page = new Page(header, body, footer);
		page.printPage();
		System.out.println();
		Body leftBody = new LeftBody();
		Page leftPage = new Page(page, leftBody, page);
		leftPage.printPage();
		System.out.println();
		Page leftPageNoFooter = new Page(leftPage, leftPage, null);
		leftPageNoFooter.printPage();
		System.out.println();
	}

}
