package com.swp391.ebutler.model.mapper;

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.model.dto.ProductProviderDTO;

public class ProductProviderMapper {
	public static ProductProviderDTO toProductProviderDTO(ProductProvider pProvider) {
		ProductProviderDTO pProviderDTO = new ProductProviderDTO();
		pProviderDTO.setProductproviderId(pProvider.getProductproviderId());
		pProviderDTO.setUnitPrice(pProvider.getUnitPrice());
		pProviderDTO.setRating(pProvider.getRating());
		pProviderDTO.setQuantity(pProvider.getQuantity());
		pProviderDTO.setStatus(pProvider.getStatus());
		pProviderDTO.setProduct_id(pProvider.getProduct().getProductId());
		pProviderDTO.setProvider_id(pProvider.getProvider().getProviderId());
		return pProviderDTO;
	}
}
