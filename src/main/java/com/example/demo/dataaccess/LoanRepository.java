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
	List<Loan> findLoanById(Integer LoanId);

	/**
	 * fetch loans using member id
	 * @param memberId : input parameter of type integer
	 * @return : returns a List of Loan
	 */
	List<Loan> findAllByMemberId(Integer memberId);

	List<Loan> findAllByBookId(int bookId);
	
@Query("SELECT l FROM Loan l where l.member.id = :id")
List<Loan> findAllById(@Param("id") Integer id);

}
