package com.swp391.ebutler.controllers;

import java.util.List;

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
import com.swp391.ebutler.service.ManufacturerService;



@RestController
@RequestMapping("/manufacturer")
public class ManufacturerAPI {
	@Autowired
	ManufacturerService manuService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<ManufacturerDTO> result = manuService.listAll();
		return ResponseEntity.ok(result);
	}
	
	public ResponseEntity<?> getListByName(@Param("name") String name){
		List<ManufacturerDTO> result = manuService.searchByName(name);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody ManufacturerDTO manu){
		return ResponseEntity.ok(manuService.save(manu));
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id){
		return ResponseEntity.ok(manuService.delete(id));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ManufacturerDTO manu) {
		manu.setManufacturerId(id);
		return ResponseEntity.ok(manuService.save(manu));
	}
}
