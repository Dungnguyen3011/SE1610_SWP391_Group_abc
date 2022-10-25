package com.swp391.ebutler.service;

import com.swp391.ebutler.model.dto.OtpSendingDTO;

public interface SendingOtpService {

	public Integer sendOtp(OtpSendingDTO otp);
}
