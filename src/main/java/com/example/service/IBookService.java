package com.example.service;

public interface IBookService {
	void create();
	void delete();
	Object update(int bookId, Object changedBook);
	Object read(int bookId);
	Object search(int bookId);
}
