package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.model.dto.ProductProviderDTO;
import com.swp391.ebutler.model.mapper.ProductProviderMapper;
import com.swp391.ebutler.repositories.ProductProviderRepository;
import com.swp391.ebutler.service.ProductProviderService;

@Service
public class ProductProviderServiceImp implements ProductProviderService {
	@Autowired
	ProductProviderRepository repo;
	
	@Override
	public List<ProductProviderDTO> listAll(){
		List<ProductProvider> result = repo.findAll();
		List<ProductProviderDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(ProductProviderMapper.toProductCategoryDTO(v)) );
		return listDTO;
	}

	@Override
	public ProductProvider save(ProductProvider pProvider) {
		return repo.save(pProvider);	
	}

	@Override
	public ProductProvider delete(int id) {
		ProductProvider pProvider = getById(id);
		if(pProvider != null) {
			pProvider.setStatus(false);
			return repo.save(pProvider);
		}
		return null;
	}

	@Override
	public ProductProvider update(ProductProvider pProvider) {
		return repo.save(pProvider);
	}

	@Override
	public ProductProviderDTO getByIdDTO(int id) {
		ProductProvider result = repo.findById(id).get();
		return ProductProviderMapper.toProductCategoryDTO(result);
	}

	@Override
	public ProductProvider getById(int id) {
		return repo.findById(id).get();
	}
}
