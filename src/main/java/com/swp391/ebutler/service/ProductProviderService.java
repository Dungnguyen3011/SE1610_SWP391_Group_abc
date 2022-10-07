package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.model.dto.ProductProviderDTO;

public interface ProductProviderService {
	public List<ProductProviderDTO> listAll();

	public List<ProductProviderDTO> listByProductId(int id);

	public List<ProductProviderDTO> listByProviderId(int id);

	public ProductProviderDTO save(ProductProviderDTO pProvider);

	public ProductProviderDTO delete(int id);

	public ProductProviderDTO getByIdDTO(int id);

	public ProductProvider getById(int id);

	public Integer countByProductId(int id);

	public List<ProductProviderDTO> listAllFoCus();

	public List<ProductProviderDTO> sortByPrice(String sort);

	public List<ProductProviderDTO> sortByRating(String sort);

	public List<ProductProviderDTO> listByProductIdFoCus(int id);

	public List<ProductProviderDTO> listByProviderIdFoCus(int id);

	public List<ProductProviderDTO> sort(String sort);
}
