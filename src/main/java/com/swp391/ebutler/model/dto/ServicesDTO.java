package com.swp391.ebutler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ServicesDTO {

	private Integer serviceId;
	private String serviceName;
	private String description;
	private String image;
	private Boolean status;
	private Integer servicecategoryId;
}