package com.example.demo.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Member;
import com.example.demo.jpa.exception.ResourceNotFoundException;
import com.example.demo.service.interfaces.IMemberManagementService;

@Controller
public class MemberManagementService implements IMemberManagementService {
	
	@Autowired
	MemberRepository memberRep;

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
	
	
}
