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
		synchronized (MyThread.class) {
			list.add((int) (Math.random() * 100));
		}
	}

	public int remove() {
		int remove = (int) (Math.random() * 100);
		synchronized (MyThread.class) {
			Iterator<Integer> iter = list.iterator();
			while (iter.hasNext()) {
				Integer tmp = iter.next();
				if (tmp != null && tmp == remove) {
					iter.remove();
					return tmp;
				}
			}
			return -1;
		}
	}
}
