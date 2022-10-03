package com.swp391.ebutler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.model.dto.ProductProviderDTO;
import com.swp391.ebutler.service.ProductProviderService;

@RestController
@RequestMapping("/pprovider")
public class ProductProviderAPI {
	@Autowired
	ProductProviderService pproviderService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<ProductProviderDTO> result = pproviderService.listAllFoCus();
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/list/sort")
	public ResponseEntity<?> sortByPriceAsc(){
		List<ProductProviderDTO> result = pproviderService.sortByPriceAsc();
		return ResponseEntity.ok(result);
	}
	
}
