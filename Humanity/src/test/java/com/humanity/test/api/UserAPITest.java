package com.humanity.test.api;

import static io.restassured.RestAssured.given;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.humanity.config.HumanityConfig;
import com.humanity.dao.UserDAO;

import io.restassured.http.ContentType;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HumanityConfig.class)
public class UserAPITest {
	
private static final Logger log = Logger.getLogger(OrderHistoryAPITest.class);
	
	private String baseUrl = "http://localhost:4200/humanity";
	private String login = "/login";
	private String closeAccount = "/farewell";
	
	
	private UserDAO userDAO;
	
	
	@Autowired
	public void setOrderHistoryDAO(UserDAO userDAO) {
		
		this.userDAO = userDAO;
		
	}
	
	@Test
	public void loginTest() {
		
		log.info("TESTING login");
		given().contentType(ContentType.JSON).when().get(baseUrl + login).then().assertThat().statusCode(302);
		
	}
	
	@Test
	public void closeAccount() {
		
		log.info("TESTING closeAccount");
		given().contentType(ContentType.JSON).when().delete(baseUrl + closeAccount).then().assertThat().statusCode(410);
		
	}


}
