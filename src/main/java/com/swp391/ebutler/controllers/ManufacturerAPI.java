package com.swp391.ebutler.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.entities.Manufacturer;
import com.swp391.ebutler.service.ManufacturerService;



@RestController
@RequestMapping("/manufacturer")
public class ManufacturerAPI {
	@Autowired
	ManufacturerService manuService;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(){
		List<Manufacturer> result = manuService.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody Manufacturer manu){
		return ResponseEntity.ok(manuService.save(manu));
	}
	
	@DeleteMapping("/list/{id}")
	public void delete(@PathVariable("id") int id) {
		manuService.delete(id);
	}
}
