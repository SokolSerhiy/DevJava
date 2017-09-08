package ua.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import ua.model.filter.TransporterFilter;
import ua.model.view.TransporterIndexView;
import ua.repository.TransporterRepository;
import ua.repository.TransporterViewRepository;
import ua.service.TransporterService;

@Service
public class TransporterServiceImpl implements TransporterService{

	private final TransporterRepository repository;
	
	private final TransporterViewRepository viewRepository;
	
	public TransporterServiceImpl(TransporterRepository repository, TransporterViewRepository viewRepository) {
		this.repository = repository;
		this.viewRepository = viewRepository;
	}

	@Override
	public Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable) {
		return viewRepository.findAll(filter, pageable);
	}

	@Override
	public List<String> findAllModels() {
		return repository.findAllModels();
	}

	@Override
	public List<String> findAllBrands() {
		return repository.findAllBrands();
	}

	@Override
	public List<String> findAllCities() {
		return repository.findAllCities();
	}
}