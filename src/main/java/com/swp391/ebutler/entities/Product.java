package com.swp391.ebutler.entities;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	private boolean status;
	
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory proCategory;
	
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manu;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	@JsonIgnore
	private List<ProductProvider> pProvider;
	
	
//	@Column(name="product_category_id")
//	private Integer productcategoryId;
//	
//	@Column(name="manufacturer_id")
//	private Integer manufacturerId;
}
