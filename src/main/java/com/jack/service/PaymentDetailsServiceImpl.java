package com.jack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jack.model.PaymentDetails;
import com.jack.model.User;
import com.jack.repository.PaymentDetailsRepository;

@Service
public class PaymentDetailsServiceImpl implements PaymentDetailsService{

	@Autowired
	PaymentDetailsRepository paymentDetailsRepository;
	
	@Override
	public PaymentDetails addPaymentDetails(String accountNumber, String accountHolderName, String ifsc,
			String bankName, User user) {
		PaymentDetails paymentDetails = new PaymentDetails();
		paymentDetails.setAccountHolderName(accountHolderName);
		paymentDetails.setAccountNumber(accountNumber);
		paymentDetails.setIfsc(bankName);
		paymentDetails.setUser(user);
		return paymentDetailsRepository.save(paymentDetails);
	}

	@Override
	public PaymentDetails getUsersPaymentDetails(User user) {
		// TODO Auto-generated method stub
		return paymentDetailsRepository.findByUserId(user.getId());
	}


	
	

}
