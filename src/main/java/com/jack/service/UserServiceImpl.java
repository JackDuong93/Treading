package com.jack.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jack.config.JwtProvider;
import com.jack.domain.VerificationType;
import com.jack.model.TwoFactorAuth;
import com.jack.model.User;
import com.jack.repository.UserRepository;

@RestController
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	
	@Override
	public User findUserPrifileByJwt(String jwt) throws Exception {
		
		String email = JwtProvider.getEmailFromToken(jwt);
		
		User user = userRepository.findByEmail(email);
		
		if(user==null) {
			throw new Exception("user not found");
		}
		
		return user;
	}

	@Override
	public User findUserByEmail(String email) throws Exception {
		
		User user = userRepository.findByEmail(email);
		
		if(user==null) {
			throw new Exception("user not found");
		}
		return user;
	}

	@Override
	public User findUserById(Long userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		
		if(user.isEmpty()) {
			throw new Exception("user not found");
		}
		
		return user.get();
	}

	@Override
	public User enableTwoFactorAuthentication(VerificationType verificationType, String sendTo, User user) {
		
		TwoFactorAuth twoFactorAuth = new TwoFactorAuth();
		twoFactorAuth.setEnalbed(true);
		twoFactorAuth.setSendTo(verificationType);
		
		user.setTwoFactorAuth(twoFactorAuth);
		
		return userRepository.save(user);
	}
	

	@Override
	public User updatePassowrd(User user, String newPassword) {
		user.setPassword(newPassword);
		
		return userRepository.save(user);
	}
	

}
