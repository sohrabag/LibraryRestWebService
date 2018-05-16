package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Author;
import com.example.demo.domain.Loan;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
	List<Author> findAllById(int authorId);
}
