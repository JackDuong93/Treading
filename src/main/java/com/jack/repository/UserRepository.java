package com.jack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jack.model.User;

public interface UserRepository extends JpaRepository<User, Long > {

	User findByEmail(String email);
	
}
