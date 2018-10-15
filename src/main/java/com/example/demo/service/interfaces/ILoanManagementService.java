package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Book;
import com.example.demo.domain.Loan;
import com.example.demo.jpa.exception.ResourceNotFoundException;

/**
 * ILoanManagementService interface manages all CRUD operations for loan object
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-12
 *
 */
public interface ILoanManagementService {
	
	/**
	 * @deprecated
	 * @since version 1.0
	 * @param memberId : input parameter of type integer
	 * @param bookId : input parameter of type integer
	 * @param loan : input parameter of type Loan
	 * @return : returns a Loan object
	 */
	Loan create( int memberId, int bookId, Loan loan);
	
	/**
	 * create1 a Loan object
	 * @param memberId : input parameter of member object with ManyToOne relationship
	 * @param bookId : input parameter of book object with ManyToOne relationship
	 * @param loan : input parameter identifies the loan object to create.
	 * @return : It returns the loan object
	 */
	Loan create1(int memberId, int bookId, Loan loan);
	
	/**
	 * delete a loan from loan table
	 * @param memberId : input parameter of type integer
	 * @param loanId : input parameter of type integer
	 * @return : returns ResponseEntity object
	 * 
	 * @exception ResourceNotFoundException thrown if the loan is not found.
	 */
	ResponseEntity<?> delete(int memberId, int loanId) throws ResourceNotFoundException;
	
	/**
	 * update a loan object in database
	 * @param memberId : input parameter of type integer
	 * @param loanId : input parameter of type integer
	 * @param changedLoan : input parameter of type loan to replace the old object
	 * @return : It returns update Loan object
	 * 
	 * @exception ResourceNotFoundException thrown if the loan is not found.
	 */
	Loan update( int loanId, Loan changedLoan) throws ResourceNotFoundException;
	
	/**
	 * fetches a loan object using loan id
	 * @param loanId : input parameter of type integer
	 * @return : returns a Loan object
	 * 
	 * @exception ResourceNotFoundException thrown if the loan is not found.
	 */
	Loan read(int loanId) throws ResourceNotFoundException;
	
	/**
	 * fetches the loan object using id of loan
	 * @param loanId : input parameter of type integer
	 * @return : It returns the found loan object
	 * 
	 ** @exception ResourceNotFoundException thrown if the loan is not found.
	 */
	List<Loan> search(int loanId) throws ResourceNotFoundException ;
	
	/**
	 * fetches all the loan objects in the loan table
	 * @return : It is of type List
	 */
	List<Loan> findAll();
	
	/**
	 * fetches a loan object using provided member id
	 * @param memberId : input parameter of type integer
	 * @return : It is of type List of loans
	 * 
	 * @exception ResourceNotFoundException thrown if the loan is not found.
	 */
	List<Loan> getLoansByMemberId(int memberId) throws ResourceNotFoundException;
	
	/**
	 * fetches all the loans for a given book and if it is more than 
	 * number of copies in the library, it would give some warning
	 * this book is unavailable
	 * @param bookId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	List<Loan> getLoansByBookId(int bookId) throws ResourceNotFoundException;
	
	/**
	 * creates a loan for a book using id of the book
	 * @param loanId : input parameter of type integer for the loan
	 * @param book : input parameter of type Book
	 * @return : it returns a Loan object
	 * 
	 * @exception ResourceNotFoundException thrown if the loan is not found.
	 */
	Loan createLoanByBookId(int loanId, Book book) throws ResourceNotFoundException;
}
