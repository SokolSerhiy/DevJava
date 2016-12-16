package core.less12;


public class Main {

	public static void main(String[] args) {
		try{
			System.out.println(0/0);
		}catch (ArithmeticException | NullPointerException e){
			e.printStackTrace();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		try {
			kaput();
		} catch (MyException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	static void kaput() throws MyException{
		throw new MyException();
	}
}