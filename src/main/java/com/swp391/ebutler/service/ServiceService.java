package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Service;

public interface ServiceService {
	
	public List<Service> listAll();
	
	public Service save(Service s);

	public Service delete(int id);

	public Service update(Service s);

	public Service getById(int id);
}
