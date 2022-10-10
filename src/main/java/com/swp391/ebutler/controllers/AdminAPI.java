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
	public ResponseEntity<?> deleteManu(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(manuService.delete(id));
	}

	// Update manufacturer
	@PutMapping("/manufacturer/update/{id}")
	public ResponseEntity<?> updateManu(@PathVariable("id") Integer id,@Valid @RequestBody ManufacturerDTO manu) {
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
	public ResponseEntity<?> delete(@PathVariable("id") Integer id){
		return ResponseEntity.ok(procateService.delete(id));
	}
	
	//Update procate
	@PutMapping("/pcategory/update/{id}")
	public ResponseEntity<?> update(@Valid @PathVariable("id") Integer id,@Valid @RequestBody ProductCategoryDTO proCategory) {
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
	public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
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
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id){
		return ResponseEntity.ok(pService.delete(id));
	}
	
	//Update product
	@PutMapping("/product/update/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id,@Valid @RequestBody ProductDTO product) {
		product.setProductId(id);
		return ResponseEntity.ok(pService.save(product));
	}
	
	//
	//Count provider by product_provider
	@GetMapping("/product/countprovider/{id}")
	public ResponseEntity<?> countProductProvider(@PathVariable("id") Integer id) {
		return ResponseEntity.ok(pproviderService.countByProductId(id));
	}
	
	// Show all customers
	@GetMapping("/customer/list")
	public ResponseEntity<?> getListCustomer() {
		List<CustomerDTO> result = cs.listAll();
		return ResponseEntity.ok(result);
	}
	
	// Show all ACTIVE customer [status true]
	@GetMapping("/customer/list/active")
	public ResponseEntity<?> listAllActiveCustomer() {
		List<CustomerDTO> result = cs.listAllActiveCustomerAccount();
		return ResponseEntity.ok(result);
	}

	// Add a customer
	@PostMapping("/customer/add")
	public ResponseEntity<?> save(@Valid @RequestBody CustomerDTO c) {
		return ResponseEntity.ok(cs.save(c));
	}

	// Update a customer profile
	@PutMapping("/customer/update/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @Valid @RequestBody CustomerDTO c) {
		c.setCustomerId(id);
		return ResponseEntity.ok(cs.save(c));
	}
	
	// Search by customer address
	@GetMapping("/customer/search/address")
	public ResponseEntity<?> listCustomerByAddress(@Param("address") String address) {
		List<CustomerDTO> result = cs.searchByAddress(address);
		return ResponseEntity.ok(result);
	}
	
	// Search active customer account by name
	@GetMapping("/customer/search/active")
	public ResponseEntity<?> listActiveCustomerAccountByName(@Param("name") String name) {
		List<CustomerDTO> result = cs.searchActiveCustomerAccountByName(name);
		return ResponseEntity.ok(result);
	}
	
	// get customer by id
	@GetMapping("/customer/{id}")
	public ResponseEntity<?> searchCustomerById(@PathVariable("id") int id) {
		CustomerDTO result = cs.getById(id);
		return ResponseEntity.ok(result);
	}
	
	// Search by parameters (name/email/phoneNumber) 
	@GetMapping("/customer/search")
	public ResponseEntity<?> searchCustomer(@Param("search") String search) {
		List<CustomerDTO> result = cs.searchByParam(search);
		return ResponseEntity.ok(result);
	}
	
/*-----------------------------------------------------------------------------------------------------------------------------*/
	/* SERVICE */
	
	// Show all services
	@GetMapping("/service/list")
	public ResponseEntity<?> getListService() {
		List<ServicesDTO> result = ss.listAll();
		return ResponseEntity.ok(result);
	}
	
	// Show all ACTIVE services [status true]
	@GetMapping("/service/list/active")
	public ResponseEntity<?> getListActiveService() {
		List<ServicesDTO> result = ss.listAllByStatus();
		return ResponseEntity.ok(result);
	}
	
	// Show all services by category
	@GetMapping("/service/list/{categoryName}")
	public ResponseEntity<?> getListServiceByCategory(@Param("id") int id) {
		List<ServicesDTO> result = ss.listAllByCategoryId(id);
		return ResponseEntity.ok(result);
	}	
	
	// Show all ACTIVE services by category [status true]
	@GetMapping("/service/list/{categoryName}")
	public ResponseEntity<?> getListActiveServiceByCategory(@Param("id") int id) {
		List<ServicesDTO> result = ss.listAllByCategoryIdAndStatus(id);
		return ResponseEntity.ok(result);
	}
	
	// Add a services
	@PostMapping("/service/add")
	public ResponseEntity<?> saveService(@Valid @RequestBody ServicesDTO s) {
		return ResponseEntity.ok(ss.save(s));
	}

	// Delete a service
	@DeleteMapping("/service/delete/{id}")
	public ResponseEntity<?> deleteService(@PathVariable("id") int id) {
		return ResponseEntity.ok(ss.delete(id));
	}

	// Update a service
	@PutMapping("/service/update/{id}")
	public ResponseEntity<?> updateService(@PathVariable("id") int id, @Valid @RequestBody ServicesDTO s) {
		s.setServiceId(id);
		return ResponseEntity.ok(ss.save(s));
	}

	// Search services by name 
	@GetMapping("/service/listbyname")
	public ResponseEntity<?> searchServiceByName(@Param("name") String name) {
		List<ServicesDTO> result = ss.searchByServiceName(name);
		return ResponseEntity.ok(result);
	}

	// get service by id
	@GetMapping("/service/search")
	public ResponseEntity<?> searchServiceById(@Param("id") int id) {
		ServicesDTO result = ss.getById(id);
		return ResponseEntity.ok(result);
	}
	
/*-----------------------------------------------------------------------------------------------------------------------------*/
	/* SERVICE CATEGORY */
	
	// Show all service categories
	@GetMapping("/scategory/list")
	public ResponseEntity<?> getListServiceCategory() {
		List<ServiceCategoryDTO> result = scs.listAll();
		return ResponseEntity.ok(result);
	}

	// Add a service category
	@PostMapping("/scategory/add")
	public ResponseEntity<?> saveServiceCategory(@Valid @RequestBody ServiceCategoryDTO sc) {
		return ResponseEntity.ok(scs.save(sc));
	}

	// Delete a service category
	@DeleteMapping("/scategory/delete/{id}")
	public ResponseEntity<?> deleteServiceCategory(@PathVariable("id") int id) {
		return ResponseEntity.ok(scs.delete(id));
	}

	// Update a service category
	@PutMapping("/scategory/update/{id}")
	public ResponseEntity<?> updateServiceCategory(@PathVariable("id") int id, @Valid @RequestBody ServiceCategoryDTO sc) {
		sc.setServicecategoryId(id);
		return ResponseEntity.ok(scs.save(sc));
	}

	// Search service categories by name
	@GetMapping("/scategory/listbyname")
	public ResponseEntity<?> searchServiceCategorybyName(@Param("name") String name) {
		List<ServiceCategoryDTO> result = scs.searchByName(name);
		return ResponseEntity.ok(result);
	}

	// Search a service category by id
	@GetMapping("/scategory/search")
	public ResponseEntity<?> searchServiceCategorybyId(@Param("id") int id) {
		ServiceCategoryDTO result = scs.getById(id);
		return ResponseEntity.ok(result);
	}
	
/*-----------------------------------------------------------------------------------------------------------------------------*/
	/* SERVICE PROVIDER */
	
	// Show all service providers
	@GetMapping("/sprovider/list")
	public ResponseEntity<?> getListServiceProvider() {
		List<ServiceProviderDTO> result = sps.listAll();
		return ResponseEntity.ok(result);
	}

	// Add a service provider
	@PostMapping("/sprovider/add")
	public ResponseEntity<?> saveServiceProvider(@Valid @RequestBody ServiceProviderDTO sp) {
		return ResponseEntity.ok(sps.save(sp));
	}

	// Delete a service provider
	@DeleteMapping("/sprovider/delete/{id}")
	public ResponseEntity<?> deleteServiceProvider(@PathVariable("id") int id) {
		return ResponseEntity.ok(sps.delete(id));
	}

	// Update a service provider
	@PutMapping("/sprovider/update/{id}")
	public ResponseEntity<?> updateServiceProvider(@PathVariable("id") int id, @Valid @RequestBody ServiceProviderDTO sp) {
		sp.setServiceproviderId(id);
		return ResponseEntity.ok(sps.save(sp));
	}

	// Search a service provider by id
	@GetMapping("/sprovider/search")
	public ResponseEntity<?> searchServiceProviderById(@Param("id") int id) {
		ServiceProviderDTO result = sps.getById(id);
		return ResponseEntity.ok(result);
	}
}
