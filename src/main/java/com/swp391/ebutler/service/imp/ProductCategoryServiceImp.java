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
	public void delete(int id) {
		repo.deleteById(id);;
	}

	@Override
	public void update(ProductCategory procate) {
		repo.save(procate);
	}
	
	

	

	
}
