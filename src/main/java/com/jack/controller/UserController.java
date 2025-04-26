package com.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.jack.domain.VerificationType;
import com.jack.model.User;
import com.jack.model.VerificationCode;
import com.jack.service.EmailService;
import com.jack.service.UserService;
import com.jack.service.VerificationCodeService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private VerificationCodeService verificationCodeService;
	
	@Autowired
	private EmailService emailService;
	private String jwt;

	@GetMapping("/api/users/profile")
	public ResponseEntity<User> getUserProfile(@RequestHeader("Authorization")
	String jwt) throws Exception {
		User user = userService.findUserPrifileByJwt(jwt);
		
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/api/users/verification{verificationType}/send-otp")
	public ResponseEntity<String> sendVerificationOtp(
			@RequestHeader("Authorization")
			String jwt,
			@PathVariable VerificationType verificationType) throws Exception {
		User user = userService.findUserPrifileByJwt(jwt);
		
		VerificationCode verificationCode = 
				verificationCodeService.getVerificationCodeByUser(user.getId());
		
		if(verificationCode!=null) {
			
			verificationCode = verificationCodeService
					.sendVerificationCode(user, verificationType);

		}
		
		if(verificationType.equals(verificationType.EMAIL)) {
			emailService.sendVerificationOtpEmail
			(user.getEmail(),verificationCode.getOtp());
		}
		
		
		return new ResponseEntity<>("verification otp sent successfully", HttpStatus.OK);
	}
	
	
	@PatchMapping("/api/users/enable-two-factor/verify-otp/{otp}")
	public ResponseEntity<User> enablewoFactorAuthentication(
			@PathVariable String otp,
			@RequestHeader("Authorization")
			String jwt) throws Exception {
		User user = userService.findUserPrifileByJwt(jwt);
		
		VerificationCode verificationCode = 
				verificationCodeService.getVerificationCodeByUser(user.getId());
		
		String sendTo = verificationCode.getVerificationType()
				.equals(VerificationType.EMAIL)?
				verificationCode.getEmail():verificationCode.getMobile();
		
		boolean isVerified = verificationCode.getOtp().equals(otp);
		
		if(isVerified) {
			User updateUser = userService.enableTwoFactorAuthentication(
					verificationCode.getVerificationType(), sendTo, user);
			
			verificationCodeService.deleteVerificationCodeById(verificationCode);
			return new ResponseEntity<>(updateUser, HttpStatus.OK);
		}
		
		throw new Exception("Wrong otp");
		
	}
	
	
}
