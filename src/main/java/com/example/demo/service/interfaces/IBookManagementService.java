package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Book;

public interface IBookManagementService {
	Book create(int authorId, int publisherId, Book book);
	ResponseEntity<?> delete(int bookId);
	Book update(int bookId, Book changedBook);
	Book read(int bookId);
	List<Book> searchById(int bookId);
	List<Book> searchByTitle(String title);
	List<Book> searchByAuthorName(String authorName);
	List<Book> getAllBooks();
}
