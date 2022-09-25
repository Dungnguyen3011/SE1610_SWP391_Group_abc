package com.swp391.ebutler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_service_category")
@Entity
@Data
public class ServiceCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_category_id", nullable = false, updatable = false)
	private Integer servicecategoryId;
	
	@Column(name = "service_category_name")
	private String  servicecategoryName;
	
	@Column(name = "status")
	private boolean status;
	
}
