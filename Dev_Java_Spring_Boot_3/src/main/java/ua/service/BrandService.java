package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Brand;
import ua.filter.SimpleFilter;

public interface BrandService extends CrudService<Brand, Integer>{

	Page<Brand> findAll(Pageable pageable, SimpleFilter filter);

}
