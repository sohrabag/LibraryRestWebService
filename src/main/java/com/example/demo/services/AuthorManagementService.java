package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.example.demo.dataaccess.AuthorRepository;
import com.example.demo.domain.Author;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.IAuthorManagementService;

@Controller
public class AuthorManagementService implements IAuthorManagementService {

	@Autowired
	AuthorRepository authorRep;
	
	@Override
	public Author create(Author author) {
		
		return authorRep.save(author);
	}

	@Override
	public ResponseEntity<?> delete(int authorId) {
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
	public Author update(int authorId, Author changedAuthor) {
		if(!authorRep.existsById(authorId))
		{
			throw new ResourceNotFoundException("authorId" + authorId + "not found");
		}
		
		return authorRep.findById(authorId).map(author -> {
			author.setDob(changedAuthor.getDob());
			author.setName(changedAuthor.getName());
			return authorRep.save(author);
		}).orElseThrow(() -> new ResourceNotFoundException("authorId" +  authorId + "not found"));
	}

	@Override
	public Author read(int authorId) {
		if(!authorRep.existsById(authorId))
		{
			throw new ResourceNotFoundException("authorId" + authorId + "not found");
		}
		
		return authorRep.findById(authorId).get();
	}

	@Override
	public List<Author> search(int authorId) {
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
