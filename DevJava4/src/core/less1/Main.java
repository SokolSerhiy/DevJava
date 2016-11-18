package core.less1;

public class Main {

	public static void main(String[] args) {
		String s = "Hello";
		String s1 = "Hello";
		String s2 = new String("hello");
		String s3 = null;
		System.out.println(s==s1);
		System.out.println(s==s2);
		System.out.println(s.charAt(0));
		System.out.println(s.chars().sum());
		System.out.println(s.codePointAt(0));
		System.out.println(s.compareTo(s2));
		System.out.println(s3+s);
//		System.out.println(s.concat(s3));
		System.out.println(s.equals(s2));
		System.out.println(s.equalsIgnoreCase(s2));
		System.out.println(s.contains("ll"));
		StringBuffer cs = new StringBuffer("Hello");
		System.out.println(s.contentEquals(cs));
		System.out.println(s.endsWith(".png"));
		System.out.println(s.indexOf("l"));
		System.out.println(s.indexOf("l", s.indexOf("l")+1));
		System.out.println("  ".trim().isEmpty());
		System.out.println(s.length());
		System.out.println(s.matches("^[A-Za-z]+$"));
		System.out.println(s.replace("ll", "dsfgdsg"));
		System.out.println("When working with form fields, you often want to perform some behavior after a value has been selected or deselected. Whenever a user selects a field in Chosen, it triggers a 'change' event on the original form field. That lets you do something like this:"
		.replaceAll("\\w+", "1234"));
		String[] array = "When working with form fields, you often want to perform some behavior after a value has been selected or deselected. Whenever a user selects a field in Chosen, it triggers a 'change' event on the original form field. That lets you do something like this:".split("[\\ \\. \\'\\:\\,]+");
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println(delete("Hello I am hero", "ll"));
		//Hllo I am hro
	}
	
	static String delete(String str, String deleted){
		while(str.contains(deleted)){
			int index = str.indexOf(deleted);
			String first = str.substring(0, index);
			String second = str.substring(index+deleted.length());
			str = first+second;
		}
		return str;
	}

}
