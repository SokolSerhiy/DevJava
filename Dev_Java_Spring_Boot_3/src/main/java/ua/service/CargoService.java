package ua.service;

import java.util.List;

import ua.entity.Cargo;
import ua.model.view.CargoView;

public interface CargoService {

	List<String> findAllGoods();
	
	List<String> findAllCity();
	
	List<CargoView> findAllView();
	
	void save(Cargo cargo);

	void delete(Integer id);
	
	
}
