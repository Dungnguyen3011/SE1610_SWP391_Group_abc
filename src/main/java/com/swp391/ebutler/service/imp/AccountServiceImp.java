package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.swp391.ebutler.entities.Account;
import com.swp391.ebutler.repositories.AccountRepository;
import com.swp391.ebutler.service.AccountService;

public class AccountServiceImp implements AccountService {
	
	@Autowired
	private AccountRepository repo;

	@Override
	public List<Account> listAll() {	
		return repo.findAll() ;
	}

}
