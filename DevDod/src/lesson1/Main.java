package lesson1;


public class Main {

	public static void main(String[] args) {
		//fact();
		boolean isRun = true;
		while(isRun){
			switch (0) {
			case 0:
				isRun = false;
				break;
			}
		}
		print1();
		print2();
		System.out.println(fact(5));
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter array length");
		int length = sc.nextInt();
		int[] array = new int[length];
		System.out.println(array);
		for (int i = 0; i < array.length; i++) {
			array[i] = i +1;
			System.out.println(array[i]);
		}
		System.out.println(array[0]);
	}
	
	static void fact(){
		java.util.Scanner sc = new java.util.Scanner(System.in);
		System.out.println("Enter number");
		int a = sc.nextInt();
		int fact = 1;
		for (int i = 1; i <= a; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
		sc.close();
	}
	
	static int fact(int i){
		if(i==0)return 1;
		return i * fact(i-1);
	}

	static void print1(){
		System.out.println("Print 1");
	}
	
	static void print2(){
		System.out.println("Print 2");
	}
}
