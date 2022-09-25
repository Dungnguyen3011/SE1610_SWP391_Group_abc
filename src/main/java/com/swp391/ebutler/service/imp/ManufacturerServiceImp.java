package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.Manufacturer;
import com.swp391.ebutler.entities.ProductCategory;
import com.swp391.ebutler.repositories.ManufacturerRepository;
import com.swp391.ebutler.service.ManufacturerService;


@Service
public class ManufacturerServiceImp implements ManufacturerService{
	@Autowired
	ManufacturerRepository repo;
	
	@Override
	public List<Manufacturer> listAll(){
		return repo.findAll();
	}

	@Override
	public Manufacturer save(Manufacturer manu) {
		return repo.save(manu);	
	}

	@Override
	public Manufacturer delete(int id) {
		Manufacturer manu = getById(id);
		if(manu != null) {
			manu.setStatus(false);
			return repo.save(manu);
		}
		return null;
	}
	
	@Override
	public Manufacturer update(Manufacturer manu) {
		return repo.save(manu);
	}
	
	@Override
	public Manufacturer getById(int id) {
		return repo.findById(id).get();
	}

}
