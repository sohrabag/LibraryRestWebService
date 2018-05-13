package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dataaccess.LoanRepository;
import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Member;
import com.example.demo.services.MemberManagementService;

@RestController
//@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	LoanRepository loanRep;
	
	@Autowired
	MemberManagementService MMS;
	
	@RequestMapping("/home")
	public ModelAndView firstMethod()
	{
		System.out.println("from within LibraryRest");
		List<Member> members = new ArrayList<Member>();
		
		return new ModelAndView("home","members", members);
	}
	
	@RequestMapping("/members") //GET
	public List<Member> getAllMembers()
	{
		return MMS.findAll();
	}
	
//	@RequestMapping("/id/{id}")	//GET
//	public ModelAndView getMember()
//	{
//		System.out.println("from within LibraryRest");
//		Date dateAndTime = new Date();
//		
//		return new ModelAndView("home", "dateAndTime", dateAndTime);
//	}
	
	@PostMapping("/add")	//POST
	public Member addMember(@Valid @RequestBody Member member)
	{
		System.out.println("from within addMember");
		
		return MMS.create(member);
	}

}
