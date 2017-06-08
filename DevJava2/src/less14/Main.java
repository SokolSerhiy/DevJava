package less14;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		try{
			System.out.println(2/0);
			System.out.println("After exception");
		}catch (ArithmeticException | NullPointerException e) {
			e.printStackTrace(System.out);
		}catch (RuntimeException e) {
			e.printStackTrace(System.out);
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}catch (Throwable e) {
			e.printStackTrace(System.out);
		}finally {
			System.out.println("Finally");
		}
		System.out.println("By-by");
		System.out.println(div(1));
		stupidWrapper();
	}
	
	static void stupidWrapper(){
		try{
			stupid();
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	static void stupid() throws IOException{
		throw new IOException("Stupid method");
	}
	
	static int div(int a){
		try{
			return 2/a;
		}catch (ArithmeticException e) {
			return 0;
		}finally {
//			return 10;
		}
	}
}