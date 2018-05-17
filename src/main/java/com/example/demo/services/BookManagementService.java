package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.dataaccess.AuthorRepository;
import com.example.demo.dataaccess.BookRepository;
import com.example.demo.dataaccess.PublisherRepository;
import com.example.demo.domain.Author;
import com.example.demo.domain.Book;
import com.example.demo.domain.Publisher;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.IBookManagementService;

@Component
public class BookManagementService implements IBookManagementService {

	@Autowired
	BookRepository bookRep;
	
	@Autowired
	AuthorRepository authorRep;
	
	@Autowired
	PublisherRepository publisherRep;
	
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
	public List<Book> searchById(int bookId) {

		if(!bookRep.existsById(bookId))
		{
			throw new ResourceNotFoundException("bookId" + bookId + "not found");
		}
		
		return bookRep.findAllById(bookId);
	}

	@Override
	public Book create(int authorId, int publisherId, Book book) {
		System.out.println("from within BookManagementService.create method");
		Optional<Author> existingAuthor = authorRep.findById(authorId);
		Optional<Publisher> existingPublisher = publisherRep.findById(publisherId);
		
		book.setAuthor(existingAuthor.get());
		book.setPublishe(existingPublisher.get());
		return bookRep.save(book);
		
	}

	@Override
	public ResponseEntity<?> delete(int bookId) {
		
		return bookRep.findById(bookId).map(book -> {
			bookRep.delete(book);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("bookId" + bookId + "not found"));
	
	}

	@Override
	public List<Book> getAllBooks() {
		
		return bookRep.findAll();
	}

	@Override
	public List<Book> searchByTitle(String title) {
		
		return null;
	}

	@Override
	public List<Book> searchByAuthorName(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Book> sortByTitle()
	{
		//return bookRep.sortAllByTitle();
		return bookRep.findAllByOrderByTitleAsc();
	}
	
}
