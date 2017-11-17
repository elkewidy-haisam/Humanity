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
import com.humanity.dao.PreviewDAO;

import io.restassured.http.ContentType;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HumanityConfig.class)
public class PreviewAPITest {
	
	private static final Logger log = Logger.getLogger(CartAPITest.class);
	
	private String baseUrl = "http://localhost:4200/humanity";
	private String getAllPreviews = "/previews";
	private String getSpecificPreview = "/previews/{chapter}";
	private String addPreview = "/previews/add";
	private String updatePreview = "/previews/update";
	
	private PreviewDAO previewDAO;
	
	@Autowired
	public void setPreviewDAO(PreviewDAO previewDAO) {
		
		this.previewDAO = previewDAO;
		
	}
	
	@Test
	public void getAllPreviewsTest() {
		
		log.info("TESTING getAllPreviews");
		given().contentType(ContentType.JSON).when().get(baseUrl + getAllPreviews).then().assertThat().statusCode(302);
		
	}
	
	@Test
	public void getSpecificPreviewTest() {
		
		log.info("TESTING getSpecificPreview");
		given().contentType(ContentType.JSON).when().get(baseUrl + getSpecificPreview).then().assertThat().statusCode(302);
		
	}
	
	@Test
	public void addPreviewTest() {
		
		log.info("TESTING addPreview");
		given().contentType(ContentType.JSON).when().post(baseUrl + addPreview).then().assertThat().statusCode(201);
	
	}
	
	@Test
	public void updatePreviewTest() {
		
		log.info("TESTING updatePreview");
		given().contentType(ContentType.JSON).when().put(baseUrl + updatePreview).then().assertThat().statusCode(200);
	}
	
	
	
	
	
	

}
