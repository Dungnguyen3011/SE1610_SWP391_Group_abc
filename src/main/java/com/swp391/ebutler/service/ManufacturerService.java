package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Manufacturer;


public interface ManufacturerService {
	public List<Manufacturer> listAll();
	
	public Manufacturer save(Manufacturer manu);
	
	public void delete(int id);
}
