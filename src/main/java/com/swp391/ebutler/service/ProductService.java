package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Product;


public interface ProductService {
	
	public List<Product> listAll();

	public Product save(Product p);

	public Product delete(int id);

	public Product update(Product p);

	public Product getById(int id);

}
