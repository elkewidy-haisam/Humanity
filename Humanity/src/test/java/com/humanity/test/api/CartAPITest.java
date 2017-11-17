package com.humanity.test.api;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.junit.Assert.assertEquals;

import com.humanity.config.HumanityConfig;
import com.humanity.dao.CartDAO;

import io.restassured.http.ContentType;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HumanityConfig.class)
public class CartAPITest {
	
	private static final Logger log = Logger.getLogger(CartAPITest.class);
	
	private String baseUrl = "http://localhost:4200/humanity";
	private String createCart = "/createCart";
	private String addComicToCart = "/addComicToCart";
	private String retrieveShoppingCart = "/cart";
	private String removeAllItemsFromCart = "/remoeAllFromCart";
	private String removeComicFromCart = "removeFromCart";
	
	CartDAO cartDAO;
	
	@Autowired
	public void setCartDAO(CartDAO cartDAO) {
		
		this.cartDAO = cartDAO;
		
	}
	
	@Test
	public void createCartUponLoginTest() {
		
		log.info("TESTING createCartUponLogin");
		
		given().contentType(ContentType.JSON).when().post(baseUrl + createCart).then().assertThat().statusCode(201);
		
	}
	
	@Test
	public void addComicToCartTest() {
		
		log.info("TESTING addComicToCart");
		given().contentType(ContentType.JSON).when().post(baseUrl + addComicToCart).then().assertThat().statusCode(201);
		
	}
	
	@Test
	public void retrieveShoppingCartTest() {
		
		log.info("TESTING retrieveShoppingCart");
		given().contentType(ContentType.JSON).when().get(baseUrl + retrieveShoppingCart).then().assertThat().statusCode(200);
		
	}
	
	@Test
	public void removeAllItemsFromCartTest() {
		
		log.info("TESTING removeAllItemsFromCart");
		given().contentType(ContentType.JSON).when().delete(baseUrl + removeAllItemsFromCart).then().assertThat().statusCode(410);
		
	}
	
	@Test
	public void removeComicFromCartTest() {
		
		log.info("TESTING removeComicFromCartTest");
		given().contentType(ContentType.JSON).when().delete(baseUrl + removeComicFromCart).then().assertThat().statusCode(410);
		
	}
	
	
	
	
	
	
	
	

}
