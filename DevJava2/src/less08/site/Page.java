package less08.site;

public class Page implements Header, Body, Footer{

	private final Header header;
	
	private final Body body;
	
	private final Footer footer;

	public Page(Header header, Body body, Footer footer) {
		this.header = header;
		this.body = body;
		this.footer = footer;
	}

	public void printHeader() {
		if(header!=null)
		header.printHeader();
	}

	public void printBody() {
		if(body!=null)
		body.printBody();
	}

	public void printFooter() {
		if(footer!=null)
		footer.printFooter();
	}
	
	public void printPage(){
		printHeader();
		printBody();
		printFooter();
	}
}
