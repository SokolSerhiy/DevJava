package ua.service;

import ua.entity.Goods;

public interface GoodsService extends CrudService<Goods, Integer>{

	Goods findByName(String name);
}
