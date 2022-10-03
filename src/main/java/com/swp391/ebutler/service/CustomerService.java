package com.swp391.ebutler.service;

import java.util.List;

import com.swp391.ebutler.model.dto.CustomerDTO;

public interface CustomerService {

	public List<CustomerDTO> listAll();

	public CustomerDTO save(CustomerDTO c);

	public CustomerDTO searchById(int id);

	public List<CustomerDTO> searchByName(String name);
}
