package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Customer;

public interface CustomerService {
	
	public List<Customer> listAll();
	
	public Customer save(Customer c);
	
	public Customer update(Customer c);
	
	public Customer getById(int id);
	
}
