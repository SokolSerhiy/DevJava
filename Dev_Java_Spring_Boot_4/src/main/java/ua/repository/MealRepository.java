package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Integer>{

}
