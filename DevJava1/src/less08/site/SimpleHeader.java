package less08.site;

public class SimpleHeader implements Header{

	@Override
	public void printHeader() {
		System.out.println("***********************************");
		System.out.println("*                                 *");
		System.out.println("*              Header             *");
		System.out.println("*                                 *");
		System.out.println("***********************************");
	}

}
