package com.humanity.controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.humanity.model.Comic;
import com.humanity.services.ComicService;

@RestController
public class ComicController {
	
	private static final Logger log = Logger.getLogger(CartController.class);
	private ComicService comicService;
	
	public void setComicService(ComicService comicService) {
		
		this.comicService = comicService;
		
	}
	
	
	@RequestMapping(value="/getAllComics", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<List<Comic>> getAllComics() {
		
		return new ResponseEntity<>(comicService.getAllComics(), HttpStatus.FOUND);
		
	}
	
	
	@RequestMapping(value="/addComicToStore", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Void> addComicToStore(@Valid @RequestBody Comic comic) {
		
		comicService.addComicToStore(comic);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value="/updateComic", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Void> updateComicCredentials(@Valid @RequestBody Comic comic) {
		
		comicService.updateComicCredentials(comic);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
	
	
	@RequestMapping(value="/findComicByChapter", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Comic> findComicByChapter(@PathVariable int chapter) {
		
		return new ResponseEntity<>(comicService.findComicByChapter(chapter), HttpStatus.FOUND);
		
	}
	
	
	@RequestMapping(value="/findComicByTitle", method=RequestMethod.GET, consumes=MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Comic> findComicByTitle(@PathVariable String title) {
		
		return new ResponseEntity<>(comicService.findComicByTitle(title), HttpStatus.FOUND);
		
	}

}
