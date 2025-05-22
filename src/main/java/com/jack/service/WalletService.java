package com.jack.service;


import com.jack.model.Order;
import com.jack.model.User;
import com.jack.model.Wallet;

public interface WalletService {
	
	Wallet getUserWallet(User user);
	
	Wallet addBalance(Wallet wallet, Long money);
	
	Wallet findWalletById(Long id) throws Exception;
	
	Wallet walletToWalletTransfer(User sender, Wallet receiverWallet, Long amount) throws Exception;
	
	Wallet payOrderPayment(Order order, User user) throws Exception;

}
