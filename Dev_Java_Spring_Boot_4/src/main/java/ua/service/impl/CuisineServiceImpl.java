package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.entity.Cuisine;
import ua.repository.CuisineRepository;
import ua.service.CuisineService;

@Service
public class CuisineServiceImpl extends CrudServiceImpl<Cuisine, Integer> implements CuisineService{

	private final CuisineRepository repository;
	
	@Autowired
	public CuisineServiceImpl(CuisineRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Cuisine> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

}
