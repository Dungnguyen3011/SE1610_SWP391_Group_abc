package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.ServiceCategory;
import com.swp391.ebutler.entities.Services;
import com.swp391.ebutler.model.dto.ServicesDTO;
import com.swp391.ebutler.model.mapper.ServicesMapper;
import com.swp391.ebutler.repositories.ServiceCategoryRepository;
import com.swp391.ebutler.repositories.ServicesRepository;
import com.swp391.ebutler.service.ServicesService;

@Service
public class ServicesServiceImp implements ServicesService {

	@Autowired
	ServicesRepository sRepo;
	@Autowired
	ServiceCategoryRepository scRepo;

	@Override
	public List<ServicesDTO> listAll() {
		List<Services> result = sRepo.findAll();
		List<ServicesDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ServicesMapper.toServicesDTO(v)));
		return listDTO;
	}

	@Override
	public ServicesDTO save(ServicesDTO sDTO) {
		Services s = toServices(sDTO);
		return ServicesMapper.toServicesDTO(sRepo.save(s));
	}

	@Override
	public ServicesDTO delete(int id) {
		Services s = getById(id);
		if (s != null) {
			s.setStatus(false);
			return ServicesMapper.toServicesDTO(sRepo.save(s));
		}
		return null;
	}

	@Override
	public Services getById(int id) {
		return sRepo.findById(id).get();
	}

	@Override
	public ServicesDTO getByIdDTO(int id) {
		Services s = sRepo.findById(id).get();
		if (s != null) {
			return ServicesMapper.toServicesDTO(s);
		}
		return null;
	}

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

	public ServiceCategory getServiceCategoryById(int id) {
		return scRepo.findById(id).get();
	}
}