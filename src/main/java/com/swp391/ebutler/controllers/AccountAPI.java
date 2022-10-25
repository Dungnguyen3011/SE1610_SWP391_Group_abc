package com.swp391.ebutler.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swp391.ebutler.model.dto.LoginAccDTO;
import com.swp391.ebutler.model.dto.OtpSendingDTO;
import com.swp391.ebutler.model.dto.RegisterAccountDTO;
import com.swp391.ebutler.service.AccountService;
import com.swp391.ebutler.service.SendingOtpService;

@RestController
public class AccountAPI {

	@Autowired
	AccountService accsv;
	
	@Autowired
	SendingOtpService sdsv;
	
	@PostMapping("/account/save")
	public ResponseEntity<?> Register(@Valid @RequestBody RegisterAccountDTO acc) {
		return ResponseEntity.ok(accsv.registAcc(acc));
	}
	
	@GetMapping("/account/login")
	public ResponseEntity<?> Login(@Valid @RequestBody LoginAccDTO acc) {
		return ResponseEntity.ok(accsv.login(acc));
	}
	
	@PostMapping("/otpsending")
	public ResponseEntity<?> SendingOtp(@Valid @RequestBody OtpSendingDTO otp) {
		return ResponseEntity.ok(sdsv.sendOtp(otp));
	}
}
