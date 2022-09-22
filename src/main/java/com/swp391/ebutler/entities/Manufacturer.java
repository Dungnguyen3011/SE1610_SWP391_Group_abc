package com.swp391.ebutler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_manufacturer")
@Entity
@Data
public class Manufacturer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manufacturer_id", nullable = false, updatable = false)
	private Integer manufacturerId;
	
	@Column(name="manufacturer_name")
	private String productcategoryName;
	
	@Column(name="status")
	private boolean status;
}