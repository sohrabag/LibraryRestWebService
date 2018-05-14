package com.example.demo.service.interfaces;

import com.example.demo.domain.Book;

public interface IBookManagementService {
	Book create(Book book);
	void delete(int bookId);
	Book update(int bookId, Book changedBook);
	Book read(int bookId);
	boolean search(int bookId);
}
