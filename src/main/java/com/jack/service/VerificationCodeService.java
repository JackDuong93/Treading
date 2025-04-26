package com.jack.service;

import com.jack.domain.VerificationType;
import com.jack.model.User;
import com.jack.model.VerificationCode;

public interface VerificationCodeService {
	
	VerificationCode sendVerificationCode(User user,VerificationType verificationType);
	
	VerificationCode sendVerificationCodeById(Long id) throws Exception;
	
	VerificationCode getVerificationCodeByUser(Long userId);
	
	
	
	void deleteVerificationCodeById(VerificationCode verificationCode);
	
	

}
