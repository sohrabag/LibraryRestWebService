package com.example.service.interfaces;

public interface IBookManagementService {
	void create();
	void delete();
	Object update(int bookId, Object changedBook);
	Object read(int bookId);
	Object search(int bookId);
}
