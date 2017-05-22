package less02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a = 3;
		if(a==1){
			System.out.println("One");
		}else if(a==2){
			System.out.println("Two");
		}else{
			System.out.println("More then two");
		}
		
		switch (a) {
		case 1:
			System.out.println("One");
			break;
		case 2:
			System.out.println("Two");
			break;
		default:
			System.out.println("More then two");
		}
		
		for(int i = 0; i < 10; ++i){
			System.out.println(i);
		}
		
		System.out.println("while");
		int i = 0;
		while(i<10){
			System.out.println(i);
			i++;
		}
		System.out.println("do while");
		do{
			System.out.println(i);
			i++;
		}while(i<10);
		
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter number");
//		int res = sc.nextInt();
//		System.out.println("Result = "+res);
//		System.out.println("Enter number with .");
//		double dRes = sc.nextDouble();
//		System.out.println("Result = "+dRes);
		
		System.out.println(Math.E);
		System.out.println(Math.PI);
		System.out.println(Math.abs(-5));
		System.out.println(Math.ceil(3.0000000000005));
		System.out.println(Math.floor(3.999999999999999));
		System.out.println();
	}
}