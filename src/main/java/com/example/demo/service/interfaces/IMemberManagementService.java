package com.example.demo.service.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.domain.Member;

public interface IMemberManagementService {
	Member create(Member member);
	ResponseEntity<?> delete(int IdToDelete);
	Member update(int memberId, Member MemberRequest);
	Member read(int memberId);
	Member search(int memberId);
	List<Member> findAll();
	Member updateMember(int memberId, Member member);
}
