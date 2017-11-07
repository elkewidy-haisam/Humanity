package com.humanity.test.services;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.humanity.config.HumanityConfig;
import com.humanity.model.User;
import com.humanity.services.UserService;

public class UserServiceTest {
	
private static final Logger log = Logger.getLogger(UserServiceTest.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HumanityConfig humanConfig;
	
	@Test
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void register() {
		
		int currentUsersBefore = userService.getAllUsers().size();
		
		User user = humanConfig.user();
		user.setPassword("password");
		user.setUsername("elkewidyhaisam");
		
		userService.register(user);
		
		int currentUsersAfter = userService.getAllUsers().size();
		
		assertEquals(currentUsersBefore + 1, currentUsersAfter);
		
		
	}
	
	@Test
	public void login() {
		
		userService.login("elkewidyhaisam", "password");
		
	}
	
	
	@Test
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public void closeAccount() {
		
		int currentUsersBefore = userService.getAllUsers().size();
		
		User user = humanConfig.user();
		user.setPassword("password");
		user.setUsername("elkewidyhaisam");
		
		userService.closeAccount(user);
		
		int currentUsersAfter = userService.getAllUsers().size();
		
		assertEquals(currentUsersBefore - 1, currentUsersAfter);
		
	}

}
