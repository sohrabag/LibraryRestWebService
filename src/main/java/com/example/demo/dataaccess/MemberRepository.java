package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
	@Query("SELECT m FROM Member m where m.id BETWEEN :id1 AND :id2")
	List<Member> findAllByIdRange(@Param("id1") Integer id1, @Param("id2") Integer id2);
	
//	findReferenceFieldBetween(value1,value2);
}
