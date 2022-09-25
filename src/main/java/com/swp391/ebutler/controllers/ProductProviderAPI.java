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

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.service.ProductProviderService;

@RestController
@RequestMapping("/pprovider")
public class ProductProviderAPI {
	@Autowired
	ProductProviderService pproviderService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<ProductProvider> result = pproviderService.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody ProductProvider pProvider){
		return ResponseEntity.ok(pproviderService.save(pProvider));
	}
	
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(pproviderService.delete(id));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProductProvider pProvider) {
		pProvider.setProductproviderId(id);
		return ResponseEntity.ok(pproviderService.update(pProvider));
	}
}
