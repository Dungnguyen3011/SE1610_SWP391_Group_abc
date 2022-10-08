package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.model.dto.ServicesDTO;

public interface ServicesService {
	
	public List<ServicesDTO> listAll();
	
	//public List<ServicesDTO> listAllByName();
	
	//public List<ServicesDTO> listAllByStatus();
	
	public ServicesDTO save(ServicesDTO s);
	
	public ServicesDTO delete(int id);
	
	public ServicesDTO searchById(int id);
	
	public List<ServicesDTO> searchByName(String name);
	
	//public List<ServicesDTO> searchByCategory(String Category);
}
