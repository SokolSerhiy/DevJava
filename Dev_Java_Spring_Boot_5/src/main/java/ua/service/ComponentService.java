package ua.service;

import java.util.List;

import ua.entity.Component;
import ua.model.view.ComponentView;

public interface ComponentService extends CrudService<Component, Integer>{

	List<String> findAllIngredients();

	List<String> findAllMss();

	List<ComponentView> findAllView();

}
