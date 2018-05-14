package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Book;
import com.example.demo.domain.Loan;

public interface ILoanManagementService {
	Loan create( int memberId, Loan loan);
	ResponseEntity<?> delete(int memberId, int loanId);
	Loan update(int memberId, int loanId, Loan changedLoan);
	Loan read(int memberId, int loanId);
	Loan search(int loanId);
	List<Loan> findAll();
	List<Loan> getLoansByMemberId(int memberId);
	Loan createLoanByBookId(int loanId, int bookId, Book book);
}
