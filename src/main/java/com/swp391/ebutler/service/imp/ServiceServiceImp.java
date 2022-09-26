package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.Service;
import com.swp391.ebutler.repositories.ServiceRepository;
import com.swp391.ebutler.service.ServiceService;


@Service
public class ServiceServiceImp implements ServiceService {
	
	@Autowired
	ServiceRepository repo;
	
	@Override
	public List<Service> listAll() {
		return repo.findAll();
	}

	@Override
	public Service save(Service s) {
		return repo.save(s);	
	}

	@Override
	public Service update(Service s) {
		return repo.save(s);
	}
	
	@Override
	public Service delete(int id) {
		Service s = getById(id);
		if(s != null) {
			s.setStatus(false);
			return repo.save(s);
		}
		return null;
	}

	@Override
	public Service getById(int id) {
		return repo.findById(id).get();
	}
}
