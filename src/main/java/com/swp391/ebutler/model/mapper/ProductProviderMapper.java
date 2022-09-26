package com.swp391.ebutler.model.mapper;

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.model.dto.ProductProviderDTO;

public class ProductProviderMapper {
	public static ProductProviderDTO toProductCategoryDTO(ProductProvider proCategory) {
		ProductProviderDTO pProviderDTO = new ProductProviderDTO();
		pProviderDTO.setProductproviderId(proCategory.getProductproviderId());
		pProviderDTO.setUnitPrice(proCategory.getUnitPrice());
		pProviderDTO.setRating(proCategory.getRating());
		pProviderDTO.setQuantity(proCategory.getQuantity());
		pProviderDTO.setStatus(proCategory.getStatus());
		pProviderDTO.setProduct_id(proCategory.getProduct().getProductId());
		pProviderDTO.setProvider_id(proCategory.getProvider().getProviderId());
		return pProviderDTO;
	}
}
