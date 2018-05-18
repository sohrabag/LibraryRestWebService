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

import com.example.demo.domain.Book;
import com.example.demo.services.BookManagementService;

/**
 * 
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-12
 *
 */
@RestController
public class BookController {

	/**
	 * we use dependency injection(DI) for service objects.
	 * BookManagementService is a service that connects
	 * to the Book table using JpaRepository interface
	 */
	@Autowired
	BookManagementService bms;

	/**
	 * Annotation GetMapping identifies this URL as a GET operation of the CRUD operations
	 * read is a CRUD API.
	 * @param bookId : input parameter book id which is of type integer
	 * @return :  It returns an object of type Book. Entire object will be returned as a JSON type
	 */
	@GetMapping("/members/books/findBook/{bookId}")
	public Book getBookById(@PathVariable int bookId)
	{
		return bms.read(bookId);
	}
	
	/**
	 * create API creates a new Book in the Book table
	 * annotation PostMapping marks this method as CRUD operation 
	 * @param authorId : input parameter points to an author in the author table
	 * @param publisherId : input parameter points to a publisher in the publisher table
	 * @param book : input parameter 
	 * @return : It returns an object of type Book in JSON format
	 */
	@PostMapping(value = "/members/author/{authorId}/publisher/{publisherId}/books/addBook")
	public Book create(@PathVariable int authorId, @PathVariable int publisherId, @Valid @RequestBody Book book) {
		if(book == null)
			System.out.println("from within createNewBook");
		return bms.create(authorId, publisherId, book);
	}

	/**
	 * Annotation PutMapping maps HTTP POST requests onto a specific handler method.
	 * This API is an update operation of CRUD operation types.
	 * the URI is in the double quotation marks
	 * @param bookId : input parameter Book id to be update
	 * @param book : input parameter of type Book object which is passed as JSON type
	 * @return : It returns object of type Book in JSON format
	 */
	@PutMapping(value = "/members/books/book/{bookId}")
	public Book updateBook(@PathVariable int bookId, 
							@RequestBody Book book)
	{
		return bms.update(bookId, book);
	}

	/**
	 * Annotation @DeleteMapping maps HTTP DELETE requests onto specific handler methods.
	 * This is an API operation of CRUD operation types.
	 * This operation deletes a Book from the book table.
	 * @param bookId : input parameter identifies the id of the book to be deleted.
	 * @return : It returns ResponseEntity
	 */
	@DeleteMapping("/members/books/book/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable int bookId)
	{
		return bms.delete(bookId);
	}
	
	/**
	 * Annotation @RequestMapping maps web requests onto specific handler methods.
	 * This annotation can be used in class level.
	 * @param bookId : 
	 * @return Return List of books
	 */
	@RequestMapping(value = "/members/books/{bookId}")
	public List<Book> search(@RequestParam int bookId)
	{
		return bms.searchById(bookId);
	}

	/**
	 * Annotation @GetMapping maps web requests onto specific handler methods.
	 * This method is a sorting operations on Books in book table
	 * @return It returns a List of Book objects sorted by book title.
	 */
	@GetMapping(value = "/members/books/sort")
	public List<Book> sortByTitle()
	{
		return bms.sortByTitle();
	}
}
