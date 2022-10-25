package com.swp391.ebutler.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="tbl_product_rating")
@Entity
@Data
public class ProductRating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_rating_id", nullable = false, updatable = false)
	private Integer productRatingId;
	
	@Column(name="product_provider_id")
	private String productProviderId;
	
	@Column(name="customer_id")
	private String CustomerId;
	
	@Column(name="rating")
	private String Rating;
}
