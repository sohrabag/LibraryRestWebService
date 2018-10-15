package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Author;
import com.example.demo.jpa.exception.ResourceNotFoundException;

public interface IAuthorManagementService {
	
	/**
	 * This method creates an author in the author table
	 * @param author : input parameter of type author in JSON format
	 * @return : It return an Author object in JSON format
	 */
	Author create(Author author);
	
	/**
	 * This method deletes an author from author table using id of the author
	 * @param authorId : input parameter of type integer
	 * @return : It returns ResponseEntity object
	 * 
	 * @exception ResourceNotFoundException thrown if the authorId is not found.
	 * 
	 */
	ResponseEntity<?> delete(int authorId) throws ResourceNotFoundException;
	
	/**
	 * This method update an author object in the database
	 * @param authorId : input parameter of type integer, id of author
	 * @param changedAuthor : input parameter of type author to update the old one
	 * @return : It returns the update author object in JSON format.
	 * 
	 * @exception ResourceNotFoundException thrown if the authorId is not found.
	 */
	Author update(int authorId, Author changedAuthor) throws ResourceNotFoundException;
	
	/**
	 * This method fetches the author using id of author
	 * @param authorId : input parameter of type integer
	 * @return : It returns an object of type author in JSON format.
	 * 
	 * @exception ResourceNotFoundException thrown if the authorId is not found.
	 * 
	 */
	Author read(int authorId);
	
	/**
	 * This method finds all object using author id
	 * @param authorId : input parameter of type integer
	 * @return : It returns all authors with this id
	 * 
	 * @exception ResourceNotFoundException thrown if the authorId is not found.
	 * 
	 */
	List<Author> search(int authorId) throws ResourceNotFoundException;
	
	/**
	 * This method returns all the authors in the author table
	 * @return : return type is List
	 * 
	 * @exception ResourceNotFoundException thrown if the author is not found.
	 * 
	 */
	List<Author> getAllAuthors();
}
