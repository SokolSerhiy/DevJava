package core.less1;

public class Main {

	public static void main(String[] args) {
		String s = "Hello";
		String s1 = "Hello";
		String s2 = new String("hello");
		System.out.println(s==s1);
		System.out.println(s==s2);
		System.out.println(s.equals(s1));
		System.out.println(s.equalsIgnoreCase(s2));
		System.out.println(s.charAt(0));
		System.out.println(s.chars().sum());
		System.out.println(s.codePointAt(4));
		System.out.println(s.codePointCount(0, 5));
		System.out.println(s.compareTo(s));
		System.out.println(s+s);
		System.out.println(s);
		System.out.println(s.contains("ll"));
		System.out.println(s.endsWith(".png"));
		System.out.println(s.indexOf("ll"));
		System.out.println(s.indexOf("l", 3));
		System.out.println("".isEmpty());
		System.out.println(s.matches("^\\w+$"));
		System.out.println(s.startsWith("el", 1));
		System.out.println(s.substring(2, 4));
		System.out.println(delete("Hello I am hero", "ll"));
		//Hllo I am hro
	}
	
	static String delete(String str, String deleted){
		while(str.contains(deleted)){
			str = str.substring(0, str.indexOf(deleted))+
			str.substring(str.indexOf(deleted)+deleted.length());
		}
		return str;
	}
}