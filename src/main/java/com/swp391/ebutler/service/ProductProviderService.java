package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.model.dto.ProductProviderDTO;

public interface ProductProviderService {
	public List<ProductProviderDTO> listAll();

	public ProductProvider save(ProductProvider pProvider);

	public ProductProvider delete(int id);

	public ProductProvider update(ProductProvider pProvider);

	public ProductProviderDTO getByIdDTO(int id);
	
	public ProductProvider getById(int id);
}
