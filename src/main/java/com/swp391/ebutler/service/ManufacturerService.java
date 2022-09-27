package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Manufacturer;
import com.swp391.ebutler.model.dto.ManufacturerDTO;


public interface ManufacturerService {
	
	public List<ManufacturerDTO> listAll();
	
	public ManufacturerDTO save(ManufacturerDTO manu);
	
	public ManufacturerDTO delete(int id);
	
	public Manufacturer getById(int id);
	
	public ManufacturerDTO getByIdDTO(int id);
	
}
