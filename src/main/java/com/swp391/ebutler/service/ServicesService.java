package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Services;

public interface ServicesService {
	
	public List<Services> listAll();
	
	public Services save(Services s);

	public Services delete(int id);

	public Services update(Services s);

	public Services getById(int id);
}
