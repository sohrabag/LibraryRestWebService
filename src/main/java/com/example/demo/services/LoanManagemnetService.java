package com.example.demo.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dataaccess.LoanRepository;
import com.example.demo.domain.Loan;
import com.example.demo.service.interfaces.ILoanManagementService;

public class LoanManagemnetService implements ILoanManagementService {
	private LoanRepository loanRep;

	@Override
	public Loan create(@Valid @RequestBody Loan loan) {
		
		return loanRep.save(loan);
	}

	@Override
	public void delete(int loanId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Loan update(int bookId, Object changedBook) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan read(int loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Loan search(int loanId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Loan> findAll() {
		
		return loanRep.findAll();
	}
	
	
}
