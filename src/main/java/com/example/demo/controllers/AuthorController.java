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
	 * we use dependency injection(DI) for service objects.
	 * AuthorManagementService is a service that connects
	 * to the Author table using JpaRepository interface
	 */
	@Autowired
	AuthorManagementService ams;
	
	/**
	 * create API creates a new author in the author table
	 * annotation PostMapping marks this method as CRUD operation 
	 * that supports any client like postman, web browser, and mobile device able to call REST controller 
	 * @param author : is an input parameter passes entire object in as JSON type
	 * @return : It returns an object of type Author
	 */
	@PostMapping(value = "/authors/addAuthor")
	public Author create( @Valid @RequestBody Author author)
	{
		return ams.create(author);
	}
	/**
	 * Annotation GetMapping identifies this URL as a GET operation of the CRUD operations
	 * read is a CRUD API.
	 * @param authorId : input parameter of type integer
	 * @return :  It returns an object of type Author. Entire object will be returned as a JSON type
	 */
	@GetMapping("/authors/{authorId}")
	public Author read(@PathVariable int authorId)
	{
		return ams.read(authorId);
	}
	
	/**
	 * Annotation PutMapping identifies that this API is a update operation of CRUD operations
	 * the URI is in the double quotation marks
	 * @param authorId : input parameter Author id to be update
	 * @param changedAuthor : input parameter of type Author object which is passed as JSON type
	 * @return is a object of type Author which the update object of type JSON
	 */
	@PutMapping("/author/update/{authorId}")
	public Author updageAuthorById(@PathVariable int authorId, @RequestBody Author changedAuthor)
	{
		return ams.update(authorId, changedAuthor);
	}
	
	/**
	 * Annotation DeleteMapping identifies this API as a delete operation of CRUD operations
	 * @param authorId : input parameter of type integer which identifies id of author to be delete
	 * @return : returns an ResponsEntity object which is a comprehensive information about whether 
	 * delete operation has been successful.
	 */
	@DeleteMapping("/authors/delete/{authorId}")
	public ResponseEntity<?> delete(@PathVariable int authorId)
	{
		return ams.delete(authorId);
	}
}
