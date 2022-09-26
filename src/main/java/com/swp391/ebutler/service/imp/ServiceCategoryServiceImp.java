package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.ServiceCategory;
import com.swp391.ebutler.repositories.ServiceCategoryRepository;
import com.swp391.ebutler.service.ServiceCategoryService;

@Service
public class ServiceCategoryServiceImp implements ServiceCategoryService {

	@Autowired
	ServiceCategoryRepository repo;
	
	@Override
	public List<ServiceCategory> listAll() {
		return repo.findAll();
	}
	
	@Override
	public ServiceCategory save(ServiceCategory sc) {
		return repo.save(sc);
	}
	
	@Override
	public ServiceCategory update(ServiceCategory sc) {
		return repo.save(sc);
	}
	
	@Override
	public ServiceCategory delete(int id) {
		ServiceCategory sc = getById(id);
		if (sc != null) {
			sc.setStatus(false);
			return repo.save(sc);
		}
		return null;
	}
	
	@Override
	public ServiceCategory getById(int id) {
		return repo.findById(id).get();
	}
}
