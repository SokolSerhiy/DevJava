package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.request.CargoRequest;
import ua.model.view.CargoView;

public interface CargoService {

	List<String> findAllGoods();
	
	List<String> findAllCity();
	
	Page<CargoView> findAllView(Pageable pageable);
	
	void save(CargoRequest request);

	void delete(Integer id);

	CargoRequest findOne(Integer id);
	
	
}
