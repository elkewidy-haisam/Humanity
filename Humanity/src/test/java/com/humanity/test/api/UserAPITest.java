package com.humanity.test.api;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.humanity.config.HumanityConfig;
import com.humanity.dao.UserDAO;
import com.humanity.model.User;

import io.restassured.http.ContentType;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HumanityConfig.class)
public class UserAPITest {
	
private static final Logger log = Logger.getLogger(OrderHistoryAPITest.class);
	
	private String baseUrl = "http://localhost:8080/Humanity";
	private String login = "/login";
	private String closeAccount = "/farewell";
	
	
	private UserDAO userDAO;
	
	@Autowired
	HumanityConfig humanConfig;
	
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		
		this.userDAO = userDAO;
		
	}
	
	@Test
	public void loginTest() {
		
		log.info("TESTING login");
		String username = "username3";
		String password = "password3";
		given().contentType("application/json").param(username).param(password).when().get(baseUrl + login).then().assertThat().statusCode(302);
		
	}
	
	@Test
	public void closeAccount() {
		
		log.info("TESTING closeAccount");
		
		User user = humanConfig.user();
		user.setUsername("username3");
		user.setPassword("password3");
		
		given().contentType("application/json").request().body(user).when().delete(baseUrl + closeAccount).then().assertThat().statusCode(410);
		
	}


}
