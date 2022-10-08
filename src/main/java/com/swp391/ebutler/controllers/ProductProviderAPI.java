package com.swp391.ebutler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.model.dto.ProductProviderDTO;
import com.swp391.ebutler.service.ProductProviderService;

@RestController
@RequestMapping("/pprovider")
public class ProductProviderAPI {
	@Autowired
	ProductProviderService pproviderService;

	//List all product provider
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<ProductProviderDTO> result = pproviderService.listAllFoCus();
		return ResponseEntity.ok(result);
	}

	//List product provider by productId
	@GetMapping("/listbyproduct/{id}")
	public ResponseEntity<?> getListByProduct(@PathVariable("id") int id){
		List<ProductProviderDTO> result = pproviderService.listByProductIdFoCus(id);
		return ResponseEntity.ok(result);
	}

	//List product provider by providerId
	@GetMapping("/listbyprovider/{id}")
	public ResponseEntity<?> getListByProvider(@PathVariable("id") int id){
		List<ProductProviderDTO> result = pproviderService.listByProviderIdFoCus(id);
		return ResponseEntity.ok(result);
	}

	//Sort Param: sort = ? (Integer)
	// 0 - unitPrice - ASC
	// 1 - unitPrice - DESC
	// 2 - rating - ASC
	// 3 - rating - DESC
	@GetMapping("/list/sort")
	public ResponseEntity<?> sortInt(@Param("sort") Integer sort){
		List<ProductProviderDTO> result = pproviderService.sortInt(sort);
		return ResponseEntity.ok(result);
	}

	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody ProductProviderDTO pProvider){
		return ResponseEntity.ok(pproviderService.save(pProvider));
	}

	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(pproviderService.delete(id));
	}
}
