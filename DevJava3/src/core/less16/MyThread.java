package core.less16;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyThread extends Thread {

	private static volatile List<Integer> list = new ArrayList<>();

	public MyThread() {
		start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			add();
			System.out.println(remove() + " " + getName());
		}
	}

	public void add() {
		synchronized (list) {
			list.add((int) (Math.random() * 100));
		}
	}

	public int remove() {
		synchronized (list) {
			Iterator<Integer> iter = list.iterator();
			int remove = (int) (Math.random() * 100);
			while (iter.hasNext()) {
				Integer tmp = iter.next();
				if (tmp != null && remove == tmp) {
					iter.remove();
					return tmp;
				}
			}
			return -1;
		}
	}
}