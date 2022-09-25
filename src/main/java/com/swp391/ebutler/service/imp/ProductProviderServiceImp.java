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
	public ProductProvider save(ProductProvider pprovider) {
		return repo.save(pprovider);	
	}

	@Override
	public ProductProvider delete(int id) {
		ProductProvider pprovider = getById(id);
		if(pprovider != null) {
			pprovider.setStatus(false);
			return repo.save(pprovider);
		}
		return null;
	}

	@Override
	public ProductProvider update(ProductProvider pprovider) {
		return repo.save(pprovider);
	}

	@Override
	public ProductProvider getById(int id) {
		return repo.findById(id).get();
	}
}
