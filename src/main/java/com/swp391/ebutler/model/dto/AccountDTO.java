package com.swp391.ebutler.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
	private Integer accountId;
	private String loginMail;
	private String password;
	private Boolean status;
	private Integer providerId;
	private Integer customerId;
}
