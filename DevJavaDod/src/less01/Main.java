package less01;

public class Main {

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(++i);
		}
//		int j = 0;
		for(int i = 0, j = 0; i < 20; i++,j+=2){
			
		}
		
		rec(5);
		System.out.println();
		rec(1, 10);
	}
	
	static void rec(int n){
		if(n<0) return;
		System.out.println(n);
		rec(--n);
	}
	
	static void rec(int n, int count){
		if(n>count) return;
		System.out.println(n);
		rec(++n, count);
	}
}