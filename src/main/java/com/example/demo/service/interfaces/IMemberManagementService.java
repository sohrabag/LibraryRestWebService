package com.example.demo.service.interfaces;

import java.util.List;

import com.example.demo.domain.Member;

public interface IMemberManagementService {
	Member create(Member member);
	void delete(int IdToDelete);
	Member update(int memberId, Object changedMember);
	Member read(int memberId);
	Member search(int memberId);
	List<Member> findAll();
}
