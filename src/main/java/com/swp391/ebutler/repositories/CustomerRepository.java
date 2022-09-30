package com.swp391.ebutler.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swp391.ebutler.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
