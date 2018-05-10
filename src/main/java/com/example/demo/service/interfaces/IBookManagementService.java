package com.example.demo.service.interfaces;

import com.example.demo.domain.GenreEnum;

public interface IBookManagementService {
	void create(String title, String isbn, 
				String author, int price,
				String publish_date, GenreEnum genre,
				String shelf, String country
				);
	void delete(int bookId);
	Object update(int bookId, Object changedBook);
	Object read(int bookId);
	Object search(int bookId);
}
