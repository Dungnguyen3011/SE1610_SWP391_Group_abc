package com.swp391.ebutler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_product_category")
@Entity
@Data
public class ProductCategory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_category_id", nullable = false, updatable = false)
	private Integer productcategoryId;
	
	@Column(name="product_category_name")
	private String productcategoryName;
	
	@Column(name="status")
	private String status;
	
	
}
