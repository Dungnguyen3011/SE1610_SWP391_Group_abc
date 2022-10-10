package com.swp391.ebutler.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@Min(value = 0, message = "Price must greater than 0")
	private Float unitPrice;
	
	@Min(value = 0, message = "Quantity must greater than 0")
	private Integer quantity;
	
	@Size(min=0 , max=5 , message = "Ranting must between 0 and 5")
	private Integer rating;
	
	private Boolean status;
	
	@NotNull(message = "Please select product")
	private Integer product_id;
	
	@NotNull(message = "Please select provider")
	private Integer provider_id;
	
	private String productName;
	
}
