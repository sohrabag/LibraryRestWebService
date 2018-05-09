package com.example.domain.interfaces;

import com.example.domain.Book;

public interface ICatalog {
	void newBook();
	void delBook();
	Book findBookById(String isbn);
	Book findBookByAuthor(String author);
	Book updateBook(int id, Book changedBook);
}
