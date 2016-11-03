package lesson2;

public class Main2 {

	public static void main(String[] args) {
		for (int i = 1; i < 9; i++) {
			for (int j = i; j > 0; j--) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.print(i*j+" ");
				if(j*i<10) System.out.print(" ");
			}
			System.out.println();
		}
		int k = 0;
		for(int i = 1; i <= 300; i++){
			if(i%3==0||i%4==0){
				System.out.println(i);
				k++;
			}
			if(k==10)break;
		}
		int n = 20;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum+=i;
		}
		System.out.println("The Sum is:"+sum);
		System.out.println("The Avg is:"+sum/n);
	}

}
