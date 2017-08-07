package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Cuisine;

public interface CuisineRepository extends JpaRepository<Cuisine, Integer>{

}
