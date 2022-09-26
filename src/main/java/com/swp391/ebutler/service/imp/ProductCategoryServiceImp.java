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
	public ProductCategory save(ProductCategory proCategory) {
		return repo.save(proCategory);	
	}

	@Override
	public ProductCategory delete(int id) {
		ProductCategory proCategory = getById(id);
		if(proCategory != null) {
			proCategory.setStatus(false);
			return repo.save(proCategory);
		}
		return null;
	}

	@Override
	public ProductCategory update(ProductCategory proCategory) {
		return repo.save(proCategory);
	}

	@Override
	public ProductCategory getById(int id) {
		return repo.findById(id).get();
	}
	
	

	

	
}
