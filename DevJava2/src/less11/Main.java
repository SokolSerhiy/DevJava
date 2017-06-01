package less11;

import static less09.Color.BLACK;
import static less09.Color.BLUE;
import static less09.Color.RED;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import less09.Box;
import less09.Cpu;
import less09.Ram;

public class Main {

	public static void main(String[] args) {
		List<Box> boxes = new ArrayList<>();
		boxes.add(new Box(BLACK, new Cpu(3.6), new Ram(8)));
		boxes.add(new Box(RED, new Cpu(3.1), new Ram(6)));
		boxes.add(new Box(BLUE, new Cpu(3.6), new Ram(16)));
		boxes.add(new Box(BLACK, new Cpu(2.5), new Ram(4)));
		boxes.add(new Box(BLACK, new Cpu(3.6), new Ram(8)));
//		for (Box box : boxes) {
//			if(box.getColor()==BLACK){
//				boxes.remove(box);
//			}
//		}
//		for(int i = 0; i < boxes.size(); i++){
//			if(boxes.get(i).getColor()==BLACK){
//				boxes.remove(i);
//				i--;
//			}
//		}
		Iterator<Box> iterator = boxes.iterator();
		while(iterator.hasNext()){
			Box box = iterator.next();
			if(box.getColor()==BLACK&&box.getRam().getVolume()>=4){
				iterator.remove();
			}
		}
		boxes.add(new Box(BLACK, new Cpu(3.6), new Ram(8)));
		boxes.add(new Box(BLACK, new Cpu(2.5), new Ram(4)));
		boxes.add(new Box(BLACK, new Cpu(3.6), new Ram(8)));
		boxes.forEach(System.out::println);
		System.out.println();
		ListIterator<Box> listIter = boxes.listIterator(boxes.size());
		while(listIter.hasPrevious()){
			System.out.println(listIter.previousIndex());
			System.out.println(listIter.previous());
		}
	}
}