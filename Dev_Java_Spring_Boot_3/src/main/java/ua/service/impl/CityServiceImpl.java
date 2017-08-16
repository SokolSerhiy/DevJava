package ua.service.impl;

import org.springframework.stereotype.Service;

import ua.entity.City;
import ua.repository.CityRepository;
import ua.service.CityService;

@Service
public class CityServiceImpl extends CrudServiceImpl<City, Integer> implements CityService{

	private final CityRepository repository;
	
	public CityServiceImpl(CityRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public City findByName(String name) {
		return repository.findByName(name);
	}
}
