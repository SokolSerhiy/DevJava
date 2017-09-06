package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.entity.Cuisine;
import ua.model.filter.SimpleFilter;
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

	@Override
	public Page<Cuisine> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
	}
	
	private Specification<Cuisine> filter(SimpleFilter filter){
		return (root, query, cb) ->{
			if(filter.getSearch().isEmpty()) return null;
			return cb.like(root.get("name"), filter.getSearch()+"%");
		};
	}
}