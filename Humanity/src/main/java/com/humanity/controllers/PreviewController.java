package com.humanity.controllers;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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

import com.humanity.model.Preview;
import com.humanity.services.PreviewService;

@RestController
public class PreviewController {
	
	private static final Logger log = Logger.getLogger(PreviewController.class);
	private PreviewService previewService;
	
	@Autowired
	public void setPreviewService(PreviewService previewService) {
		
		this.previewService = previewService;
		
	}
	
	@RequestMapping(value = "/previews", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<List<Preview>> getAllPreviews() {
		
		log.info(new ResponseEntity<>(previewService.getAllPreviews(), HttpStatus.FOUND));
		return new ResponseEntity<>
		(previewService.getAllPreviews(), 
				HttpStatus.FOUND);
		
		
	}
	
	@RequestMapping(value = "/previews/{chapter}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Preview> getSpecificPreview(@Valid @RequestBody Preview preview, @PathVariable Integer chapter) {
		
		return new ResponseEntity<> (previewService.getSpecificPreview(preview), HttpStatus.FOUND);
		
	}
	
	@RequestMapping(value = "/previews/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Void> addPreview(@Valid @RequestBody Preview preview) {
		
		previewService.addPreview(preview);
		return new ResponseEntity<> (HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/previews/update", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
	public ResponseEntity<Preview> updatePreview(@Valid @RequestBody Preview preview) {
		
		previewService.updatePreview(preview);
		return new ResponseEntity<>(preview, HttpStatus.OK);
		
	}
	
	

}
