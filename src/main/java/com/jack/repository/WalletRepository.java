package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Long>{

	Wallet findByUserId(Long userId);
	
	
}
