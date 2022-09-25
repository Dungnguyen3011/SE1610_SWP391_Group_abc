package com.swp391.ebutler.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Table(name = "tbl_product_category")
@Entity
@Data
public class ProductProvider {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_provider_id", nullable = false, updatable = false)
	private Integer productproviderId;
	
	@Column(name="unit_price")
	private float unitPrice;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="status")
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
//	@ManyToOne
//	@JoinColumn(name = "provider_id")
//	private Provider provider;
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy = "")
//	private List<OderDetail> oDetails;
	
	
	@Column(name="provider_id")
	private Integer productcategoryId;
//	
//	@Column(name="product_id")
//	private Integer manufacturerId;
}
