package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.ServiceCategory;
import com.swp391.ebutler.model.dto.ServiceCategoryDTO;
import com.swp391.ebutler.model.mapper.ServiceCategoryMapper;
import com.swp391.ebutler.repositories.ServiceCategoryRepository;
import com.swp391.ebutler.service.ServiceCategoryService;

@Service
public class ServiceCategoryServiceImp implements ServiceCategoryService {

	@Autowired
	ServiceCategoryRepository repo;

	// Show all 
	@Override
	public List<ServiceCategoryDTO> listAll() {
		List<ServiceCategory> result = repo.findAll();
		List<ServiceCategoryDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ServiceCategoryMapper.toServiceCategoryDTO(v)));
		return listDTO;
	}

	// Save 
	@Override
	public ServiceCategoryDTO save(ServiceCategoryDTO scDTO) {
		ServiceCategory sc = toServiceCategory(scDTO);
		return ServiceCategoryMapper.toServiceCategoryDTO(repo.save(sc));
	}

	// Delete 
	@Override
	public ServiceCategoryDTO delete(int id) {
		ServiceCategory sc = getId(id);
		if (sc != null) {
			sc.setStatus(false);
			return ServiceCategoryMapper.toServiceCategoryDTO(repo.save(sc));
		}
		return null;
	}

	// Search by id
	public ServiceCategory getId(int id) {
		return repo.findById(id).get();
	}

	@Override
	public ServiceCategoryDTO searchById(int id) {
		ServiceCategory sc = getId(id);
		if (sc != null) {
			return ServiceCategoryMapper.toServiceCategoryDTO(sc);
		}		
		return null;
	}
	
	// Search by name
	public List<ServiceCategoryDTO> searchByName(String name) {
		List<ServiceCategory> result = repo.findByServicecategoryNameContaining(name, Sort.by(Direction.ASC, "servicecategoryName"));
		List<ServiceCategoryDTO> lisDtos = new ArrayList<>();
		result.forEach(v -> lisDtos.add(ServiceCategoryMapper.toServiceCategoryDTO(v)));
		return lisDtos;
		
	}
	
	// Type casting
	public ServiceCategory toServiceCategory(ServiceCategoryDTO scDTO) {
		ServiceCategory sc = new ServiceCategory();
		sc.setServicecategoryId(scDTO.getServicecategoryId());
		sc.setServicecategoryName(scDTO.getServicecategoryName());
		sc.setStatus(scDTO.getStatus());
		return sc;
		
	}
}
