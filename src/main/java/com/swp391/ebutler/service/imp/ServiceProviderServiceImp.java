package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.swp391.ebutler.entities.ServiceProvider;
import com.swp391.ebutler.repositories.ServiceProviderRepository;
import com.swp391.ebutler.service.ServiceProviderService;

public class ServiceProviderServiceImp implements ServiceProviderService {

	@Autowired
	ServiceProviderRepository repo;
	
	@Override
	public List<ServiceProvider> listAll() {
		return repo.findAll();
	}

	@Override
	public ServiceProvider save(ServiceProvider sp) {
		return repo.save(sp);	
	}

	@Override
	public ServiceProvider update(ServiceProvider sp) {
		return repo.save(sp);
	}

	@Override
	public ServiceProvider getById(int id) {
		return repo.findById(id).get();
	}
}
