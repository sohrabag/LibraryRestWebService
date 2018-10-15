package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Publisher;
import com.example.demo.services.PublisherManagementService;

@RestController
public class publisherController {
	
	@Autowired
	private PublisherManagementService pms;
	
	@PostMapping("/publisher/addPublisher")
	public Publisher create(@Valid @RequestBody Publisher publisher)
	{
		
		return pms.create(publisher);
	}
	
	@GetMapping("/publishers/{publisherId}")
	public Publisher getPublisher(@PathVariable int publisherId)
	{
		return pms.read(publisherId);
	}
	
	@PutMapping("/publishers/{publisherId}/publisher")
	public Publisher updatePublisher(@PathVariable int publisherId, @RequestBody Publisher publisherRequest)
	{
		return pms.update(publisherId, publisherRequest);
	}
	
	@DeleteMapping("/publishers/{publisherId}")
	public ResponseEntity<?> delete(@PathVariable int publisherId)
	{
		return pms.delete(publisherId);
	}
	
}
