package less05;

public class Main {

	public static void main(String[] args) {
//		int[] array = new int[4];
//		for (int i = 0; i < array.length; i++) {
//			array[i] = random(10, 99);
//		}
//		boolean asc = true;
//		for (int i = 1; i < array.length; i++) {
//			asc = asc && array[i-1]<array[i];
//			if(!asc) break;
//		}
//		System.out.println(Arrays.toString(array));
//		if(asc)System.out.println("Зростаюча");
//		else System.out.println("Не строго зростаюча");
		
		char[] array = {'a', 'b', 'c'};
		System.out.println(array);
		int[] array1 = new int[10];
		System.out.println(array1);
		
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.indexOf("ll"));
		System.out.println(s1.contains("ll"));
		System.out.println(s1.charAt(0));
		s1.chars().forEach(System.out::println);
		System.out.println((char)s1.codePointAt(0));
		System.out.println(s1.codePointCount(0, 2));
		System.out.println(s1.compareTo("Hello"));
		System.out.println('!'-' ');
		System.out.println(null + "jdsfjhdjf");
		System.out.println("".isEmpty());
		System.out.println(s1.replace('e', 'a'));
		
	}
	
	static int random(int min, int max){
		return (int)Math.round(Math.random()*(max-min)+min);
	}
}