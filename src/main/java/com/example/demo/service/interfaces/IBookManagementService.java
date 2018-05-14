package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Book;

public interface IBookManagementService {
	Book create(Book book);
	ResponseEntity<?> delete(int bookId);
	Book update(int bookId, Book changedBook);
	Book read(int bookId);
	boolean search(int bookId);
	List<Book> getAllBooks();
}
