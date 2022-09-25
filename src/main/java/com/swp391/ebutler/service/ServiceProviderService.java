package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.ServiceProvider;

public interface ServiceProviderService {
	
	public List<ServiceProvider> listAll();
	
	public ServiceProvider save(ServiceProvider sp);

	public ServiceProvider update(ServiceProvider sp);

	public ServiceProvider getById(int id);
}
