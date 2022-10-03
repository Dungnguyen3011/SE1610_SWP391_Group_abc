package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.model.dto.ProductProviderDTO;

public interface ProductProviderService {
	public List<ProductProviderDTO> listAll();
	
	public ProductProviderDTO save(ProductProviderDTO pProvider);

	public ProductProviderDTO delete(int id);
	
	public ProductProviderDTO getByIdDTO(int id);
	
	public ProductProvider getById(int id);
	
	public Integer countByProductId(int id);
}
