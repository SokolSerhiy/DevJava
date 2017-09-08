package ua.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.TransporterFilter;
import ua.model.view.TransporterIndexView;

public interface TransporterService {

	Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable);

	List<String> findAllModels();
	
	List<String> findAllBrands();
	
	List<String> findAllCities();
}
