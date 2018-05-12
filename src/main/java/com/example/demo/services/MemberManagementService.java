package com.example.demo.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Member;
import com.example.demo.service.interfaces.IMemberManagementService;

@Controller
public class MemberManagementService implements IMemberManagementService {
	
	@Autowired
	MemberRepository memberRep;

	@Override
	public Member update(int bookId, Object changedBook) {
		// TODO Auto-generated method stub
		return null;
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
	public Member create(@Valid @RequestBody Member member) {
		return memberRep.save(member);
		
	}

	@Override
	public void delete(int IdToDelete) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member> findAll() {
		
		return memberRep.findAll();
	}
	
	
}
