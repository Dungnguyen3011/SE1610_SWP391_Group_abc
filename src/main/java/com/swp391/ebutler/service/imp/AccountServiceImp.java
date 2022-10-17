package com.swp391.ebutler.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.swp391.ebutler.model.dto.LoginAccDTO;
import com.swp391.ebutler.entities.Account;
import com.swp391.ebutler.repositories.AccountRepository;
import com.swp391.ebutler.service.AccountService;
@Service
@Transactional
public class AccountServiceImp implements AccountService {
	
	@Autowired
	private AccountRepository repo;

	@Override
	public List<Account> listAll() {	
		return repo.findAll() ;
	}

	@Override
	public RegisterAccountDTO login(LoginAccDTO acc) {
		RegisterAccountDTO accdto = new RegisterAccountDTO();
		Account account = repo.findByLoginMailAndPassword(acc.getLoginMail(), acc.getPassword());
		if(account !=null) {
			Customer cusacc = cusrepo.findByAccountId(account.getAccountId());
			if(cusacc != null) {
				accdto.setLoginMail(account.getLoginMail());
				accdto.setFullName(cusacc.getFullName());
				accdto.setAddress(cusacc.getAddress());
				accdto.setPhoneNumber(cusacc.getPhoneNumber());
				accdto.setRole(true);
			}else {
				Provider proacc = providerrepo.findByAccountId(account.getAccountId());
				accdto.setLoginMail(account.getLoginMail());
				accdto.setFullName(proacc.getProviderName());
				accdto.setAddress(proacc.getAddress());
				accdto.setPhoneNumber(proacc.getPhoneNumber());
				accdto.setRole(false);
			}
			return accdto;
		}
		return null;
	}
}
