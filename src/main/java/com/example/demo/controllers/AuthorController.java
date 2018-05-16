package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Author;
import com.example.demo.services.AuthorManagementService;

public class AuthorController {

	@Autowired
	AuthorManagementService ams;
	
	@PostMapping(value = "/authors/addAuthor")
	public Author create(@Valid @ResponseBody Author author)
	{
		return ams.create(author);
	}
}
