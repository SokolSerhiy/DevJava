package ua.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.Model;
import ua.repository.ModelRepository;

@Component
public class ModelConverter implements Converter<String, Model>{

	private final ModelRepository repository;
	
	public ModelConverter(ModelRepository repository) {
		this.repository = repository;
	}

	@Override
	public Model convert(String source) {
		return repository.findByName(source);
	}

}
