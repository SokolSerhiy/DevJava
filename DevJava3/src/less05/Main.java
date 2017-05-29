package less05;

public class Main {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		String s4 = s1;
		s1+="!";
		System.out.println(s4);
		System.out.println(s2.equals(s3));
		System.out.println(s2.indexOf("l", 3)!=-1);
		System.out.println(s2.contains("l"));
		indexOf(s2, "o");
		System.out.println(s2.length());
		System.out.println(s2.endsWith("llo"));
		System.out.println(s2.substring(1, 4));
		System.out.println(s2.trim());
		System.out.println(s2.charAt(2));
		System.out.println(s2.codePointAt(2));
		System.out.println(s2==s3.intern());
	}
	
	static void indexOf(String str, String finded){
		int index = 0;
		while (str.indexOf(finded, index)!=-1) {
			index = str.indexOf(finded, index);
			System.out.println(index);
			index++;
		}
	}
}