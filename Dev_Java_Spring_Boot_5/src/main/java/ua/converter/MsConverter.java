package ua.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.Ms;
import ua.repository.MsRepository;

@Component
public class MsConverter implements Converter<String, Ms>{

	private final MsRepository repository;

	public MsConverter(MsRepository repository) {
		this.repository = repository;
	}

	@Override
	public Ms convert(String source) {
		return repository.findByName(source);
	}
}
