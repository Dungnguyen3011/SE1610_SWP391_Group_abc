package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ProductCategory;
import com.swp391.ebutler.model.dto.ProductCategoryDTO;


public interface ProductCategoryService {
	public List<ProductCategoryDTO> listAll();
	
	public ProductCategoryDTO save(ProductCategoryDTO procate);
	
	public ProductCategoryDTO delete(int id);
	
	public ProductCategory getById(int id);
	
	public ProductCategoryDTO getByIdDTO(int id);
	
}
