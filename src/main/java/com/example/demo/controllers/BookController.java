package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dataaccess.BookRepository;
import com.example.demo.domain.Book;
import com.example.demo.services.BookManagementService;

@RestController
public class BookController {
	
	@Autowired
	BookManagementService bms;
	
	@GetMapping("/members/books/findBook/{bookId}")
	public Book getBookById(@PathVariable int bookId)
	{
		return bms.read(bookId);
	}
	
	@PostMapping(value = "/members/author/{authorId}/publisher/{publisherId}/books/addBook")
	public Book create(@PathVariable int authorId, @PathVariable int publisherId, @Valid @RequestBody Book book) {
		if(book == null)
			System.out.println("from within createNewBook");
		return bms.create(authorId, publisherId, book);
	}
	
	/**
	 * 
	 * @param bookId
	 * @param book
	 * @return
	 */
	@PutMapping(value = "/members/books/book/{bookId}")
	public Book updateBook(@PathVariable int bookId, 
							@RequestBody Book book)
	{
		return bms.update(bookId, book);
	}
	
	@DeleteMapping("/members/books/book/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable int bookId)
	{
		return bms.delete(bookId);
	}
	
	/**
	 * 
	 * @param bookId
	 * @return Return List of books
	 */
	@RequestMapping(value = "/members/books/{bookId}")
	public List<Book> search(@RequestParam int bookId)
	{
		return bms.searchById(bookId);
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/members/books/sort")
	public List<Book> sortByTitle()
	{
		return bms.sortByTitle();
	}
}
