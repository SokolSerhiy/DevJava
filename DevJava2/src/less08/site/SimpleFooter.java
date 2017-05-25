package less08.site;

public class SimpleFooter implements Footer{

	@Override
	public void printFooter() {
		System.out.println("************************************");
		System.out.println("*                                  *");
		System.out.println("*             Footer               *");
		System.out.println("*                                  *");
		System.out.println("************************************");
	}
}