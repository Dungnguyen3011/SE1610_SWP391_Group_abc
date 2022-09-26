package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.Services;
import com.swp391.ebutler.repositories.ServicesRepository;
import com.swp391.ebutler.service.ServicesService;

@Service
public class ServicesServiceImp implements ServicesService {
	
	@Autowired
	ServicesRepository repo;
	
	@Override
	public List<Services> listAll() {
		return repo.findAll();
	}

	@Override
	public Services save(Services s) {
		return repo.save(s);	
	}

	@Override
	public Services update(Services s) {
		return repo.save(s);
	}
	
	@Override
	public Services delete(int id) {
		Services s = getById(id);
		if(s != null) {
			s.setStatus(false);
			return repo.save(s);
		}
		return null;
	}

	@Override
	public Services getById(int id) {
		return repo.findById(id).get();
	}
}
