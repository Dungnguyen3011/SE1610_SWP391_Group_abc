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

import com.swp391.ebutler.model.dto.ProductCategoryDTO;
import com.swp391.ebutler.service.ProductCategoryService;

@RestController
@RequestMapping("/pcategory")
public class ProductCategoryAPI {
	@Autowired
	ProductCategoryService procateService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<ProductCategoryDTO> result = procateService.listAll();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/list/getbyname")
	public ResponseEntity<?> getListByName(@Param("name") String name){
		List<ProductCategoryDTO> result = procateService.searchByName(name);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@Valid @RequestBody ProductCategoryDTO proCategory){
		return ResponseEntity.ok(procateService.save(proCategory));
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(procateService.delete(id));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") int id, @RequestBody ProductCategoryDTO proCategory) {
		proCategory.setProductcategoryId(id);
		return ResponseEntity.ok(procateService.save(proCategory));
	}
}
