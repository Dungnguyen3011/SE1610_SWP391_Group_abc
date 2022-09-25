package com.swp391.ebutler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.entities.Customer;
import com.swp391.ebutler.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {

	@Autowired
	CustomerService cs;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		List<Customer> result = cs.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody Customer c) {
		return ResponseEntity.ok(cs.save(c));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Customer c) {
		c.setCustomerId(id);
		return ResponseEntity.ok(cs.update(c));
	}
	
}
