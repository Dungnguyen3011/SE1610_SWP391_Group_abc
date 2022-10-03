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

import com.swp391.ebutler.model.dto.ServiceCategoryDTO;
import com.swp391.ebutler.service.ServiceCategoryService;

@RestController
@RequestMapping("/scategory")
public class ServiceCategoryAPI {

	@Autowired
	ServiceCategoryService scs;
	
	// Show all service categories
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		List<ServiceCategoryDTO> result = scs.listAll();
		return ResponseEntity.ok(result);
	}
	
	// Add a service category
	@PostMapping("/list")
	public ResponseEntity<?> save(@Valid @RequestBody ServiceCategoryDTO sc) {
		return ResponseEntity.ok(scs.save(sc));
	}
	
	// Delete a service category
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		return ResponseEntity.ok(scs.delete(id));
	}
	
	// Update a service category
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody ServiceCategoryDTO sc) {
		sc.setServicecategoryId(id);
		return ResponseEntity.ok(scs.save(sc));
	}
	
	// Search service categories by name and sort ASC by name
	@GetMapping("/list/searchByName")
	public ResponseEntity<?> searchbyName(@Param("name") String name) {
		List<ServiceCategoryDTO> result = scs.searchByName(name);
		return ResponseEntity.ok(result);
	}
	
	// Search a service category by id
	@GetMapping("/list/searchById")
	public ResponseEntity<?> searchbyId(@Param("id") int id) {
		ServiceCategoryDTO result = scs.searchById(id);
		return ResponseEntity.ok(result);
	}
}
