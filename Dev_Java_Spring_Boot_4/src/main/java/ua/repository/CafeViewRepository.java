package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.CafeFilter;
import ua.model.view.CafeIndexView;

public interface CafeViewRepository {

	Page<CafeIndexView> findAll(CafeFilter filter, Pageable pageable);
}
