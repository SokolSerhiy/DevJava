package ua.service;

import java.util.List;

import ua.model.request.OwnerRequest;
import ua.model.request.TransporterRequest;

public interface UserService {

	void save(TransporterRequest request);
	
	void save(OwnerRequest request);
	
	List<String> findAllModels();
}