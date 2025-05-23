package com.jack.service;

import java.util.List;

import com.jack.model.User;
import com.jack.model.Withdrawal;

public interface WithdrawalService {
	
	Withdrawal requestWithdrawal(Long amount, User user);
	
	Withdrawal proceedWithdrawal(Long withdrawalId, boolean accept) throws Exception;
	
	List<Withdrawal> getUserWithdrawalHistory(User user);
	
	List<Withdrawal> getAllWithdrawalRequest();


}
