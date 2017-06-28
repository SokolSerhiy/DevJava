package less20.saves.dao.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import less20.saves.dao.ItemDao;
import less20.saves.domain.Item;
import less20.saves.domain.impl.ItemBF;

public class ItemDaoBF implements ItemDao{
	
	@Override
	public Item findOne(String id) {
		File file = new File("saves/bf/"+id+".save");
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
			return (ItemBF) ois.readObject();
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Item> findAll() {
		File file = new File("saves/bf");
		File[] files = file.listFiles();
		List<Item> items = new ArrayList<>();
		for (int i = 0; i < files.length; i++) {
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(files[i]))){
				items.add((ItemBF) ois.readObject());
			}catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
}
