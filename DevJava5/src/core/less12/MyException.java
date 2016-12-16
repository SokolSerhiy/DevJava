package core.less12;

public class MyException extends RuntimeException{
	
	private static final long serialVersionUID = -6482749748091743517L;

	@Override
	public void printStackTrace() {
		System.err.println("Шукай сам де і чого помилка");
	}
}