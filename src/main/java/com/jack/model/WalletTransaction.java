package com.jack.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.jack.domain.OrderStatus;
import com.jack.domain.OrderType;
import com.jack.domain.WalletTransactionType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class WalletTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Wallet wallet;
	
	private WalletTransactionType type;
	
	private LocalDate date;
	
	private String transferId;
	
	private String purpose;
	
	private Long amount;

}
