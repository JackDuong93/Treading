package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.TwoFactorOTP;

public interface TwoFactorOtpRepository extends JpaRepository<TwoFactorOTP, String>
{
	TwoFactorOTP findByUserId(Long userId);
	

}
