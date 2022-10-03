package com.swp391.ebutler.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.swp391.ebutler.entities.Manufacturer;
import com.swp391.ebutler.entities.Product;
import com.swp391.ebutler.entities.ProductCategory;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	List<Product> findByProductNameContaining(String productName);
	
	List<Product> findByProCategory(ProductCategory proCategory);
	
	List<Product> findByManu(Manufacturer manu);
	
	@Query("Select count(*) from Product p"
			+ " where p.manu.manufacturerId = ?1")
	Integer countByManufacturerId(Integer mid);
	
	@Query("SELECT p.productId, COUNT(p.productId) "
			+ "FROM  Product p INNER JOIN ProductProvider pp ON pp.product.productId = p.productId "
			+ "GROUP BY p.productId")
	List<Object[]> countGroupBy();
}
