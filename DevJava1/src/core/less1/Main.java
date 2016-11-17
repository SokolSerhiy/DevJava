package core.less1;

public class Main {

	public static void main(String[] args) {
		String s = "Hello";
		String s1 = "Hello";
		String s2 = new String("Hello");
		System.out.println(s==s1);
		System.out.println(s==s2);
		System.out.println(s.equals(s2));
		System.out.println(s.equalsIgnoreCase(s2));
		System.out.println(s.charAt(0));
		System.out.println(s.chars().sum());
		System.out.println(s.codePointAt(0));
		System.out.println(s.codePointBefore(1));
		System.out.println(s.codePointCount(0, 5));
		System.out.println(s.codePoints().sum());
		System.out.println(s.compareTo(s2));
		System.out.println(s.compareToIgnoreCase(s2));
		System.out.println(s2+s2);
		System.out.println(s.contains("ello"));
		System.out.println(s.endsWith("llo"));
		System.out.println(s.indexOf("l"));
		System.out.println(s.indexOf("l", s.indexOf("l")+1));
		System.out.println("".isEmpty());
		System.out.println(s.matches("^\\w+$"));
		//Hllo I am hro
		System.out.println(delete("Hello I am hero", "ll"));
	}

	static String delete(String str, String deleted){
		while(str.contains(deleted)){
			str = str.substring(0, str.indexOf(deleted))+
			str.substring(str.indexOf(deleted)+deleted.length());
		}
		return str;
	}
}