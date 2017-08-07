package ua.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.entity.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

}
