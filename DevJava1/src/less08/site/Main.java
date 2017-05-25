package less08.site;

public class Main {

	public static void main(String[] args) {
		Header header = new SimpleHeader();
		Body body = new SimpleBody();
		Footer footer = new SimpleFooter();
		Page page = new Page(header, body, footer);
		page.printPage();
		System.out.println();
		Body leftBody = new LeftBody();
//		Page leftPage = new Page(header, leftBody, footer);
//		leftPage.printPage();
//		System.out.println();
//		Page leftFooterPage = new Page(header, leftBody, null);
//		leftFooterPage.printPage();
		Page leftPage = new Page(page, leftBody, page);
		leftPage.printPage();
		System.out.println();
		Page leftFooterPage = new Page(page, leftPage, null);
		leftFooterPage.printPage();
	}
}