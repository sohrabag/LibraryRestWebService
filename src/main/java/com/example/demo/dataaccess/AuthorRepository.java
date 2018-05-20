package com.example.demo.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Author;
import com.example.demo.domain.Loan;

/**
 * This object is spring JPA Data access to Author table
 * It is possible to add other PQL/SQL Queries to this interface
 * 
 * @author Sohrab Azami Ghadim
 * @version 1.0
 * @since 2018-05-12
 *
 */
public interface AuthorRepository extends JpaRepository<Author, Integer> {
	/**
	 * This method finds all authors using author id
	 * @param authorId : input parameter of type integer, author id
	 * @return : It returns a List of Authors
	 */
	List<Author> findAllById(int authorId);
}
