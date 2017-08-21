package ua.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Component;
import ua.model.request.ComponentRequest;
import ua.model.view.ComponentView;
import ua.repository.ComponentRepository;
import ua.service.ComponentService;

@Service
public class ComponentServiceImpl implements ComponentService{

	private final ComponentRepository repository;
	
	@Autowired
	public ComponentServiceImpl(ComponentRepository repository) {
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

	@Override
	public void save(ComponentRequest request) {
		Component component = new Component();
		component.setAmount(new BigDecimal(request.getAmount()));
		component.setId(request.getId());
		component.setIngredient(request.getIngredient());
		component.setMs(request.getMs());
		repository.save(component);
	}

	@Override
	public ComponentRequest findOneRequest(Integer id) {
		Component component = repository.findOneRequest(id);
		ComponentRequest request = new ComponentRequest();
		request.setAmount(String.valueOf(component.getAmount()));
		request.setId(component.getId());
		request.setIngredient(component.getIngredient());
		request.setMs(component.getMs());
		return request;
	}

	@Override
	public void delete(Integer id) {
		repository.delete(id);
	}
}