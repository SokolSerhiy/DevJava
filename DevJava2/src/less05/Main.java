package less05;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class Main {

	public static void main(String[] args) throws UnsupportedEncodingException {
		char[] array = {'a', 'b', 'c'};
		int[] array2 = {1,2,3};
		System.out.println(array);
		System.out.println(array2);
		String s1 = "Hello";
		String s2 = "Hello";
		String s3 = new String("Hello");
		System.out.println(s1.equals(s2));
		System.out.println(s1.equals(s3));
		System.out.println(s1.indexOf("lo"));
		String s = "All cars have the same properties, but the property values differ from car to car. All cars have the same methods, but the methods are performed at different times.";
		int index = 0;
		int i = 0;
		while(s.indexOf("a", index)!=-1){
			i++;
			index = s.indexOf("a", index)+1;
		}
		System.out.println(i);
		System.out.println(s1.charAt(0));
		System.out.println((char)s1.codePointAt(0));
		System.out.println(s1.codePointCount(1, 2));
		System.out.println("1".codePointAt(0));
		System.out.println("51485634656351554521692".chars().map(e->e-48).sum());
		System.out.println(null+"ldkjfjh");
		System.out.println(s1.contains("l"));
		System.out.println(Charset.defaultCharset());
		String utfString = "jsfhhdsf";
		String myString = new String(
			utfString.getBytes("UTF-8"), 
			Charset.defaultCharset());
		System.out.println(myString);
	}
}