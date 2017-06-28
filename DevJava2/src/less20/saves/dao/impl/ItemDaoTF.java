package less20.saves.dao.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import less20.saves.dao.ItemDao;
import less20.saves.domain.Item;
import less20.saves.domain.impl.ItemTF;

public class ItemDaoTF implements ItemDao{

	@Override
	public Item findOne(String id) {
		File file = new File("saves/save.txt");
		try(Scanner sc = new Scanner(file)){
			String line = sc.nextLine();
			if(!line.isEmpty()){
				String[] fields = line.split(" ");
				if(fields[0].equals(id)){
					return new ItemTF(fields[0], fields[1], new BigDecimal(fields[2]), LocalDate.parse(fields[3]));
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> findAll() {
		File file = new File("saves/save.txt");
		List<Item> items = new ArrayList<>();
		try(Scanner sc = new Scanner(file)){
			String line = sc.nextLine();
			if(!line.isEmpty()){
				String[] fields = line.split(" ");
					items.add(new ItemTF(fields[0], fields[1], new BigDecimal(fields[2]), LocalDate.parse(fields[3])));
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return items;
	}
}
