package lesson3;


public class Main {

	public static void main(String[] args) {
		int[] array = {1,2,3,4,5,6,7,8,9};
		int[] array2 = new int[10];
		int i1 = array[1];
		array[1] = 1;
		for (int j = 0; j < array2.length; j++) {
			System.out.println(array2[i1]);
		}
		
		for(int a=-166,i=0;a<100&&a>-100;a=2*a+200, i++){
            if(a>-100&&(a<-9||a>9))System.out.print(a+" ");
		}
		
	}
	
	static int asdf(){
		return 0;
	}
}