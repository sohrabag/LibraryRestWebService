package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Author;
import com.example.demo.services.AuthorManagementService;

@RestController
public class AuthorController {

	@Autowired
	AuthorManagementService ams;
	
	@PostMapping(value = "/authors/addAuthor")
	public Author create( @RequestBody Author author)
	{
		return ams.create(author);
	}
}
