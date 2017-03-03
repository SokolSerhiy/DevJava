package ua.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ua.entity.Amount;

public interface AmountRepository extends JpaRepository<Amount, Long>{
	
	@Query("SELECT a FROM Amount a LEFT JOIN FETCH a.system LEFT JOIN FETCH a.ingredient")
	List<Amount> findAll();
	@Query("SELECT a FROM Amount a LEFT JOIN FETCH a.system LEFT JOIN FETCH a.ingredient WHERE a.id=?1")
	Amount findOne(Long id);
	@Query("SELECT a FROM Amount a WHERE a.amount=?1 and a.ingredient.id=?2 and a.system.id=?3")
	Amount findUnique(BigDecimal amount, Long ingredientId, Long systemId);
	@Query(value="SELECT a FROM Amount a LEFT JOIN FETCH a.system LEFT JOIN FETCH a.ingredient",
			countQuery="SELECT count(a.id) FROM Amount a")
	Page<Amount> findAll(Pageable pageable);
}
