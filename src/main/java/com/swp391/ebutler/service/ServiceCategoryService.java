package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.model.dto.ServiceCategoryDTO;


public interface ServiceCategoryService {

	public List<ServiceCategoryDTO> listAll();
	
	public ServiceCategoryDTO save(ServiceCategoryDTO sc);

	public ServiceCategoryDTO delete(int id);
	
	public ServiceCategoryDTO searchById(int id);
	
	public List<ServiceCategoryDTO> searchByName(String name);
}
