package com.example.demo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Member;
import com.example.demo.domain.SearchData;
import com.example.demo.services.MemberManagementService;

@RestController
public class MemberController {
	/**
	 * Annotation @Autowired spring dependency injection is performed automatically for
	 * MemberManagementService. It manages member table CRUD operation and more...
	 */
	@Autowired
	MemberManagementService mms;
	
	/**
	 * getAllMembers fetches all the members in the member table
	 * @return : returns a List of mebers
	 */
	@GetMapping("/members") //GET
	public List<Member> getAllMembers()
	{
		return mms.findAll();
	}
	
	/**
	 * updateMember updates all the members
	 * @param memberId : input parameter of type integer
	 * @param memberToUpdate : input parameter of type Member
	 * @return : returns a Member object
	 */
	@PutMapping("/members/update/{memberId}")	//PUT
	public Member updateMember(@PathVariable int memberId, @Valid @RequestBody Member memberToUpdate)
	{
		return mms.update(memberId, memberToUpdate);
	}
	
	/**
	 * adds a member to the member table
	 * @param member : input parameter of type Member
	 * @return : returns a Member object
	 */
	@PostMapping("/members/addMember")	//POST
	public Member addMember(@Valid @RequestBody Member member)
	{
		System.out.println("inside post /members/addMember");
		return mms.create(member);
	}

	/**
	 * deleteMember deletes a Member from member table
	 * @param memberId : input parameter of type integer
	 * @return : returns a ResponseEntity object
	 */
	@DeleteMapping("/members/delete/{memberId}") //DELETE
	public ResponseEntity<?> deleteMember(@PathVariable int memberId)
	{
		return mms.delete(memberId);
	}
	
	@GetMapping(value="/members/getRange/{memberId1}/{memberId2}") //    
	public List<Member> findRangeOfMembersById(@PathVariable int memberId1, 
															@PathVariable int memberId2)
	{
		return mms.findMembersByIdRange( memberId1, memberId2);
	}
}
