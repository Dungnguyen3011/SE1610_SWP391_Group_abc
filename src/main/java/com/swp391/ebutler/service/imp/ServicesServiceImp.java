package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swp391.ebutler.entities.ServiceCategory;
import com.swp391.ebutler.entities.Services;
import com.swp391.ebutler.model.dto.ServicesDTO;
import com.swp391.ebutler.model.mapper.ServicesMapper;
import com.swp391.ebutler.repositories.ServiceCategoryRepository;
import com.swp391.ebutler.repositories.ServicesRepository;
import com.swp391.ebutler.service.ServicesService;

@Service
@Transactional
public class ServicesServiceImp implements ServicesService {

	@Autowired
	ServicesRepository sRepo;
	@Autowired
	ServiceCategoryRepository scRepo;

	// Show all 
	@Override
	public List<ServicesDTO> listAll() {
		List<Services> result = sRepo.findAll();
		List<ServicesDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ServicesMapper.toServicesDTO(v)));
		return listDTO;
	}

	// Save
	@Override
	public ServicesDTO save(ServicesDTO sDTO) {
		Services s = toServices(sDTO);
		return ServicesMapper.toServicesDTO(sRepo.save(s));
	}

	// Delete 
	@Override
	public ServicesDTO delete(int id) {
		Services s = getId(id);
		if (s != null) {
			s.setStatus(false);
			return ServicesMapper.toServicesDTO(sRepo.save(s));
		}
		return null;
	}

	// Search by id
	public Services getId(int id) {
		return sRepo.findById(id).get();
	}

	@Override
	public ServicesDTO searchById(int id) {
		Services s = getId(id);
		if (s != null) {
			return ServicesMapper.toServicesDTO(s);
		}
		return null;
	}
	
	// Search by name
	public List<ServicesDTO> searchByName(String name) {
		List<Services> result = sRepo.findByServiceNameContaining(name, Sort.by(Direction.ASC, "serviceName"));
		List<ServicesDTO> listDtos = new ArrayList<>();
		result.forEach(v -> listDtos.add(ServicesMapper.toServicesDTO(v)));
		return listDtos;
	}
	
	// Type casting
	public Services toServices(ServicesDTO sDTO) {
		Services s = new Services();
		s.setServiceId(sDTO.getServiceId());
		s.setServiceName(sDTO.getServiceName());
		s.setDescription(sDTO.getDescription());
		s.setImage(sDTO.getImage());
		s.setStatus(sDTO.getStatus());
		s.setSCategory(getServiceCategoryById(sDTO.getServicecategoryId()));
		return s;
	}

	// Get service category by id
	public ServiceCategory getServiceCategoryById(int id) {
		return scRepo.findById(id).get();
	}
}
