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
			System.out.println("Enter 3 to show items by ram");
			System.out.println("Enter 4 to show items by color");
			switch (sc.next()) {
			case "1": {
				System.out.println("Enter cpu frequency");
				double frequency = sc.nextDouble();
				System.out.println("Enter ram volume");
				int volume = sc.nextInt();
				System.out.println("Enter color of box");
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
				System.out.println("Enter ram volume");
				int volume = sc.nextInt();
				for (Box box : list) {
					if(box.getRam().getVolume()==volume){
						System.out.println(box);
					}
				}
				break;
			}
			case "4": {
				System.out.println("Enter color of box");
				Color color = Color.valueOf(sc.next().toUpperCase());
				for (Box box : list) {
					if(box.getColor()==color){
						System.out.println(box);
					}
				}
				break;
			}
			case "5": {
				System.out.println("Enter color of box");
				Color color = Color.valueOf(sc.next().toUpperCase());
				System.out.println("Enter min frequency");
				double minFrequency = sc.nextDouble();
				System.out.println("Enter max frequency");
				double maxFrequency = sc.nextDouble();
				System.out.println("Enter min volume");
				int min = sc.nextInt();
				System.out.println("Enter max volume");
				int max = sc.nextInt();
				list.stream()
				.filter(e->e.getColor()==color)
				.filter(e->e.getCpu().getFrequency()>=minFrequency)
				.filter(e->e.getCpu().getFrequency()<=maxFrequency)
				.filter(e->e.getRam().getVolume()<=max)
				.filter(e->e.getRam().getVolume()>=min)
				.forEach(System.out::println);
				break;
			}
			default:
				isRun = false;
			}
		}
	}
}