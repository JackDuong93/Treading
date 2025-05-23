package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.PaymentDetails;

public interface PaymentDetailsRepository extends JpaRepository<PaymentDetails, Long> {

	PaymentDetails findByUserId(Long userId);
	
}
