package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.VerificationCode;

public interface VerificationCodeRepository extends JpaRepository
	<VerificationCode, Long>{
	
	public VerificationCode findByUserId(Long userId);
	
	

}
