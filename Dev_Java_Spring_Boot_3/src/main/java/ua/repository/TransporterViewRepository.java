package ua.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import ua.model.filter.TransporterFilter;
import ua.model.view.TransporterIndexView;

public interface TransporterViewRepository {

	Page<TransporterIndexView> findAll(TransporterFilter filter, Pageable pageable);
}
