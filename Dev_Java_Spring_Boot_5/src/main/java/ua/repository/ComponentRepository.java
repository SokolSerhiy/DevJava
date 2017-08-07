package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Component;

public interface ComponentRepository extends JpaRepository<Component, Integer>{

}
