package core.less12;


public class Main {

	public static void main(String[] args) throws ArithmeticException, NullPointerException {
		try{
			System.out.println(0/0);
		}catch (ArithmeticException | NullPointerException e){
			e.printStackTrace();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		try {
			kapec();
		} catch (MyException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
	static void kapec(){
		throw new MyException("mdsfhjhdg");
	}
}