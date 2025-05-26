package com.jack.service;

import com.jack.model.PaymentDetails;

import com.jack.model.User;

public interface PaymentDetailsService {
	
	public PaymentDetails addPaymentDetails(
			String accountNumber,
			String accountHolderName,
			String ifsc,
			String bankName,
			User user);
	
	public PaymentDetails getUsersPaymentDetails(User user);
	
	
	
	
	
}
