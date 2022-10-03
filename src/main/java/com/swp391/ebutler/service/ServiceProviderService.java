package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.model.dto.ServiceProviderDTO;

public interface ServiceProviderService {
	
	public List<ServiceProviderDTO> listAll();
	
	public ServiceProviderDTO save(ServiceProviderDTO sp);
	
	public ServiceProviderDTO delete(int id);
	
	public ServiceProviderDTO searchById(int id);
}
