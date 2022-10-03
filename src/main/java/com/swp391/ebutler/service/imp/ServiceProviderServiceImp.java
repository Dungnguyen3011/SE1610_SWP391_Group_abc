package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swp391.ebutler.entities.Provider;
import com.swp391.ebutler.entities.ServiceProvider;
import com.swp391.ebutler.entities.Services;
import com.swp391.ebutler.model.dto.ServiceProviderDTO;
import com.swp391.ebutler.model.mapper.ServiceProviderMapper;
import com.swp391.ebutler.repositories.ProviderRepository;
import com.swp391.ebutler.repositories.ServiceProviderRepository;
import com.swp391.ebutler.repositories.ServicesRepository;
import com.swp391.ebutler.service.ServiceProviderService;

@Service
@Transactional
public class ServiceProviderServiceImp implements ServiceProviderService {

	@Autowired
	ServiceProviderRepository spRepo;
	@Autowired
	ServicesRepository sRepo;
	@Autowired
	ProviderRepository pRepo;
	
	// Show all
	@Override
	public List<ServiceProviderDTO> listAll() {
		List<ServiceProvider> result = spRepo.findAll();
		List<ServiceProviderDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ServiceProviderMapper.toServiceProviderDTO(v)));
		return listDTO;
	}

	// Save
	@Override
	public ServiceProviderDTO save(ServiceProviderDTO spDTO) {
		ServiceProvider sp = toServiceProvider(spDTO);
		return ServiceProviderMapper.toServiceProviderDTO(spRepo.save(sp));	
	}

	// Delete
	@Override
	public ServiceProviderDTO delete(int id) {
		ServiceProvider sp = getId(id);
		if(sp != null) {
			sp.setStatus(false);
			return ServiceProviderMapper.toServiceProviderDTO(spRepo.save(sp));
		}
		return null;
	}

	// Search By id
	public ServiceProvider getId(int id) {
		return spRepo.findById(id).get();
	}

	@Override
	public ServiceProviderDTO searchById(int id) {
		ServiceProvider sp = getId(id);
		if(sp != null) {
			return ServiceProviderMapper.toServiceProviderDTO(sp);
		}
		return null;
	}
	
	// Type casting
	public ServiceProvider toServiceProvider(ServiceProviderDTO spDTO) {
		ServiceProvider sp = new ServiceProvider();
		sp.setServiceproviderId(spDTO.getServiceproviderId());
		sp.setRating(spDTO.getRating());
		sp.setService(getServiceById(spDTO.getServiceId()));
		sp.setProvider(getProviderById(spDTO.getProviderId()));
		sp.setMinPrice(spDTO.getMinPrice());
		sp.setMaxPrice(spDTO.getMaxPrice());
		sp.setStatus(spDTO.getStatus());
		return sp;
	}
	
	// get service by id
	public Services getServiceById(int id) {
		return sRepo.findById(id).get();
	}
	
	// get service provider by id
	public Provider getProviderById(int id) {
		return pRepo.findById(id).get();
	}
}
