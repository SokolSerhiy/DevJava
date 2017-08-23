package ua.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

	User findByEmail(String email);
	@Query("SELECT m.name FROM Model m")
	List<String> findAllModels();
}
