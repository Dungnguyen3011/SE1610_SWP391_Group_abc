package com.swp391.ebutler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_service_provider")
@Entity
@Data
public class ServiceProvider {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_provider_id", nullable = false, updatable = false)
	private Integer serviceproviderId;
	
	@Column(name = "rating")
	private Integer rating;
	
	@Column(name = "provider_id")
	private Integer providerId;
	
	@Column(name = "service_id")
	private Integer serviceId;
	
}
