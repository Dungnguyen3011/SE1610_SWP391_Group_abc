package com.swp391.ebutler.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExProductDTO extends ProductDTO {
	private Integer numOfProvider;
	private Double minPrice;

	public ExProductDTO(Integer productId, String productName, String description, String image, Boolean status,
			Integer productcategoryId, Integer manufacturerId, Integer numOfProvider, Double minPrice) {
		super(productId, productName, description, image, status, productcategoryId, manufacturerId);
		this.numOfProvider = numOfProvider;
		this.minPrice = minPrice;
	}

}
