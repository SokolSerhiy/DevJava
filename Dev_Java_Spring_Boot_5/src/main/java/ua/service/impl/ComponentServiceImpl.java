package ua.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Component;
import ua.model.view.ComponentView;
import ua.repository.ComponentRepository;
import ua.service.ComponentService;

@Service
public class ComponentServiceImpl extends CrudServiceImpl<Component, Integer> implements ComponentService{

	private final ComponentRepository repository;
	
	@Autowired
	public ComponentServiceImpl(ComponentRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Override
	public List<String> findAllIngredients() {
		return repository.findAllIngredients();
	}

	@Override
	public List<String> findAllMss() {
		return repository.findAllMss();
	}

	@Override
	public List<ComponentView> findAllView() {
		return repository.findAllView();
	}
}