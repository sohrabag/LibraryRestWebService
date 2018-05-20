package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import com.example.demo.dataaccess.BookRepository;
import com.example.demo.dataaccess.LoanRepository;
import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Book;
import com.example.demo.domain.Loan;
import com.example.demo.domain.Member;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.ILoanManagementService;

@Component
public class LoanManagemnetService implements ILoanManagementService {
	
	@Autowired
	private LoanRepository loanRep;
	@Autowired
	private MemberRepository memberRep;
	@Autowired
	private BookRepository bookRep;
	
	@Override
	public Loan create1(int memberId, int bookId, Loan loan) {
		Optional<Book> existing = bookRep.findById(bookId);
		Optional<Member> member = memberRep.findById(memberId);
		if(existing.isPresent() && member.isPresent()) {
			Book existingBook = existing.get();
			Member existingMember = member.get();
			loan.setBook(existingBook);
			loan.setMember(existingMember);
		}
		loan.setId(loanRep.findAll().toArray().length + 1);
		return loanRep.save(loan);

	}
	
	@Override
	public Loan create(int memberId, int bookId, Loan loan) {
		System.out.println("LoanManagementService.create method");
		return memberRep.findById(memberId).map( mem -> {
			loan.setMember(mem);
			return loanRep.save(loan);
		}).orElseThrow(() -> new ResourceNotFoundException("memberId" + memberId + "not found"));
	}

	@Override
	public ResponseEntity<?> delete(int memberId, int loanId) throws ResourceNotFoundException{
		
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
	public Loan update( int loanId, Loan changedLoan) throws ResourceNotFoundException{
		
		if(!loanRep.existsById(loanId))
		{
			throw new ResourceAccessException("memberId" + loanId + "not found");
		}
		
		return loanRep.findById(loanId).map(loan -> {
			loan.setDate_due(changedLoan.getDate_due());
			loan.setDate_out(changedLoan.getDate_out());
			loan.setDate_return(changedLoan.getDate_return());
			return loanRep.save(loan);
		}).orElseThrow(() -> new ResourceNotFoundException("loanId" + loanId + "not Found"));
		
	}

	@Override
	public Loan read(int loanId) throws ResourceNotFoundException{
		if(!loanRep.existsById(loanId))
		{
			throw new ResourceNotFoundException("loanId" + loanId + "not found");
		}
		
		return loanRep.findById(loanId).get();
	}

	@Override
	public List<Loan> search(int loanId) {
		
		return loanRep.findLoanById(loanId);
	}

	@Override
	public List<Loan> findAll() {
		
		return loanRep.findAll();
	}

	@Override
	public List<Loan> getLoansByMemberId(int memberId) throws ResourceNotFoundException {
		
		return loanRep.findAllByMemberId(memberId);
	}

	@Override
	public Loan createLoanByBookId(int loanId, Book book) throws ResourceNotFoundException {

		if(!loanRep.existsById(loanId))
		{
			throw new ResourceNotFoundException("loanId" + loanId + "not found");
		}
		
		return loanRep.findById(loanId).map(loan -> {
			loan.setBook(book);
			return loanRep.save(loan);
		}).orElseThrow(() -> new ResourceNotFoundException("loanId" + loanId + "not found"));
	}

	@Override
	public List<Loan> getLoansByBookId(int bookId) throws ResourceNotFoundException {
		if( !bookRep.existsById(bookId))
		{
			throw new  ResourceNotFoundException("bookId" + bookId + "not found");
		}
		return loanRep.findAllByBookId(bookId);
	}
	
	public List<Loan>  getAllByMemberId1(int memberId)
	{
		return loanRep.findAllById(memberId);
	}
}
