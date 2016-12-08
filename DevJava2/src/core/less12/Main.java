package core.less12;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try{
			div(1, 0);
		}catch (ArithmeticException e){
			e.printStackTrace();
		}
		System.out.println("Hello");
		try {
			checked();
		} catch (IOException | RuntimeException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}

	static void div(int a, int b){
		System.out.println(a/b);
	}
	
	static void checked() throws IOException{
		throw new IOException();
	}
}
