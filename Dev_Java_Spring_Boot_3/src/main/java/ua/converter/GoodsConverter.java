package ua.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import ua.entity.Goods;
import ua.repository.GoodsRepository;

@Component
public class GoodsConverter implements Converter<String, Goods>{

	private final GoodsRepository repository;
	
	public GoodsConverter(GoodsRepository repository) {
		this.repository = repository;
	}

	@Override
	public Goods convert(String source) {
		return repository.findByName(source);
	}
}
