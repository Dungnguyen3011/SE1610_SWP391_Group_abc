package com.swp391.ebutler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO {
	private Integer providerId;
	private String email;
	private String providerName;
	private String phoneNumber;
	private String address;
	private Integer accountId;
}
