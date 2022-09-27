package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ServiceCategory;
import com.swp391.ebutler.model.dto.ServiceCategoryDTO;


public interface ServiceCategoryService {

	public List<ServiceCategoryDTO> listAll();
	
	public ServiceCategoryDTO save(ServiceCategoryDTO sc);

	public ServiceCategoryDTO delete(int id);

	public ServiceCategory getById(int id);
	
	public ServiceCategoryDTO getByIdDTO(int id);
}
