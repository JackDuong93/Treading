package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.ForgotPasswordToken;

public interface ForgotPasswordRepository extends JpaRepository
	<ForgotPasswordToken, String>{

	ForgotPasswordToken findByUserId(Long userId);
	
	
	
}
