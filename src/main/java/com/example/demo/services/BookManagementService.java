package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.domain.GenreEnum;
import com.example.demo.service.interfaces.IBookManagementService;
import com.example.demo.service.interfaces.IBookRepository;

public class BookManagementService implements IBookManagementService {

	IBookRepository rep;
	
	@Override
	public void create(String title, String isbn, 
			String author, int price,
			String publish_date, GenreEnum genre,
			String shelf,  String country) {
		
		Book book = new Book();

	}

	@Override
	@RequestMapping(value="/changeBook/{id}")
	public Object update(int bookId, Object changedBook) {
		
		return null;
	}

	@Override
	public Book read(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book search(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int bookId) {
		// TODO Auto-generated method stub
		
	}

}
