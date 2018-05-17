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
	
	@GetMapping("/authors/{authorId}")
	public Author read(@PathVariable int authorId)
	{
		return ams.read(authorId);
	}
	
	@PutMapping("/author/update/{authorId}")
	public Author updageAuthorById(@PathVariable int authorId, @RequestBody Author changedAuthor)
	{
		return ams.update(authorId, changedAuthor);
	}
	
	@DeleteMapping("/authors/delete/{authorId}")
	public ResponseEntity<?> delete(@PathVariable int authorId)
	{
		return ams.delete(authorId);
	}
}
