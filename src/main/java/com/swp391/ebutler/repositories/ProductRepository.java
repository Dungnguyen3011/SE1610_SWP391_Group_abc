package com.swp391.ebutler.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.swp391.ebutler.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByProductNameContaining(String productName);
}
