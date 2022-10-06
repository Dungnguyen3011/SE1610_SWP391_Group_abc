package com.swp391.ebutler.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.service.OrderDetailService;

@RestController
public class OrderDetailAPI {

	@Autowired
	OrderDetailService orderdtsv;
	
	// Get Order Detail of one specific order
	@GetMapping("/api/orderdetail/listbyorder/{id}")
	public ResponseEntity<?> getDetailByOrderId(@PathVariable("id") int id){
		return ResponseEntity.ok(orderdtsv.listOrderDetailByOrderId(id));
	}
}