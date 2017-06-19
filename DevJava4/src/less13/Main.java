package less13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("Ivan");
		strings.add("Mykola");
		strings.add("Petro");
		System.out.println(strings);
//		for (String string : strings) {
//			if(string.startsWith("M")){
//				strings.remove(string);
//			}
//		}
//		for(int i = 0; i < strings.size(); i++){
//			if(strings.get(i).startsWith("M")
//					||strings.get(i).contains("o")){
//				strings.remove(i);
//				i--;
//			}
//		}
		Iterator<String> iter = strings.iterator();
		while(iter.hasNext()){
			String tmp = iter.next();
			if(tmp.startsWith("M")
					&&tmp.contains("o")){
				iter.remove();
			}
		}
		System.out.println(strings);
		strings.add("Mykola");
		ListIterator<String> listIter = strings.listIterator(strings.size());
		while(listIter.hasPrevious()){
			String tmp = listIter.previous();
			System.out.println(tmp+" "+listIter.nextIndex());
		}
	}
}
