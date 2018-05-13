package com.example.demo.controllers;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dataaccess.LoanRepository;
import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Member;
import com.example.demo.services.MemberManagementService;

@RestController
public class MemberController {
	
	@Autowired
	MemberManagementService mms;
	
//	@RequestMapping("/home")
//	public ModelAndView firstMethod()
//	{
//		System.out.println("from within LibraryRest");
//		List<Member> members = new ArrayList<Member>();
//		
//		return new ModelAndView("home","members", members);
//	}
	
	@GetMapping("/members") //GET
	public List<Member> getAllMembers()
	{
		return mms.findAll();
	}
	
	@PutMapping("/members/{id}")	//GET
	public Member updateMember(@PathVariable int memberId, 
									@Valid @RequestBody Member memberToUpdate)
	{
		System.out.println("from within @PutMapping");
		
		return mms.update(memberId, memberToUpdate);
	}
	
	@PostMapping("/members")	//POST
	public Member addMember(@Valid @RequestBody Member member)
	{
		System.out.println("from within addMember");
		
		return mms.create(member);
	}

	@DeleteMapping("/members/memberId") //DELETE
	public ResponseEntity<?> deleteMember(@PathVariable int memberId)
	{
		return mms.delete(memberId);
	}
}
