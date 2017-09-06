package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import ua.entity.Brand;
import ua.filter.SimpleFilter;
import ua.repository.BrandRepository;
import ua.service.BrandService;

@Service
public class BrandServiceImpl extends CrudServiceImpl<Brand, Integer> implements BrandService {

	private final BrandRepository repository;
	
	@Autowired
	public BrandServiceImpl(BrandRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public Page<Brand> findAll(Pageable pageable, SimpleFilter filter) {
		return repository.findAll(filter(filter), pageable);
	}
	
	private Specification<Brand> filter(SimpleFilter filter){
		return (root, query, cb) -> {
			if(filter.getSearch().isEmpty()) return null;
			return cb.like(root.get("name"), filter.getSearch()+"%");
		};
	}
}