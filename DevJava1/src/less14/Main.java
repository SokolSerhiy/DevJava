package less14;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello");
		try{
			System.out.println(2/0);
		}catch (ArithmeticException | NullPointerException e) {
			e.printStackTrace(System.out);
		}catch (RuntimeException e) {
			e.printStackTrace(System.out);
		}catch (Exception e) {
			e.printStackTrace(System.out);
		}catch (Throwable e) {
			e.printStackTrace(System.out);
		}finally{
			System.out.println("Finaly");
		}
		System.out.println("By-by");
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
}
