package ua.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.entity.Cafe;
import ua.repository.CafeRepository;
import ua.service.CafeService;

@Service
public class CafeServiceImpl extends CrudServiceImpl<Cafe, Integer> implements CafeService {

	@Autowired
	public CafeServiceImpl(CafeRepository repository) {
		super(repository);
	}
}