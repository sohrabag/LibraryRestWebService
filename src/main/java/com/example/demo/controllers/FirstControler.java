package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dataaccess.LoanRepository;
import com.example.demo.dataaccess.MemberRepository;
import com.example.demo.domain.Member;

@RestController
//@RequestMapping("/member")
public class FirstControler {
	
	@Autowired
	LoanRepository loanRep;
	
	@Autowired
	MemberRepository memberRep;
	
	@RequestMapping("/home")
	public ModelAndView firstMethod()
	{
		System.out.println("from within LibraryRest");
//		Date dateAndTime = new Date();
		List<Member> members = new ArrayList<Member>();
		
//		return new ModelAndView("home", "dateAndTime", dateAndTime);
		return new ModelAndView("home","members", members);
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
		
		return memberRep.save(member);
	}
}
