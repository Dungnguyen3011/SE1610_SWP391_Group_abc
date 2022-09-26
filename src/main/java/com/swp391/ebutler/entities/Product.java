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

@Table(name = "tbl_product")
@Entity
@Data
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id", nullable = false, updatable = false)
	private Integer productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="description")
	private String description;
	
	@Column(name="image")
	private String image;
	
	@Column(name="status")
	private Boolean status;
	
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	@JsonBackReference
	private ProductCategory proCategory;
	
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	@JsonBackReference
	private Manufacturer manu;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<ProductProvider> pProvider;
	
}
