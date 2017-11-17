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
import com.humanity.dao.ComicDAO;

import io.restassured.http.ContentType;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=HumanityConfig.class)
public class ComicAPITest {

	private static final Logger log = Logger.getLogger(ComicAPITest.class);
	
	private String baseUrl = "http://localhost:4200/humanity";
	private String getComics = "/getAllComics";
	private String addComicToStore = "/addComicToStore";
	private String updateComic = "/updateComic";
	private String findComicByChapter = "/findComicByChapter";
	private String findComicByTitle = "/findComicByTitle";
	
	private ComicDAO comicDAO;
	
	@Autowired
	public void setComicDAO(ComicDAO comicDAO) {
		
		this.comicDAO = comicDAO;
		
	}
	
	@Test
	public void getAllComicsTest() {
		
		log.info("TESTING getAllComics");
		given().contentType(ContentType.JSON).when().get(baseUrl + getComics).then().assertThat().statusCode(302);
		
	}
	
	@Test
	public void addComicToStoreTest() {
		
		log.info("TESTING addComicToStore");
		given().contentType(ContentType.JSON).when().post(baseUrl + addComicToStore).then().assertThat().statusCode(201);
		
	}
	
	@Test
	public void updateComicCredentialsTest() {
		
		log.info("TESTING updateComicCredentials");
		given().contentType(ContentType.JSON).when().put(baseUrl + updateComic).then().assertThat().statusCode(200);
		
	}
	
	@Test
	public void findComicByChapterTest() {
		
		log.info("TESTING findComicByChapter");
		given().contentType(ContentType.JSON).when().put(baseUrl + findComicByChapter).then().assertThat().statusCode(302);
		
	}
	
	@Test
	public void findComicByTitleTest() {
		
		log.info("TESTING findComicByTitle");
		given().contentType(ContentType.JSON).when().get(baseUrl + findComicByTitle).then().assertThat().statusCode(302);
		
	}
	
	
	
}
