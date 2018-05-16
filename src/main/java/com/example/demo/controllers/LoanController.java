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

@RestController
public class LoanController {

	@Autowired
	LoanManagemnetService lms;
	
	
	@GetMapping("/all")
	public List<Loan> getLoansByMemberId(@PathVariable int memberId)
	{
		return lms.getLoansByMemberId(memberId);
	}
	
	@PostMapping("/members/{memberId}/addLoan")
	public Loan createLoan(@PathVariable(value="memberId")int memberId,
							@PathVariable(value="bookId")int bookId,
								@Valid @RequestBody Loan loan)
	{
		System.out.println("from within createLoan");
		return lms.create(memberId, bookId, loan);
	}
	
	// @GetMapping("/loans/{id}/book/{bookId}")
	
	// @PostMapping("/loans/member/{memberId}")
	
	@PostMapping("/loans/members/{memberId}/books/{bookId}/addLoan")
	public Loan createLoan1(@PathVariable int memberId,
								@PathVariable int bookId, @RequestBody Loan loan)
	{
		System.out.println("from within createLoan(Loan loan)");
		return lms.create1(memberId, bookId, loan);
	}
	
	@PutMapping("/members/{memberId}/loans/{loanId}")
	public Loan updateLoan(@PathVariable int memberId,
							@PathVariable int loanId,
							@Valid @RequestBody Loan loanRequest)
	{
		
		return lms.update(memberId, loanId, loanRequest);
	}
	
	@DeleteMapping("/members/{memberId}/loans/{loandId}")
	public ResponseEntity<?> deleteLoan(@PathVariable(value="memberId") int memberId,
												@PathVariable(value="loanId") int loanId)
	{
		return lms.delete(memberId, loanId);
	}
	
	@PostMapping("/members/loans/{loanId}")
	public Loan createLoanByBookId(@PathVariable int loanId, 
									@RequestBody Book book)
	{
		return lms.createLoanByBookId(loanId, book);
	}
}
