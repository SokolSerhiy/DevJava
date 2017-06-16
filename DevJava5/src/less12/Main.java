package less12;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("Petro");
		strings.add("Ivan");
		strings.add("Mykola");
		System.out.println(strings);
		System.out.println(strings.set(1, "Artem"));
		System.out.println(strings);
		System.out.println(strings.size());
		System.out.println(strings.get(0));
		for (String string : strings) {
			System.out.println(string);
		}
	}
}