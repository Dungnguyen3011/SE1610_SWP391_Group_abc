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

import com.swp391.ebutler.entities.ProductCategory;
import com.swp391.ebutler.service.ProductCategoryService;

@RestController
@RequestMapping("/pcategory")
public class ProductCategoryAPI {
	@Autowired
	ProductCategoryService procateService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<ProductCategory> result = procateService.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody ProductCategory procate){
		return ResponseEntity.ok(procateService.save(procate));
	}
	
//	@DeleteMapping("/list")
//	public ResponseEntity<?> delete(@RequestBody ProductCategory procate){
//		return ResponseEntity.ok(procateService.delete(procate));
//	}
	
	@DeleteMapping("/list/{id}")
	public void delete(@PathVariable("id") int id){
		procateService.delete(id);
	}
	
	@PutMapping("/list/{id}")
	public void update(@PathVariable("id") int id, @RequestBody ProductCategory procate) {
		procate.setProductcategoryId(id);
		procateService.update(procate);
	}
}
