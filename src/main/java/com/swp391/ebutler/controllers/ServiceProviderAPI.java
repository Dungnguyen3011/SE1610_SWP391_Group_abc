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

import com.swp391.ebutler.model.dto.ServiceProviderDTO;
import com.swp391.ebutler.service.ServiceProviderService;

@RestController
@RequestMapping("/sprovider")
public class ServiceProviderAPI {
	
	@Autowired
	ServiceProviderService sps;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		List<ServiceProviderDTO> result = sps.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody ServiceProviderDTO sp) {
		return ResponseEntity.ok(sps.save(sp));
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(sps.delete(id));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ServiceProviderDTO sp) {
		sp.setServiceproviderId(id);
		return ResponseEntity.ok(sps.save(sp));
	}
}
