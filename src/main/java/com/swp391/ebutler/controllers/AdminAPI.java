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

import com.swp391.ebutler.model.dto.ManufacturerDTO;
import com.swp391.ebutler.model.dto.ProductCategoryDTO;
import com.swp391.ebutler.model.dto.ProductDTO;
import com.swp391.ebutler.service.ManufacturerService;
import com.swp391.ebutler.service.ProductCategoryService;
import com.swp391.ebutler.service.ProductProviderService;
import com.swp391.ebutler.service.ProductService;

@RestController
@RequestMapping("/api/admin")
public class AdminAPI {

	@Autowired
	ManufacturerService manuService;
	@Autowired
	ProductService pService;
	@Autowired
	ProductCategoryService procateService;
	@Autowired
	ProductProviderService pproviderService;

	// List all manufacturers
	@GetMapping("/manufacturer/list")
	public ResponseEntity<?> getListManu() {
		List<ManufacturerDTO> result = manuService.listAll();
		return ResponseEntity.ok(result);
	}

	// List manufacturers by name
	@GetMapping("/manufacturer/listbyname")
	public ResponseEntity<?> getListManuByName(@Param("name") String name) {
		List<ManufacturerDTO> result = manuService.searchByName(name);
		return ResponseEntity.ok(result);
	}

	// Add new manufacturer
	@PostMapping("/manufacturer/save")
	public ResponseEntity<?> saveManu(@Valid @RequestBody ManufacturerDTO manu) {
		return ResponseEntity.ok(manuService.save(manu));
	}

	// Update manufacturer status to false
	@DeleteMapping("/manufacturer/delete/{id}")
	public ResponseEntity<?> deleteManu(@PathVariable("id") int id) {
		return ResponseEntity.ok(manuService.delete(id));
	}

	// Update manufacturer
	@PutMapping("/manufacturer/update/{id}")
	public ResponseEntity<?> updateManu(@PathVariable("id") int id,@Valid @RequestBody ManufacturerDTO manu) {
		manu.setManufacturerId(id);
		return ResponseEntity.ok(manuService.save(manu));
	}
	
	//List all product category
	@GetMapping("/pcategory/list")
	public ResponseEntity<?> getList(){
		List<ProductCategoryDTO> result = procateService.listAll();
		return ResponseEntity.ok(result);
	}
	
	//List procate by name
	@GetMapping("/pcategory/listbyname")
	public ResponseEntity<?> getListByName(@Param("name") String name){
		List<ProductCategoryDTO> result = procateService.searchByName(name);
		return ResponseEntity.ok(result);
	}
	
	//Add new procate
	@PostMapping("/pcategory/save")
	public ResponseEntity<?> save(@Valid @RequestBody ProductCategoryDTO proCategory){
		return ResponseEntity.ok(procateService.save(proCategory));
	}
	
	//Update status procate to false
	@DeleteMapping("/pcategory/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(procateService.delete(id));
	}
	
	//Update procate
	@PutMapping("/pcategory/update/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") int id,@Valid @RequestBody ProductCategoryDTO proCategory) {
		proCategory.setProductcategoryId(id);
		return ResponseEntity.ok(procateService.save(proCategory));
	}	
	
	// List all products
	@GetMapping("/product/list")
	public ResponseEntity<?> getListProduct() {
		List<ProductDTO> result = pService.listAll();
		return ResponseEntity.ok(result);
	}

	//Get product by ID
	@GetMapping("/product/getbyid/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") int id) {
		return ResponseEntity.ok(pService.getByIdDTO(id));
	}

	// List products by name
	@GetMapping("/product/listbyname")
	public ResponseEntity<?> getListProductByName(@Param("name") String name) {
		List<ProductDTO> result = pService.searchByName(name);
		return ResponseEntity.ok(result);
	}

	//Add new product
	@PostMapping("/product/save")
	public ResponseEntity<?> saveProduct(@Valid @RequestBody ProductDTO product){
		return ResponseEntity.ok(pService.save(product));
	}

	//Set status product to false
	@DeleteMapping("/product/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") int id){
		return ResponseEntity.ok(pService.delete(id));
	}
	
	//Update product
	@PutMapping("/product/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable("id") int id,@Valid @RequestBody ProductDTO product) {
		product.setProductId(id);
		return ResponseEntity.ok(pService.save(product));
	}
	
	//
	//Count provider by product_provider
	@GetMapping("/product/countprovider/{id}")
	public ResponseEntity<?> countProductProvider(@PathVariable("id") int id) {
		return ResponseEntity.ok(pproviderService.countByProductId(id));
	}
	
}
