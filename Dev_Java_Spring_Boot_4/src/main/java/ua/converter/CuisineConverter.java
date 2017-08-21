package ua.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.Cuisine;
import ua.repository.CuisineRepository;

@Component
public class CuisineConverter implements Converter<String, Cuisine>{

	private final CuisineRepository repository;
	
	public CuisineConverter(CuisineRepository repository) {
		this.repository = repository;
	}

	@Override
	public Cuisine convert(String source) {
		return repository.findByName(source);
	}

}
