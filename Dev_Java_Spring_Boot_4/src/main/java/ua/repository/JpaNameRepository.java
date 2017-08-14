package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import ua.entity.AbstractEntityName;

@NoRepositoryBean
public interface JpaNameRepository<T extends AbstractEntityName> extends JpaRepository<T, Integer>{

	T findByName(String name);
	
	boolean existsByName(String name);
}
