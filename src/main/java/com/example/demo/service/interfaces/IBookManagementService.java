package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Book;
import com.example.demo.jpa.exception.ResourceNotFoundException;

/**
 * 
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-12
 *
 */
public interface IBookManagementService {
	/**
	 *  This method creates a Book in the book table
	 * @param authorId : input parameter for id of author
	 * @param publisherId : input parameter for id of publisher
	 * @param book : input parameter for Book object to be created
	 * @return : It returns a Book object in JSON format
	 */
	Book create(int authorId, int publisherId, Book book);
	/**
	 * 
	 * @param bookId  : input parameter for id of book
	 * @return : It returns ResponseEntity object
	 */
	ResponseEntity<?> delete(int bookId);
	/**
	 This method deletes a Book in the book table
	 * @param bookId : input parameter for id of book
	 * @param changedBook : input parameter book to update original book information in JSON format.
	 * @return : It returns a Book Object in JSON format.
	 * 
	 * @exception ResourceNotFoundException thrown if the bookId is not found.
	 */
	Book update(int bookId, Book changedBook) throws ResourceNotFoundException;
	/**
	 This method updates a Book in the book table
	 * @param bookId : input parameter for id of book
	 * @return : It returns a Book Object in JSON format.
	 * 
	 * @exception ResourceNotFoundException thrown if the book is not found.
	 * 
	 */
	Book read(int bookId);
	/**
	 This method searches for a Book in the book table using book id 
	 * @param bookId : input parameter for id of book
	 * @return : It returns a List of Book Objects in JSON format.
	 * 
	 * @exception ResourceNotFoundException thrown if the bookId is not found.
	 * 
	 */
	List<Book> searchById(int bookId) throws ResourceNotFoundException;
	/**
	  This method searches a Book in the book table using book title 
	 * @param title : title of book object to be searched in the database
	 * @return : It returns a list of Book objects with the given title.
	 * 
	 * @exception ResourceNotFoundException thrown if the title is not found.
	 * 
	 */
	List<Book> searchByTitle(String title) throws ResourceNotFoundException;
	/**
	  This method searches a Book in the book table using book's author 
	 * @param authorName : search all books in book table by author name
	 * @return : It returns a list of Book objects.
	 * 
	 * @exception ResourceNotFoundException thrown if the authorName is not found.
	 * 
	 */
	List<Book> searchByAuthorName(String authorName) throws ResourceNotFoundException;
	/**
	 This method fetches all the books in the book table
	 * @return : It returns all the books in book table
	 * 
	 * @exception ResourceNotFoundException thrown if the book is not found.
	 * 
	 */
	List<Book> getAllBooks();
}
