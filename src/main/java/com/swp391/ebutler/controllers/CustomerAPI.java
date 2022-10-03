
package com.swp391.ebutler.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.model.dto.CustomerDTO;
import com.swp391.ebutler.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerAPI {

	@Autowired
	CustomerService cs;
	
	// Show all customers
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		List<CustomerDTO> result = cs.listAll();
		return ResponseEntity.ok(result);
	}
	
	// Add a customer
	@PostMapping("/add")
	public ResponseEntity<?> save(@Valid @RequestBody CustomerDTO c) {
		return ResponseEntity.ok(cs.save(c));
	}
	
	// Update a customer profile 
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody CustomerDTO c) {
		c.setCustomerId(id);
		return ResponseEntity.ok(cs.save(c));
	}
	
	// Search by customer name and sort ASC by name
	@GetMapping("/listbyname")
	public ResponseEntity<?> searchByName(@Param("name") String name) {
		List<CustomerDTO> result = cs.searchByName(name);
		return ResponseEntity.ok(result);
	}
	
	// Search By customer id
	@GetMapping("/search")
	public ResponseEntity<?> searchById(@Param("id") int id) {
		CustomerDTO result = cs.searchById(id);
		return ResponseEntity.ok(result);
	}
}
