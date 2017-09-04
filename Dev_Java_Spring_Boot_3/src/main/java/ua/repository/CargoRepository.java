package ua.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Cargo;
import ua.model.view.CargoView;

public interface CargoRepository extends JpaRepository<Cargo, Integer>{

	@Query("FROM Cargo WHERE weight=?1")
	Cargo findByWeight(int weight);
	
	@Query("SELECT g.name FROM Goods g")
	List<String> findAllGoods();
	
	@Query("SELECT c.name FROM City c")
	List<String> findAllCity();
	
	@Query(value="SELECT new ua.model.view.CargoView(c.id, g.name, c.weight, c.height, c.width, c.length, cFrom.name, cTo.name, c.price) FROM Cargo c JOIN c.goods g JOIN c.cityFrom cFrom JOIN c.cityTo cTo",
			countQuery="SELECT count(c.id) FROM Cargo c JOIN c.goods g JOIN c.cityFrom cFrom JOIN c.cityTo cTo")
	Page<CargoView> findAllView(Pageable pageable);
	
	@Query("SELECT c FROM Cargo c JOIN FETCH c.cityTo cTo JOIN FETCH c.cityFrom cFrom JOIN FETCH c.goods g LEFT JOIN FETCH c.owner o WHERE c.id=?1")
	Cargo findOneRequest(Integer id);
}