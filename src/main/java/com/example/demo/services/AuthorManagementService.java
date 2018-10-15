package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.dataaccess.AuthorRepository;
import com.example.demo.domain.Author;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.IAuthorManagementService;

/**
 * AuthorManagementService is a service that manages the Authors 
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-12
 *
 */
@Service
public class AuthorManagementService implements IAuthorManagementService {

	/**
	 * Annotation for spring dependency injection(DI), it injects a author repository object
	 */
	@Autowired
	AuthorRepository authorRep;
	
	@Override
	public Author create(Author author) {
			author.setId(authorRep.findAll().toArray().length + 1);
		return authorRep.save(author);
	}

	@Override
	public ResponseEntity<?> delete(int authorId) throws ResourceNotFoundException{
		if(!authorRep.existsById(authorId))
		{
			throw new ResourceNotFoundException("authorId" + authorId + "not found");
		}
		
		return authorRep.findById(authorId).map(author -> {
			authorRep.delete(author);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("authorId" + authorId + "not found"));

	}

	@Override
	public Author update(int authorId, Author changedAuthor) throws ResourceNotFoundException{
		if(!authorRep.existsById(authorId))
		{
			throw new ResourceNotFoundException("authorId" + authorId + "not found");
		}
		System.out.println("AuthorManagementSystem.update");
		return authorRep.findById(authorId).map(author -> {
			author.setDob(changedAuthor.getDob());
			author.setName(changedAuthor.getName());
			return authorRep.save(author);
		}).orElseThrow(() -> new ResourceNotFoundException("authorId" +  authorId + "not found"));
	}

	@Override
	public Author read(int authorId) throws ResourceNotFoundException{
		if(!authorRep.existsById(authorId))
		{
			throw new ResourceNotFoundException("authorId" + authorId + "not found");
		}
		
		return authorRep.findById(authorId).get();
	}

	@Override
	public List<Author> search(int authorId) throws ResourceNotFoundException{
		if(!authorRep.existsById(authorId))
		{
			throw new ResourceNotFoundException("authorId" + authorId + "not found");
		}
		
		return authorRep.findAllById(authorId);
	}

	@Override
	public List<Author> getAllAuthors() {
		
		return authorRep.findAll();
	}

}
