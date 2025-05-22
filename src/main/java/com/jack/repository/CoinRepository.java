package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.Coin;

public interface CoinRepository extends JpaRepository<Coin, String> {
	
	

}
