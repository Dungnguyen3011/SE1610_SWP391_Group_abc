package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.ProductCategory;
import com.swp391.ebutler.repositories.ProductCategoryRepository;
import com.swp391.ebutler.service.ProductCategoryService;

@Service
public class ProductCategoryServiceImp implements ProductCategoryService{

	@Autowired
	ProductCategoryRepository repo;
	
	@Override
	public List<ProductCategory> listAll(){
		return repo.findAll();
	}

	@Override
	public ProductCategory save(ProductCategory procate) {
		return repo.save(procate);	
	}

	@Override
	public ProductCategory delete(int id) {
		ProductCategory procate = getById(id);
		if(procate != null) {
			procate.setStatus(false);
			return repo.save(procate);
		}
		return null;
	}

	@Override
	public ProductCategory update(ProductCategory procate) {
		return repo.save(procate);
	}

	@Override
	public ProductCategory getById(int id) {
		return repo.findById(id).get();
	}
	
	

	

	
}
