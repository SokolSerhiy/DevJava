package ua.service.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.entity.Role;
import ua.entity.Transporter;
import ua.entity.User;
import ua.model.request.OwnerRequest;
import ua.model.request.TransporterRequest;
import ua.repository.UserRepository;
import ua.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final UserRepository repository;
	
	private final PasswordEncoder encoder;
	
	public UserServiceImpl(UserRepository repository, PasswordEncoder encoder) {
		this.repository = repository;
		this.encoder = encoder;
	}

	@Override
	public void save(TransporterRequest request) {
		User user = new User();
		user.setEmail(request.getEmail());
		user.setPassword(encoder.encode(request.getPassword()));
		user.setRole(Role.ROLE_TRANSPORTER);
		Transporter transporter = new Transporter();
		transporter.setAge(Integer.valueOf(request.getAge()));
		transporter.setCarAge(Integer.valueOf(request.getCarAge()));
		transporter.setMaxWeight(Integer.valueOf(request.getMaxWeight()));
		transporter.setName(request.getName());
		transporter.setPhone(request.getPhone());
		transporter.setModel(request.getModel());
		transporter.setUser(user);
		user.setTransporter(transporter);
		repository.save(user);
	}

	@Override
	public void save(OwnerRequest request) {
		
	}

	@Override
	public List<String> findAllModels() {
		return repository.findAllModels();
	}

}
