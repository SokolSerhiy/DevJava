package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{

	@Query("FROM Cargo WHERE weight=?1")
	Cargo findByWeight(int weight);
}