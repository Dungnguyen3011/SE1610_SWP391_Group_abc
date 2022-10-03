package com.swp391.ebutler.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.model.dto.ServicesDTO;
import com.swp391.ebutler.service.ServicesService;

@RestController
@RequestMapping("/service")
public class ServiceAPI {

	@Autowired
	ServicesService ss;
	
	// Show all services
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		List<ServicesDTO> result = ss.listAll();
		return ResponseEntity.ok(result);
	}
	
	// Add a services
	@PostMapping("/add")
	public ResponseEntity<?> save(@Valid @RequestBody ServicesDTO s) {
		return ResponseEntity.ok(ss.save(s));
	}
	
	// Delete a service
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		return ResponseEntity.ok(ss.delete(id));
	}
	
	// Update a service
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody ServicesDTO s) {
		s.setServiceId(id);
		return ResponseEntity.ok(ss.save(s));
	}
	
	// Search services by name and sort ASC by name
	@GetMapping("/listbyname")
	public ResponseEntity<?> searchByName(@Param("name") String name) {
		List<ServicesDTO> result = ss.searchByName(name);
		return ResponseEntity.ok(result);
	}
	
	// Search a service by id
	@GetMapping("/search")
	public ResponseEntity<?> searchById(@Param("id") int id) {
		ServicesDTO result = ss.searchById(id);
		return ResponseEntity.ok(result);
	}
}
