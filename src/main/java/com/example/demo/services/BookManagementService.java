package com.example.demo.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dataaccess.BookRepository;
import com.example.demo.domain.Book;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.IBookManagementService;

@Controller
public class BookManagementService implements IBookManagementService {

	@Autowired
	BookRepository bookRep;
	
	@Override
	public Book update(int bookId, Book changedBook) {
		
		if(!bookRep.existsById(bookId))
		{
			throw new ResourceNotFoundException("bookId" + bookId + "not found");
		}
		
		return bookRep.findById(bookId).map(book -> {
			book.setCountry(changedBook.getCountry());
			book.setGenre(changedBook.getGenre());
			book.setIsbn(changedBook.getIsbn());
			book.setPrice(changedBook.getPrice());
			book.setTitle(changedBook.getTitle());
			book.setPublish_date(changedBook.getPublish_date());
			book.setShelf(changedBook.getShelf());
			return bookRep.save(book);
		}).orElseThrow(() -> new ResourceNotFoundException("bookId" + bookId + "not found"));
	}

	@Override
	public Book read(int bookId) {
		
		return bookRep.findById(bookId).orElseThrow(() -> 
									new ResourceNotFoundException("bookId" + bookId + "not found"));
	}

	@Override
	public boolean search(int bookId) {

		return bookRep.existsById(bookId);
	}

	@Override
	public Book create(@Valid @RequestBody Book book) {
		
		return bookRep.save(book);
		
	}

	@Override
	public void delete(int bookId) {
		bookRep.deleteById(bookId);
		
	}

}
