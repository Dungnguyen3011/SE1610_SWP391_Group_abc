package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.Product;
import com.swp391.ebutler.repositories.ProductRepository;
import com.swp391.ebutler.service.ProductService;

@Service
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
	public Product delete(int id) {
		Product p = getById(id);
		if(p != null) {
			p.setStatus(false);
			return repo.save(p);
		}
		return null;
	}

	@Override
	public Product update(Product p) {
		return repo.save(p);
	}

	@Override
	public Product getById(int id) {
		return repo.findById(id).get();
	}
	
}
