package less05;

public class Main {

	public static void main(String[] args) {
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s1==s3.intern());
		String s4 = s1;
		s1+="!";
		System.out.println(s4);
		System.out.println(s2.equals(s3));
		System.out.println(s2.indexOf("l")!=-1);
		System.out.println(s2.contains("l"));
		System.out.println(s2.charAt(1));
		System.out.println(s2.codePointAt(1));
		System.out.println(s2.compareTo("Zello"));
		System.out.println(s2.endsWith("llo"));
		System.out.println(s2.length());
		System.out.println(s2.substring(1, 4));
		System.out.println(s2.trim());
	}
}