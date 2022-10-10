package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.model.dto.ServiceProviderDTO;

public interface ServiceProviderService {
	
	public List<ServiceProviderDTO> listAll();
	
	public List<ServiceProviderDTO> listAllByStatus();
	
	public List<ServiceProviderDTO> listAllByServiceId(int id);
	
	public List<ServiceProviderDTO> listAllByServiceIdAndStatus(int id);
	
	public List<ServiceProviderDTO> listAllByProviderId(int id);
	
	public List<ServiceProviderDTO> listAllByProviderIdAndStatus(int id);
	
	public ServiceProviderDTO save(ServiceProviderDTO sp);
	
	public ServiceProviderDTO delete(int id);
	
	public ServiceProviderDTO getById(int id);
	
	public List<ServiceProviderDTO> searchByServicecategoryId(int id);
	
	public Integer countByServiceId(int id);
	
	public Integer countByProviderId(int id);
	
	public List<ServiceProviderDTO> sort(String sort);
	
	public List<ServiceProviderDTO> sortByPrice(String sort);
	
	public List<ServiceProviderDTO> sortByRating(String sort);
}
