package com.swp391.ebutler.entities;

import java.sql.Date;
import java.util.List;
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

@Table(name = "tbl_order")
@Entity
@Data
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id", nullable = false, updatable = false)
	private Integer orderId;
	
	@Column(name = "total_price")
	private Float totalPrice;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "payment_type")
	private Boolean paymentType;
	
	@Column(name = "shipping_status")
	private Boolean shippingStatus;
	
	@JsonManagedReference
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
	private Set<OrderDetail> orderDetailList;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Order(Integer orderId, Float totalPrice, Date orderDate, Boolean paymentType, Boolean shippingStatus,
			Customer customer) {
		super();
		this.orderId = orderId;
		this.totalPrice = totalPrice;
		this.orderDate = orderDate;
		this.paymentType = paymentType;
		this.shippingStatus = shippingStatus;
		this.customer = customer;
	}
	
	
}
