package com.swp391.ebutler.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.swp391.ebutler.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	// find customer by name and sort ASC with name
	List<Customer> findByFullNameContaining(String fullName, Sort sort);
	
}
