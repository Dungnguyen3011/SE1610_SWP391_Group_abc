package com.swp391.ebutler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategoryDTO {
	
	private Integer productcategoryId;
	private String productcategoryName;
	private Boolean status;
	
}
