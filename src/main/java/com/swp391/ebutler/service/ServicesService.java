package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Services;
import com.swp391.ebutler.model.dto.ServicesDTO;

public interface ServicesService {
	
	public List<ServicesDTO> listAll();
	
	public ServicesDTO save(ServicesDTO s);

	public ServicesDTO delete(int id);

	public Services getById(int id);
	
	public ServicesDTO getByIdDTO(int id);
}
