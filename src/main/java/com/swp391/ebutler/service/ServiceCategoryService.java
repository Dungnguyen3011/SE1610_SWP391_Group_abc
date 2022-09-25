package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ServiceCategory;


public interface ServiceCategoryService {

	public List<ServiceCategory> listAll();
	
	public ServiceCategory save(ServiceCategory sc);

	public ServiceCategory delete(int id);

	public ServiceCategory update(ServiceCategory sc);

	public ServiceCategory getById(int id);
}
