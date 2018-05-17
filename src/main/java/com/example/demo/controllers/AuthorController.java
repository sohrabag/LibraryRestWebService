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
/**
 * 
 * @author Sohrab Azami Ghadim
 * AuthorController provides CRUD operations for
 * Author table.
 *
 */
@RestController
public class AuthorController {

	/**
	 * we use dependency injection for service objects
	 * AuthorManagementService is a service that connects
	 * to the Author table using JpaRepository interface
	 */
	@Autowired
	AuthorManagementService ams;
	
	/**
	 * create api creates a new author in the author table
	 * author parameter passes in the properties for new author
	 * @param author
	 * @return
	 */
	@PostMapping(value = "/authors/addAuthor")
	public Author create( @Valid @RequestBody Author author)
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
