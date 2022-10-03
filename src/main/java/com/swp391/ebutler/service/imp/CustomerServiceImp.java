package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swp391.ebutler.entities.Account;
import com.swp391.ebutler.entities.Customer;
import com.swp391.ebutler.model.dto.CustomerDTO;
import com.swp391.ebutler.model.mapper.CustomerMapper;
import com.swp391.ebutler.repositories.AccountRepository;
import com.swp391.ebutler.repositories.CustomerRepository;
import com.swp391.ebutler.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository cRepo;
	@Autowired
	AccountRepository aRepo;

	// Show all
	@Override
	public List<CustomerDTO> listAll() { 
		List<Customer> result = cRepo.findAll();
		List<CustomerDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(CustomerMapper.toCustomerDTO(v)));
		return listDTO;
	}

	
	// Save 
	@Override
	public CustomerDTO save(CustomerDTO cDTO) {
		Customer c = toCustomer(cDTO);
		return CustomerMapper.toCustomerDTO(cRepo.save(c));
	}

	
	// Search By Id
	public Customer getId(int id) {
		return cRepo.findById(id).get();
	}
	@Override
	public CustomerDTO searchById(int id) {
		Customer c = getId(id);
		if (c != null) {
			return CustomerMapper.toCustomerDTO(c);
		}
		return null;
	}
	
	
	// Search by Name and sort ASC with name
	@Override
	public List<CustomerDTO> searchByName(String name) {
		List<Customer> result = cRepo.findByFullNameContaining(name, Sort.by(Direction.ASC, "fullName"));
		List<CustomerDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(CustomerMapper.toCustomerDTO(v)));
		return listDTO;
	}
	

	// Type casting
	public Customer toCustomer(CustomerDTO cDTO) {
		Customer c = new Customer();
		c.setCustomerId(cDTO.getCustomerId());
		c.setEmail(cDTO.getEmail());
		c.setFullName(cDTO.getFullName());
		c.setPhoneNumber(cDTO.getPhoneNumber());
		c.setAddress(cDTO.getAddress());
		c.setAccount(getAccountById(cDTO.getAccountId()));
		return c;
	}

	// Get account by id
	public Account getAccountById(int id) {
		return aRepo.findById(id).get();
	}
}
