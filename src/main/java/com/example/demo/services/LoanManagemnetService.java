package com.example.demo.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.ResourceAccessException;

import com.example.demo.dataaccess.LoanRepository;
import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Loan;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.ILoanManagementService;

@Controller
public class LoanManagemnetService implements ILoanManagementService {
	
	private LoanRepository loanRep;
	private MemberRepository memberRep;

	@Override
	public Loan create(int memberId, Loan loan) {
		return memberRep.findById(memberId).map( mem -> {
			loan.setMember(mem);
			return loanRep.save(loan);
		}).orElseThrow(() -> new ResourceAccessException("" + memberId + "not found"));
	}

	@Override
	public ResponseEntity<?> delete(int memberId, int loanId) {
		
		if(!memberRep.existsById(memberId))
		{
			throw new ResourceNotFoundException("memberId" + memberId + "not found");
		}
		
		return loanRep.findById(loanId).map(loan -> {
			loanRep.delete(loan);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("loanId" + loanId + "not found"));
	}

	@Override
	public Loan update(int memberId, int loanId, Loan changedLoan) {
		
		if(!memberRep.existsById(memberId))
		{
			throw new ResourceAccessException("memberId" + memberId + "not found");
		}
		
		return loanRep.findById(loanId).map(loan -> {
			loan.setDate_due(changedLoan.getDate_due());
			loan.setDate_out(changedLoan.getDate_out());
			loan.setDate_return(changedLoan.getDate_return());
			return loanRep.save(loan);
		}).orElseThrow(() -> new ResourceNotFoundException("loanId" + memberId + "not Found"));
		
	}

	@Override
	public Loan read(int memberId, int loanId) {
		
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

	@Override
	public List<Loan> getLoansByMemberId(int memberId) {
		
		return loanRep.findAllById(memberId);
	}
	
	
}
