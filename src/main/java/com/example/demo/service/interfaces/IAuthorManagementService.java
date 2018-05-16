package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Author;

public interface IAuthorManagementService {
	Author create(Author author);
	ResponseEntity<?> delete(int authorId);
	Author update(int authorId, Author changedAuthor);
	Author read(int authorId);
	List<Author> search(int authorId);
	List<Author> getAllAuthors();
}
