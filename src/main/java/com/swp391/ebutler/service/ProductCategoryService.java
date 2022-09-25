package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ProductCategory;


public interface ProductCategoryService {
	public List<ProductCategory> listAll();
	
	public ProductCategory save(ProductCategory procate);
	
	public void delete(int id);
	
	public void update(ProductCategory procate);
}
