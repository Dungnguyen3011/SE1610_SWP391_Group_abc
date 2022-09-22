package com.swp391.ebutler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="tbl_account")
@Entity
@Data
public class Account {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="account_id", nullable = false, updatable = false)
	private Integer accountId;
	
	@Column(name="login_mail")
	private String loginMail;
	
	@Column(name="password")
	private String password;
	
	@Column(name="status")
	private Boolean status;
}
