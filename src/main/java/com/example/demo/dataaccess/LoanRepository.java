package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Loan;
import com.example.demo.domain.Member;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	List<Member> findByMemberId(Integer member_id);

	List<Loan> findAllById(int memberId);
}
