package less12;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> strings = new LinkedList<>();
		strings.add("Ivan");
		strings.add(1,"Mykola");
		strings.set(1,"Petro");
		System.out.println(strings);
		System.out.println(strings.remove(1));
		System.out.println(strings);
		System.out.println(strings.get(0));
		System.out.println(strings.size());
		strings.add(1,"Mykola");
		for (String string : strings) {
			System.out.println(string);
		}
	}
}