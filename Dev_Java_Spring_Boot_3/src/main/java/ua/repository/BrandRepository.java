package ua.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import ua.entity.Brand;

public interface BrandRepository extends JpaNameRepository<Brand, Integer>, JpaSpecificationExecutor<Brand>{

}
