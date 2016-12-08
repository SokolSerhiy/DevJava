package core.less12;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		div(1, 1);
		try{
			checked();
		}catch (IOException e){
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
		System.out.println("Hello");
	}
	
	static void div(int a, int b){
		System.out.println(a/b);
	}
	
	static void checked() throws IOException{
		throw new IOException("Error!!!");
	}
}