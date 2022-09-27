package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class ServiceProviderServiceImp implements ServiceProviderService {

	@Autowired
	ServiceProviderRepository spRepo;
	@Autowired
	ServicesRepository sRepo;
	@Autowired
	ProviderRepository pRepo;
	
	@Override
	public List<ServiceProviderDTO> listAll() {
		List<ServiceProvider> result = spRepo.findAll();
		List<ServiceProviderDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ServiceProviderMapper.toServiceProviderDTO(v)));
		return listDTO;
	}

	@Override
	public ServiceProviderDTO save(ServiceProviderDTO spDTO) {
		ServiceProvider sp = toServiceProvider(spDTO);
		return ServiceProviderMapper.toServiceProviderDTO(spRepo.save(sp));	
	}


	@Override
	public ServiceProvider getById(int id) {
		return spRepo.findById(id).get();
	}

	@Override
	public ServiceProviderDTO getByIdDTO(int id) {
		ServiceProvider sp = spRepo.findById(id).get();
		if(sp != null) {
			return ServiceProviderMapper.toServiceProviderDTO(sp);
		}
		return null;
	}
	
	public ServiceProvider toServiceProvider(ServiceProviderDTO spDTO) {
		ServiceProvider sp = new ServiceProvider();
		sp.setServiceproviderId(spDTO.getServiceproviderId());
		sp.setRating(spDTO.getRating());
		sp.setService(getServiceById(spDTO.getServiceId()));
		sp.setProvider(getProviderById(spDTO.getProviderId()));
		return sp;
	}
	
	public Services getServiceById(int id) {
		return sRepo.findById(id).get();
	}
	
	public Provider getProviderById(int id) {
		return pRepo.findById(id).get();
	}
}
