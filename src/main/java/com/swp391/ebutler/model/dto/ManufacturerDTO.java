package com.swp391.ebutler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ManufacturerDTO {
	private Integer manufacturerId;
	private String manufacturerName;
	private Boolean status;
}
