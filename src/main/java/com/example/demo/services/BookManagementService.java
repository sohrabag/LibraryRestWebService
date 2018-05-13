package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dataaccess.BookRepository;
import com.example.demo.domain.Book;
import com.example.demo.service.interfaces.IBookManagementService;

@Controller
public class BookManagementService implements IBookManagementService {

	@Autowired
	BookRepository bookRep;
	
	@Override
	public Book update(int bookId, Book changedBook) {
		// TODO Auto-generated method stub
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
	public Book create(@Valid @RequestBody Book book) {
		
		return bookRep.save(book);
		
	}

	@Override
	public void delete(int bookId) {
		// TODO Auto-generated method stub
		
	}

}
