package less02;

public class Main {

	public static void main(String[] args) {
		int a = 3;
		int b = 8;
		int res = a + b;
		System.out.println(res);
		res = a - b;
		System.out.println(res);
		res = b%a;
		System.out.println(res);
		res+=a;
		System.out.println(res);
		res%=a;
		System.out.println(res);
		res++;
		System.out.println(res);
		System.out.println(5*2*3.14);
		System.out.println(a<b);
		System.out.println(a<=b);
		System.out.println(a==b);
		System.out.println(a!=b);
		System.out.println(!(a!=b));
		System.out.println(res++);
		System.out.println(res--);
		System.out.println(++res);
		System.out.println(--res);
		System.out.println(a==b&&a!=b);
		System.out.println(a==b||a!=b);
		if(a==b)System.out.println("Ok");
		System.out.println("Ok2");
		if(a!=b){
			System.out.println("if");
		}else if(res>a){
			System.out.println("else if");
		}else{
			System.out.println("else");
		}
		
		int i = 0;
		if(i==0){
			System.out.println("Zero");
			System.out.println("One");
			System.out.println("Two");
		}else if(i==1){
			System.out.println("One");
			System.out.println("Two");
		}else if(i==2){
			System.out.println("Two");
		}else{
			System.out.println("Other");
		}
		System.out.println("-----------------------------------");
		switch (i) {
		case 0:
			System.out.println("Zero");
		case 1:
			System.out.println("One");
		case 2: 
			System.out.println("Two");
			break;
		default:
			System.out.println("Other");
		}
		
		for(int j = 0; j++ < 10; ++j){
			System.out.println(j+1);
		}
		
		while(i<10)
			i++;
			System.out.println(i);
		
		
		do{
			i++;
			System.out.println(i);
		}while(i<10);
		
		
		double money = 1000;
		double percent = 0.2;
		int age = 23;
		for(; age<=65; age++){
			System.out.println(age+" "+money);
			money = money*(1+percent)+1000;
		}
		
		
		
		
	}
}