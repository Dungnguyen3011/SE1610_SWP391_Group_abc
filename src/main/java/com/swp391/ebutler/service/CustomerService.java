package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.entities.Customer;
import com.swp391.ebutler.model.dto.CustomerDTO;

public interface CustomerService {
	
	public List<CustomerDTO> listAll();
	
	public CustomerDTO save(CustomerDTO c);
	
	public Customer getById(int id);
	
	public CustomerDTO getByIdDTO(int id);
}
