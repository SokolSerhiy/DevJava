package core.less8;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		list.add("Ivan");
		list.add("Petro");
		list.add("Mykola");
		Iterator<String> iter = list.iterator();
		while (iter.hasNext()) {
			String tmp = iter.next();
			if(tmp.startsWith("I")||tmp.startsWith("P")){
				iter.remove();
			}
		}
		System.out.println(list);
		ListIterator<String> lIter = list.listIterator();
	}
}