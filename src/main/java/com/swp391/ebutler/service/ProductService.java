package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Product;
import com.swp391.ebutler.model.dto.ProductDTO;


public interface ProductService {
	
	public List<ProductDTO> listAll();

	public ProductDTO save(ProductDTO product);

	public ProductDTO delete(int id);

	public Product getById(int id);
	
	public ProductDTO getByIdDTO(int id);

	public List<ProductDTO> searchByName(String name);
}
