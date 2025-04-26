package com.jack.service;

import com.jack.domain.VerificationType;
import com.jack.model.ForgotPasswordToken;
import com.jack.model.User;

public interface ForgotPasswordService {
	
	ForgotPasswordToken createToken(
			User user,
			String id, String otp,
			VerificationType verificationType,
			String sendTo
			);
	
	ForgotPasswordToken findById(String id);
	
	ForgotPasswordToken findByUser(Long userId);
	
	void deleteToken(ForgotPasswordToken token);

}
