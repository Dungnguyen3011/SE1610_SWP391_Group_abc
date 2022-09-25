package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.ProductProvider;
import com.swp391.ebutler.repositories.ProductProviderRepository;
import com.swp391.ebutler.service.ProductProviderService;

@Service
public class ProductProviderServiceImp implements ProductProviderService {
	@Autowired
	ProductProviderRepository repo;
	
	@Override
	public List<ProductProvider> listAll(){
		return repo.findAll();
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
	public ProductProvider getById(int id) {
		return repo.findById(id).get();
	}
}
