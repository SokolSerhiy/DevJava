package less20.saves;

import java.math.BigDecimal;
import java.util.Scanner;

import less08.user.User;
import less20.saves.domain.Item;
import less20.saves.domain.impl.ItemBF;
import less20.saves.domain.impl.ItemDB;
import less20.saves.domain.impl.ItemTF;

public class Main {
	
	static int userChoice = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isRun = true;
		System.out.println("Enter 1 to use tf");
		System.out.println("Enter 2 to use bf");
		System.out.println("Enter 3 to use db");
		userChoice = sc.nextInt();
		while (isRun) {
			System.out.println("Enter 1 to add item");
			switch (sc.next()) {
			case "1":
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter price");
				BigDecimal price = new BigDecimal(sc.next());
				Item item = getItem(name, price);
				item.save();
				break;
			default:
				isRun = false;
			}
		}
		sc.close();
	}
	
	static Item getItem(String name, BigDecimal price){
		switch (userChoice) {
		case 1:return new ItemTF(name, price);
		case 2:return new ItemBF(name, price);
		case 3:return new ItemDB(name, price);
		default:throw new IllegalArgumentException("userChoice can be from 1 to 3");
		}
	}
}
