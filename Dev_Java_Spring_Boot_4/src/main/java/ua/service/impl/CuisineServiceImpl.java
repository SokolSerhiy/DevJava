package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Cuisine;
import ua.repository.CuisineRepository;
import ua.service.CuisineService;

@Service
public class CuisineServiceImpl extends CrudServiceImpl<Cuisine, Integer> implements CuisineService{

	@Autowired
	public CuisineServiceImpl(CuisineRepository repository) {
		super(repository);
	}

}
