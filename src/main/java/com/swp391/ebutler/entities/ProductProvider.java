package com.swp391.ebutler.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Table(name = "tbl_product_provider")
@Entity
@Data
public class ProductProvider {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_provider_id", nullable = false, updatable = false)
	private Integer productproviderId;
	
	@Column(name="unit_price")
	private Float unitPrice;
	
	@Column(name="quantity")
	private Integer quantity;
	
	@Column(name="rating")
	private Integer rating;
	
	@Column(name="status")
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "provider_id")
	@JsonBackReference
	private Provider provider;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonBackReference
	private Product product;
	
	@OneToMany(mappedBy = "pProvider", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<OrderDetail> orderDetails;

	public ProductProvider(Integer productproviderId, Float unitPrice, Integer quantity, Integer rating, Boolean status,
			Product product, Provider provider) {
		super();
		this.productproviderId = productproviderId;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.rating = rating;
		this.status = status;
		this.product = product;
		this.provider = provider;
	}

}
