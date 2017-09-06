package ua.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.entity.Cuisine;
import ua.model.filter.SimpleFilter;

public interface CuisineService extends CrudService<Cuisine, Integer>{

	Page<Cuisine> findAll(Pageable pageable);

	Page<Cuisine> findAll(Pageable pageable, SimpleFilter filter);

}
