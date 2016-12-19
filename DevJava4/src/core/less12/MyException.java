package core.less12;

public class MyException extends RuntimeException{

	private static final long serialVersionUID = -6482749748091743517L;
	
	public MyException() {
	}

	public MyException(String message) {
		super(message);
	}

	@Override
	public void printStackTrace() {
		System.err.println("Сам догадайся чого сталася помилка і де");
	}
}