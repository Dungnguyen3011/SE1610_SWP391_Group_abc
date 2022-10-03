package com.swp391.ebutler.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.swp391.ebutler.entities.ServiceCategory;

public interface ServiceCategoryRepository extends JpaRepository<ServiceCategory, Integer> {

	// find by name and sort ASC by name
	List<ServiceCategory> findByServicecategoryNameContaining(String servicecategoryName, Sort sort);
}
