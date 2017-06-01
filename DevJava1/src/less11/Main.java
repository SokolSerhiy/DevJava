package less11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import less09.Box;
import static less09.Color.*;
import less09.Cpu;
import less09.Ram;

public class Main {

	public static void main(String[] args) {
		List<Box> boxes = new ArrayList<>();
		boxes.add(new Box(GREEN, new Cpu(3.6), new Ram(8)));
		boxes.add(new Box(WHITE, new Cpu(3.1), new Ram(6)));
		boxes.add(new Box(RED, new Cpu(2.6), new Ram(4)));
		boxes.add(new Box(WHITE, new Cpu(3.6), new Ram(16)));
//		for (Box box : boxes) {
//			if(box.getColor()==WHITE){
//				boxes.remove(box);
//			}
//		}
//		for(int i = 0; i < boxes.size(); i++){
//			if(boxes.get(i).getColor()==WHITE){
//				boxes.remove(i);
//				i--;
//			}
//		}
		Iterator<Box> iterator = boxes.iterator();
		while (iterator.hasNext()) {
			Box box = iterator.next();
			if(box.getColor()==WHITE&&box.getRam().getVolume()>=6){
				iterator.remove();
			}
		}
		System.out.println(iterator.hasNext());
		boxes.forEach(System.out::println);
		boxes.add(new Box(WHITE, new Cpu(3.1), new Ram(6)));
		boxes.add(new Box(WHITE, new Cpu(3.6), new Ram(16)));
		ListIterator<Box> listIterator = boxes.listIterator(boxes.size());
		System.out.println();
		while (listIterator.hasPrevious()) {
			Box box = listIterator.previous();
			System.out.println(box);
		}
	}
}