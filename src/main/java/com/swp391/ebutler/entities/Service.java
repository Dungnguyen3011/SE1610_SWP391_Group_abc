package com.swp391.ebutler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_service")
@Entity
@Data
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id", nullable = false, updatable = false)
	private Integer serviceId;
	
	@Column(name = "service_name")
	private String serviceName;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "service_cate_id")
	private Integer servicecateId;
	
}
