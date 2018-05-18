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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.domain.Loan;
import com.example.demo.services.LoanManagemnetService;

/**
 * 
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-12
 *
 */
@RestController
public class LoanController {

	/**
	 * we use dependency injection(DI) for service objects.
	 * LoanManagemnetService is a service that connects
	 * to the Book table using JpaRepository interface
	 */
	@Autowired
	LoanManagemnetService lms;
	
	/**
	 * fetches loans using a member id
	 * @param memberId : input parameter of type integer
	 * @return : It returns a List of loans
	 */
	@GetMapping("/all")
	public List<Loan> getLoansByMemberId(@PathVariable int memberId)
	{
		return lms.getLoansByMemberId(memberId);
	}
	
	/**
	 * @deprecated createLoan
	 * @since version 1.0
	 * @param memberId : input parameter of type integer
	 * @param bookId : input parameter of type integer
	 * @param loan : input parameter of type Loan
	 * @return : returns a type of Loan object
	 */
	@PostMapping("/members/{memberId}/addLoan")
	public Loan createLoan(@PathVariable(value="memberId")int memberId, @PathVariable(value="bookId")int bookId, @Valid @RequestBody Loan loan)
	{
		System.out.println("from within createLoan");
		return lms.create(memberId, bookId, loan);
	}
	
	// @GetMapping("/loans/{id}/book/{bookId}")
	
	// @PostMapping("/loans/member/{memberId}")
	/**
	 * createLoan1 creates a loan object
	 * @param memberId : input parameter of type integer
	 * @param bookId : input parameter of type integer
	 * @param loan : input parameter of type loan
	 * @return : It returns an object of type Loan
	 */
	@PostMapping("/loans/members/{memberId}/books/{bookId}/addLoan")
	public Loan createLoan1(@PathVariable int memberId, @PathVariable int bookId, @RequestBody Loan loan)
	{
		System.out.println("from within createLoan(Loan loan)");
		return lms.create1(memberId, bookId, loan);
	}
	
	/**
	 * updateLoan performs the update CRUD operation on a loan object in loan table
	 * @param memberId : input parameter of type integer
	 * @param loanId : input parameter of type integer
	 * @param loanRequest : input parameter of type Loan is requested
	 * @return : returns the updated loan object
	 */
	@PutMapping("/members/{memberId}/loans/{loanId}")
	public Loan updateLoan(@PathVariable int memberId, @PathVariable int loanId, @Valid @RequestBody Loan loanRequest)
	{
		
		return lms.update(memberId, loanId, loanRequest);
	}
	
	/**
	 * deletes a loan from the loan table
	 * @param memberId : input parameter of type integer
	 * @param loanId : input parameter of type integer
	 * @return : returns an object of type Loan
	 */
	@DeleteMapping("/members/{memberId}/loans/{loandId}")
	public ResponseEntity<?> deleteLoan(@PathVariable(value="memberId") int memberId, @PathVariable(value="loanId") int loanId)
	{
		return lms.delete(memberId, loanId);
	}
	
	/**
	 * creates a loan object
	 * @param loanId : input parameter of type integer
	 * @param book : input parameter of type Book
	 * @return : returns a Loan object
	 */
	@PostMapping("/members/loans/{loanId}")
	public Loan createLoanByBookId(@PathVariable int loanId, @RequestBody Book book)
	{
		return lms.createLoanByBookId(loanId, book);
	}
}
