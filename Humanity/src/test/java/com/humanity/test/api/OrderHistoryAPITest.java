package com.humanity.test.api;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static io.restassured.RestAssured.given;

import com.humanity.config.HumanityConfig;
import com.humanity.dao.OrderHistoryDAO;

import io.restassured.http.ContentType;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HumanityConfig.class)
public class OrderHistoryAPITest {
	
	private static final Logger log = Logger.getLogger(OrderHistoryAPITest.class);
	
	private String baseUrl = "http://localhost:4200/humanity";
	private String retrieveOrderHistoryByUser = "/orderhistory";
	private String addCartToOrderHistory = "/orderhistory/purchase";
	
	
	private OrderHistoryDAO orderHistoryDAO;
	
	
	@Autowired
	public void setOrderHistoryDAO(OrderHistoryDAO orderHistoryDAO) {
		
		this.orderHistoryDAO = orderHistoryDAO;
		
	}
	
	@Test
	public void retrieveOrderHistoryByUserTest() {
		
		log.info("TESTING retrieveOrderHistoryByUser");
		given().contentType(ContentType.JSON).when().get(baseUrl + retrieveOrderHistoryByUser).then().assertThat().statusCode(302);
		
	}
	
	@Test
	public void addCartToOrderHistoryTest() {
		
		log.info("TESTING addCartToOrderHistory");
		given().contentType(ContentType.JSON).when().post(baseUrl + addCartToOrderHistory).then().assertThat().statusCode(201);
	}
	

}
