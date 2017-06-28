package less20.saves;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import less20.saves.dao.ItemDao;
import less20.saves.dao.impl.ItemDaoBF;
import less20.saves.dao.impl.ItemDaoDB;
import less20.saves.dao.impl.ItemDaoTF;
import less20.saves.domain.Item;
import less20.saves.domain.impl.ItemBF;
import less20.saves.domain.impl.ItemDB;
import less20.saves.domain.impl.ItemTF;

public class Main {
	
	private static int userChoice = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		choice(sc);
		boolean isRun = true;
		while (isRun) {
			System.out.println("Enter 1 to change save type");
			System.out.println("Enter 2 to add item");
			System.out.println("Enter 3 to show all items");
			System.out.println("Enter 4 to find item by id");
			switch (sc.next()) {
			case "1":
				choice(sc);
				break;
			case "2":
				add(sc);
				break;
			case "3":
				showAll();
				break;
			case "4":
				showOne(sc);
				break;
			default:
				isRun = false;
			}
		}
	}
	
	static void showAll(){
		List<Item> items = abstractFactory().findAll();
		for (Item item : items) {
			System.out.println(item.getId()+" "+item.getName()+" "+item.getPrice()+" "+item.getDate());
		}
	}
	
	static void showOne(Scanner sc){
		System.out.println("Enter id");
		String id = sc.next();
		Item item = abstractFactory().findOne(id);
		System.out.println(item.getId()+" "+item.getName()+" "+item.getPrice()+" "+item.getDate());
	}
	
	static void add(Scanner sc){
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter price");
		BigDecimal price = new BigDecimal(sc.next());
		Item item = factory(name, price);
		item.save();
	}

	static void choice(Scanner sc){
		System.out.println("Enter 1 to chose BF");
		System.out.println("Enter 2 to chose TF");
		System.out.println("Enter 3 to chose DB");
		userChoice = sc.nextInt();
	}
	
	static Item factory(String name, BigDecimal price){
		switch (userChoice) {
		case 1:return new ItemBF(name, price);
		case 2:return new ItemTF(name, price);
		case 3:return new ItemDB(name, price);
		default:throw new IllegalArgumentException("userChoice can be from 1 to 3");
		}
	}
	
	static ItemDao abstractFactory(){
		switch (userChoice) {
		case 1:return new ItemDaoBF();
		case 2:return new ItemDaoTF();
		case 3:return new ItemDaoDB();
		default:throw new IllegalArgumentException("userChoice can be from 1 to 3");
		}
	}
}
