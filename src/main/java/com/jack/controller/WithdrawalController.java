package com.jack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jack.domain.WalletTransactionType;
import com.jack.model.User;
import com.jack.model.Wallet;
import com.jack.model.WalletTransaction;
import com.jack.model.Withdrawal;
import com.jack.service.UserService;
import com.jack.service.WalletService;
import com.jack.service.WithdrawalService;

@RestController
@RequestMapping("/api/withdrawal")
public class WithdrawalController {
	
	@Autowired
	private WithdrawalService withdrawalService;

	@Autowired
	private WalletService walletService;
	
	@Autowired
	private UserService userService;
	
//	@Autowired
//	private WalletTransactionService walletTransactionService;
	
	@PostMapping("/api/withdrawal/{amount}")
	public ResponseEntity<?> withdrawalRequest(
			@PathVariable Long amount,
			@RequestHeader("Authorization") String jwt) throws Exception
	{
		User user = userService.findUserProfileByJwt(jwt);
		Wallet userWallet = walletService.getUserWallet(user);
		
		Withdrawal withdrawal = withdrawalService.requestWithdrawal(
				amount, user);
		walletService.addBalance(userWallet, -withdrawal.getAmount());
		
//		WalletTransaction walletTransaction = walletTransactionService
//				.createTransaction(userWallet,
//						WalletTransactionType.WITHDRAWAL,null,
//						"bank account withdrawal",
//						withdrawal.getAmount()			
//						);
		
		
		return new ResponseEntity<>(withdrawal, HttpStatus.OK);
		
	}
	
	@PostMapping("/api/admin/withdrawal/{id}/proceed/{accept}")
	public ResponseEntity<?> proceedWithdrawal(
			@PathVariable Long id,
			@PathVariable boolean accept,
			@RequestHeader("Authorization") String jwt) throws Exception
	{
		User user = userService.findUserProfileByJwt(jwt);
		Wallet userWallet = walletService.getUserWallet(user);
		
		Withdrawal withdrawal = withdrawalService.proceedWithdrawal(
				id, accept);
		walletService.addBalance(userWallet, withdrawal.getAmount());
		
		return new ResponseEntity<>(withdrawal, HttpStatus.OK);
	}
	
	@GetMapping("/api/withdrawal")
	public ResponseEntity<List<Withdrawal>> getWithdrawalHistory(
			@RequestHeader("Authorization") String jwt) throws Exception
	{
		User user = userService.findUserProfileByJwt(jwt);
		
		List<Withdrawal> withdrawal = withdrawalService.getUserWithdrawalHistory(user);
		
		return new ResponseEntity<>(withdrawal, HttpStatus.OK);
	}
	
	@GetMapping("/api/admin/withdrawal")
	public ResponseEntity<List<Withdrawal>> getAllWithdrawalRequest(
			@RequestHeader("Authorization") String jwt) throws Exception
	{
		User user = userService.findUserProfileByJwt(jwt);
		
		List<Withdrawal> withdrawal = withdrawalService.getAllWithdrawalRequest();

		return new ResponseEntity<>(withdrawal, HttpStatus.OK);
	}
	
	
}
