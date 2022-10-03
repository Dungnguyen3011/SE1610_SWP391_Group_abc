package com.swp391.ebutler.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swp391.ebutler.entities.ProductProvider;

public interface ProductProviderRepository extends JpaRepository<ProductProvider, Integer>{
	@Query("Select Count(*) from ProductProvider p where p.product.productId = ?1")
	Integer countByProductId(int id);
	
	List<ProductProvider> findByStatus(Boolean status);
	
	List<ProductProvider> findByStatus(Boolean status, Sort sort);

}
