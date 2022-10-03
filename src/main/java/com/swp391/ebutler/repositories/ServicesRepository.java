package com.swp391.ebutler.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.swp391.ebutler.entities.Services;

public interface ServicesRepository extends JpaRepository<Services, Integer> {

	// find services by name and sort ASC with name
	List<Services> findByServiceNameContaining(String serviceName, Sort sort);
}
