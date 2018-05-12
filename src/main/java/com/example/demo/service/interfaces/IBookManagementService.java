package com.example.demo.service.interfaces;

import com.example.demo.domain.Book;

public interface IBookManagementService {
	void create();
	void delete();
	Book update(int bookId, Object changedBook);
	Book read(int bookId);
	Book search(int bookId);
}
