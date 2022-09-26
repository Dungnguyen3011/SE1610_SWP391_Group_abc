package com.swp391.ebutler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductProviderDTO {
	private Integer productproviderId;
	private Float unitPrice;
	private Integer quantity;
	private Integer rating;
	private Boolean status;
	private Integer product_id;
	private Integer provider_id;
	
}
