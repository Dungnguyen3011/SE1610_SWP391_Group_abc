package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.swp391.ebutler.entities.Customer;
import com.swp391.ebutler.repositories.CustomerRepository;
import com.swp391.ebutler.service.CustomerService;

public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepository repo;
	
	@Override
	public List<Customer> listAll() {
		return repo.findAll();
	}

	@Override
	public Customer save(Customer c) {
		return repo.save(c);	
	}

	@Override
	public Customer update(Customer c) {
		return repo.save(c);
	}

	@Override
	public Customer getById(int id) {
		return repo.findById(id).get();
	}
}
