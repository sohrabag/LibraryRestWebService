package com.example.demo.service.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Book;

public interface IBookRepository extends JpaRepository<Book, Integer> {

}
