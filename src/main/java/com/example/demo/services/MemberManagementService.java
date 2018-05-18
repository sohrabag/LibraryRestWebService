package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dataaccess.LoanRepository;
import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Loan;
import com.example.demo.domain.Member;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.IMemberManagementService;

@Component
public class MemberManagementService implements IMemberManagementService {
	
	@Autowired
	MemberRepository memberRep;
	
	@Autowired
	LoanRepository loanRep;

	@Override
	public Member update(int memberId, Member memberRequest) {
		
		return memberRep.findById(memberId).map(mem -> {
			mem.setName(memberRequest.getName());
			mem.setAddress(memberRequest.getAddress());
			mem.setPhone(memberRequest.getPhone());
			mem.setEmail(memberRequest.getEmail());
			return memberRep.save(mem);
		}).orElseThrow(() -> new ResourceNotFoundException("memberId" + memberId + "not found"));
	}

	@Override
	public Member read(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member search(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member create(Member member) {
		return memberRep.save(member);
		
	}

	@Override
	public ResponseEntity<?> delete(int IdToDelete) {
		
		return memberRep.findById(IdToDelete).map(mem -> {
			memberRep.delete(mem);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("IdToDelete" + IdToDelete + "not found"));
	}

	@Override
	public List<Member> findAll() {
		
		return memberRep.findAll();
	}

	@Override
	public Member updateMember(int memberId, Member member) {
		
		return null;
	}
	
	/**
	 * fetches all the loans for a member using member id
	 * @param memberId : input parameter type of integer
	 * @return : returns List of type Loan
	 */
	@RequestMapping(value = "/members/laons/all")
	public List<Loan> findLoanByMemberId(int memberId)
	{
		
		return null;
	}
	
}
