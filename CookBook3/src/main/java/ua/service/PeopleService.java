package ua.service;

import java.util.List;

import ua.entity.People;

public interface PeopleService {

	List<People> findAll();
	
	People save(People people);
	
	People findOne(Long id);
	
	void delete(Long id);
}
