package com.swp391.ebutler.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swp391.ebutler.entities.Account;
import com.swp391.ebutler.entities.Customer;
import com.swp391.ebutler.model.dto.CustomerDTO;
import com.swp391.ebutler.model.mapper.CustomerMapper;
import com.swp391.ebutler.repositories.AccountRepository;
import com.swp391.ebutler.repositories.CustomerRepository;
import com.swp391.ebutler.service.CustomerService;

@Service
public class CustomerServiceImp implements CustomerService {

	@Autowired
	CustomerRepository cRepo;
	@Autowired
	AccountRepository aRepo;

	@Override
	public List<CustomerDTO> listAll() {
		List<Customer> result = cRepo.findAll();
		List<CustomerDTO> listDTO = new ArrayList<>();
		result.forEach(v -> listDTO.add(CustomerMapper.toCustomerDTO(v)));
		return listDTO;
	}

	@Override
	public CustomerDTO save(CustomerDTO cDTO) {
		Customer c = toCustomer(cDTO);
		return CustomerMapper.toCustomerDTO(cRepo.save(c));
	}

	@Override
	public Customer getById(int id) {
		return cRepo.findById(id).get();
	}

	@Override
	public CustomerDTO getByIdDTO(int id) {
		Customer c = cRepo.findById(id).get();
		if (c != null) {
			return CustomerMapper.toCustomerDTO(c);
		}
		return null;
	}

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

	public Account getAccountById(int id) {
		return aRepo.findById(id).get();
	}
}
