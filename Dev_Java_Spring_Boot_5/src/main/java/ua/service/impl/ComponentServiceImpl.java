package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Component;
import ua.repository.ComponentRepository;
import ua.service.ComponentService;

@Service
public class ComponentServiceImpl extends CrudServiceImpl<Component, Integer> implements ComponentService{

	@Autowired
	public ComponentServiceImpl(ComponentRepository repository) {
		super(repository);
	}

}