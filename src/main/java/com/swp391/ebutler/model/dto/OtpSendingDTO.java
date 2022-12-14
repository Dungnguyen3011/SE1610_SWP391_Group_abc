package com.swp391.ebutler.model.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OtpSendingDTO {

	@NotNull(message = "Email is required")
	private String email;
	
	private String name;
	
}
