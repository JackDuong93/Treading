package com.jack.service;

import com.jack.domain.PaymentMethod;
import com.jack.model.PaymentOrder;
import com.jack.model.User;
import com.jack.response.PaymentResponse;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;

public interface PaymentService {

	PaymentOrder createOrder(User user, 
			Long amount, 
			PaymentMethod paymentMethod);
	
	PaymentOrder getPaymentOrderById(Long id) throws Exception;
	
	Boolean ProceedPaymentOrder(PaymentOrder paymentOrder, String paymentId) throws RazorpayException;
	
	PaymentResponse createRazorpayPaymentLing(User user, Long amount) throws RazorpayException; 
	
	PaymentResponse createStripePaymentLing(User user, Long amount, Long orderId) throws StripeException; 
}
