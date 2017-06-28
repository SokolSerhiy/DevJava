package less20.saves.dao;

import java.util.List;

import less20.saves.domain.Item;

public interface ItemDao {

	Item findOne(String id);
	
	List<Item> findAll();
}
