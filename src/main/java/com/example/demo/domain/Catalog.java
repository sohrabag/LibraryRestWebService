package com.example.demo.domain;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.domain.interfaces.ICatalog;

public class Catalog implements ICatalog {

	private List<Book> books = new ArrayList<Book>();
	
	@Override
	public void newBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public void delBook() {
		// TODO Auto-generated method stub

	}

	@Override
	public Book findBookById(String isbn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book findBookByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book updateBook(int id, Book changedBook) {
		// TODO Auto-generated method stub
		return null;
	}

}
