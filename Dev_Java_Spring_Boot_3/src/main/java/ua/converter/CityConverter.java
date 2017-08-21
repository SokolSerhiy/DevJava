package ua.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.City;
import ua.repository.CityRepository;

@Component
public class CityConverter implements Converter<String, City>{

	private final CityRepository repository;
	
	public CityConverter(CityRepository repository) {
		this.repository = repository;
	}

	@Override
	public City convert(String name) {
		return repository.findByName(name);
	}

}
