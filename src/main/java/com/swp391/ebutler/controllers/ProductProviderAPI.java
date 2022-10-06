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
	
	//Sort list by price
	@GetMapping("/list/sortprice")
	public ResponseEntity<?> sortByPrice(@Param("sort") String sort){
		List<ProductProviderDTO> result = pproviderService.sortByPrice(sort);
		return ResponseEntity.ok(result);
	}
	
	//Sort list by rating
	@GetMapping("/list/sortrating")
	public ResponseEntity<?> sortByRating(@Param("sort") String sort){
		List<ProductProviderDTO> result = pproviderService.sortByRating(sort);
		return ResponseEntity.ok(result);
	}
	
	///Sort gộp vào thành 1 (tham số truyền vào)
	//sort = [attribute]-[direction]
	@GetMapping("/list/sort")
	public ResponseEntity<?> sort(@Param("sort") String sort){
		List<ProductProviderDTO> result = pproviderService.sort(sort);
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
