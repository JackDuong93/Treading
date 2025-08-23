package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jack.domain.PaymentMethod;
import com.jack.model.PaymentOrder;
import com.jack.model.User;
import com.jack.response.PaymentResponse;
import com.jack.service.PaymentService;
import com.jack.service.UserService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

@RestController
public class PaymentController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentService paymentService;
	
	@PostMapping("/api/payment/{paymentMethod}/amount/{amount}")
	public ResponseEntity<PaymentResponse> paymentHeandler(
			@PathVariable("paymentMethod") PaymentMethod paymentMethod,
			@PathVariable("amount") Long amount,
			@RequestHeader("Authorization") String jwt)
					throws Exception,StripeException, RazorpayException 

	{
		User user = userService.findUserProfileByJwt(jwt);
		
		PaymentResponse paymentResponse;
		
		PaymentOrder order = paymentService.createOrder(user, amount, paymentMethod);
		
		if(paymentMethod.equals(PaymentMethod.RAZORPAY)) {
			paymentResponse = paymentService.createRazorpayPaymentLing(user, amount);
		}
		else {
			paymentResponse = paymentService.createStripePaymentLing(
					user, amount, order.getId());
		}
		return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
	}
	
}
