package ua.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Brand;
import ua.repository.BrandRepository;
import ua.service.BrandService;

@Service
public class BrandServiceImpl extends CrudServiceImpl<Brand, Integer> implements BrandService {

	@Autowired
	public BrandServiceImpl(BrandRepository repository) {
		super(repository);
	}

	
}