package com.jack;

import com.jack.domain.VerificationType;

import lombok.Data;

@Data
public class ForgotPasswordTokenRequest {
	
	private String sendTo;
	private VerificationType verificationType ;

}
