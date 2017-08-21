package ua.service;

import java.util.List;

import ua.model.request.CargoRequest;
import ua.model.view.CargoView;

public interface CargoService {

	List<String> findAllGoods();
	
	List<String> findAllCity();
	
	List<CargoView> findAllView();
	
	void save(CargoRequest request);

	void delete(Integer id);

	CargoRequest findOne(Integer id);
	
	
}
