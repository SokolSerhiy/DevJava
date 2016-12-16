package core.less12;



public class Main {

	public static void main(String[] args) throws ArithmeticException,  NullPointerException{
		int a = 0;
		try{
			System.out.println(0/a);
		}catch(ArithmeticException | NullPointerException жарена_картопля){
			жарена_картопля.printStackTrace();
		}catch (RuntimeException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
		try {
			kaput();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Ok");
		}
		int i = add();
		System.out.println("i = "+i);
	}
	
	static void kaput(){
//		throw new MyException();
	}
	
	static int add(){
		try {
			kaput();
		} catch (RuntimeException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Ok");
		}
		return 0;
	}

}
