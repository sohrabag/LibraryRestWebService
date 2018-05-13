package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.domain.Loan;

public interface ILoanManagementService {
	Loan create( Loan loan);
	void delete(int loanId);
	Loan update(int bookId, Object changedBook);
	Loan read(int loanId);
	Loan search(int loanId);
	List<Loan> findAll();
}
