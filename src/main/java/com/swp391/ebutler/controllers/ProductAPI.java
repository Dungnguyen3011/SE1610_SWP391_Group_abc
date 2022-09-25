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

import com.swp391.ebutler.entities.Product;
import com.swp391.ebutler.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductAPI {
	@Autowired
	ProductService pService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<Product> result = pService.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody Product p){
		return ResponseEntity.ok(pService.save(p));
	}
	
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(pService.delete(id));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Product p) {
		p.setProductcategoryId(id);
		return ResponseEntity.ok(pService.update(p));
	}
}
