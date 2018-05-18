package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Loan;
import com.example.demo.domain.Member;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
	
	/**
	 * fetch all the members
	 * @param member_id : input parameter of type integer
	 * @return : returns a List of Member type
	 */
	List<Member> findByMemberId(Integer member_id);

	/**
	 * fetch loans using member id
	 * @param memberId : input parameter of type integer
	 * @return : returns a List of Loan
	 */
	List<Loan> findAllById(int memberId);
}
