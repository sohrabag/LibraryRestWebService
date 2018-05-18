package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	List<Loan> findAllByMemberId(int memberId);
//	@Query("SELECT l.date_due from loan l where l.memeber_id = :id")
//	List<Loan> findAllById(@Param("id") Integer id);
	
}
