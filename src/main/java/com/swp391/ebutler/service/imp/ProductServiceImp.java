package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.swp391.ebutler.entities.Product;
import com.swp391.ebutler.repositories.ProductRepository;
import com.swp391.ebutler.service.ProductService;

public class ProductServiceImp implements ProductService{
	@Autowired
	ProductRepository repo;
	
	@Override
	public List<Product> listAll(){
		return repo.findAll();
	}

	@Override
	public Product save(Product p) {
		return repo.save(p);	
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);;
	}

	@Override
	public void update(Product p) {
		repo.save(p);
	}
}
