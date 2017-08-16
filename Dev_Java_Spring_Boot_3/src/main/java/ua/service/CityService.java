package ua.service;

import ua.entity.City;

public interface CityService extends CrudService<City, Integer>{

	City findByName(String name);
}
