package com.swp391.ebutler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.entities.ServiceCategory;
import com.swp391.ebutler.service.ServiceCategoryService;

@RestController
@RequestMapping("/scategory")
public class ServiceCategoryAPI {

	@Autowired
	ServiceCategoryService scs;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		List<ServiceCategory> result = scs.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody ServiceCategory sc) {
		return ResponseEntity.ok(scs.save(sc));
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		return ResponseEntity.ok(scs.delete(id));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ServiceCategory sc) {
		sc.setServicecategoryId(id);
		return ResponseEntity.ok(scs.update(sc));
	}
}
