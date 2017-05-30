package less10;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import less09.*;

public class Main {

	public static void main(String[] args) {
		List<Box> list = new ArrayList<>();
		List<String> linList = new LinkedList<>();
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to add computer to list");
			System.out.println("Enter 2 to show all items");
			System.out.println("Enter 3 to show items by volume");
			System.out.println("Enter 4 to show items by color");
			switch (sc.next()) {
			case "1": {
				System.out.println("Enter frequency");
				double frequency = sc.nextDouble();
				System.out.println("Enter volume");
				int volume = sc.nextInt();
				System.out.println("Enter color");
				Color color = Color.valueOf(sc.next().toUpperCase());
				Box box = new Box(color, new Cpu(frequency), new Ram(volume));
				list.add(box);
				break;
			}
			case "2": {
				for (Box box : list) {
					System.out.println(box);
				}
				break;
			}
			case "3": {
				System.out.println("Enter volume");
				int volume = sc.nextInt();
				for (Box box : list) {
					if(box.getRam().getVolume()==volume){
						System.out.println(box);
					}
				}
				break;
			}
			case "4": {
				System.out.println("Enter color");
				for(int i = 0; i < Color.values().length; i++){
					System.out.println("Enter "+i+" to chose "+
							Color.values()[i].name().toLowerCase());
				}
				int index = sc.nextInt();
				Color color = Color.values()[index];
				for (Box box : list) {
					if(box.getColor()==color){
						System.out.println(box);
					}
				}
				break;
			}
			default:
				isRun = false;
			}
		}
	}
}