package com.jack.service;

import com.jack.domain.VerificationType;
import com.jack.model.User;

public interface UserService {
	
	public User findUserProfileByJwt(String jwt) throws Exception;
	
	public User findUserByEmail(String email) throws Exception;
	
	public User findUserById(Long userId) throws Exception;
	
	public User enableTwoFactorAuthentication(
			VerificationType verificationType,
			String sendTo,
			User user);
	
	public User updatePassowrd(User user, String newPassword);
	
	
	
}
