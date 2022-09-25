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

import com.swp391.ebutler.entities.Service;
import com.swp391.ebutler.service.ServiceService;

@RestController
@RequestMapping("/service")
public class ServiceAPI {

	@Autowired
	ServiceService ss;
	
	@GetMapping("/list")
	public ResponseEntity<?> getList() {
		List<Service> result = ss.listAll();
		return ResponseEntity.ok(result);
	}
	
	@PostMapping("/list")
	public ResponseEntity<?> save(@RequestBody Service s) {
		return ResponseEntity.ok(ss.save(s));
	}
	
	@DeleteMapping("/list/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) {
		return ResponseEntity.ok(ss.delete(id));
	}
	
	@PutMapping("/list/{id}")
	public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Service s) {
		s.setServiceId(id);
		return ResponseEntity.ok(ss.update(s));
	}
}
