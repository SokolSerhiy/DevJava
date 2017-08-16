package ua.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.entity.Cargo;
import ua.model.view.CargoView;
import ua.repository.CargoRepository;
import ua.service.CargoService;

@Service
public class CargoServiceImpl implements CargoService{

	private final CargoRepository repository;
	
	public CargoServiceImpl(CargoRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<String> findAllGoods() {
		return repository.findAllGoods();
	}

	@Override
	public List<String> findAllCity() {
		return repository.findAllCity();
	}

	@Override
	public List<CargoView> findAllView() {
		return repository.findAllView();
	}

	@Override
	public void save(Cargo cargo) {
		repository.save(cargo);
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}

}
