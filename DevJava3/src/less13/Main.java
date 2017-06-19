package less13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("Petro");
		strings.add("Mykola");
		strings.add("Ivan");
		Iterator<String> iter = strings.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
//		for (String string : strings) {
//			strings.remove(string);
//		}
		iter = strings.iterator();
//		strings.add("Ivan");
		while (iter.hasNext()) {
			String tmp = iter.next();
			if(tmp.startsWith("M")&&tmp.contains("a")){
				iter.remove();
			}
		}
		System.out.println(strings);
		ListIterator<String> listIter = 
				strings.listIterator(strings.size());
		while(listIter.hasPrevious()){
			String tmp = listIter.previous();
			System.out.println(tmp+" "+listIter.nextIndex());
		}
	}
}