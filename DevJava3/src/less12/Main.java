package less12;

import java.util.LinkedList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> strings = new LinkedList<>();
		strings.add(0, "Petro");
		strings.add(1, "Ivan");
		strings.set(1, "Artem");
		strings.add("Mykola");
		System.out.println(strings);
		System.out.println(strings.size());
		System.out.println(strings.get(1));
		System.out.println(strings.remove(1));
		System.out.println(strings);
		for (String string : strings) {
			System.out.println(string);
		}
	}
}