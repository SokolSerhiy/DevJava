package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.MealFilter;
import ua.model.view.MealIndexView;

public interface MealViewRepository {

	Page<MealIndexView> findAll(MealFilter filter, Pageable pageable);
}
