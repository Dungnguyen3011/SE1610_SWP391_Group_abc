package com.swp391.ebutler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
	private Integer productId;
	private String productName;
	private String description;
	private String image;
	private Boolean status;
	private Integer productcategoryId;
	private Integer manufacturerId;
}
