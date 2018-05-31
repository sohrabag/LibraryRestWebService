package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

/**
 * BookManagementService service manages all CRUD books operations
 * @author User
 *
 */
@Component
public class BookManagementService implements IBookManagementService {

	/**
	 * spring dependency injection to inject a spring JPA DATA ACCESS object BookRepository
	 */
	@Autowired
	BookRepository bookRep;
	/**
	 * spring dependency injection to inject a spring JPA DATA ACCESS object AuthorRepository
	 */
	@Autowired
	AuthorRepository authorRep;
	/**
	 * spring dependency injection to inject a spring JPA DATA ACCESS object PublisherRepository
	 */
	@Autowired
	PublisherRepository publisherRep;

	@Override
	public Book update(int bookId, Book changedBook) throws ResourceNotFoundException{
		
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
			book.setAuthor(changedBook.getAuthor());
			book.setPublishe(changedBook.getPublishe());
			return bookRep.save(book);
		}).orElseThrow(() -> new ResourceNotFoundException("bookId" + bookId + "not found"));
	}

	@Override
	public Book read(int bookId) throws ResourceNotFoundException {
		
		return bookRep.findById(bookId).orElseThrow(() -> 
									new ResourceNotFoundException("bookId" + bookId + "not found"));
	}

	@Override
	public List<Book> searchById(int bookId) throws ResourceNotFoundException {

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
		book.setId(bookRep.findAll().toArray().length + 1);
		return bookRep.save(book);
		
	}

	@Override
	public ResponseEntity<?> delete(int bookId) throws ResourceNotFoundException {
		
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
	public List<Book> searchByTitle(String title) throws ResourceNotFoundException{
		
		return bookRep.findByTitle(title);
	}

	@Override
	public List<Book> searchByAuthorName(String authorName) throws ResourceNotFoundException {
		
		return bookRep.findByAuthorName(authorName);
	}
	/**
	 * sorts Books by title
	 * @return returns a List of Books
	 */
	public List<Book> sortByTitle()
	{
		//return bookRep.sortAllByTitle();
		return bookRep.findAllByOrderByTitleAsc();
	}
	
	//this is only to test Ajax theory for searching a book
	public List<Book> searchBooksByLooseMatch(String chars)
	{
		List<Book> returnList = new ArrayList<Book>();
		
		System.out.println("looking for" + chars);
		
		//first fetch all the books from the MySql database
		List<Book> testBooks = getAllBooks();
		
		for(Book next : testBooks)
		{
			if(next.getTitle().toUpperCase().contains(chars.toUpperCase()))
			{
				returnList.add(next);
			}
		}
		
		Collections.sort(returnList, new Comparator<Book>() {
			@Override
			public int compare(Book book1, Book book2)
			{
				return book1.getTitle().compareTo(book2.getTitle());
			}
		});
		return returnList;
	}
	
}
