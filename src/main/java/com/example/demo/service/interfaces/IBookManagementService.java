package com.example.demo.service.interfaces;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.domain.Book;

public interface IBookManagementService {
	Book create(@Valid Book book);
	void delete(int bookId);
	Book update(int bookId, Book changedBook);
	Book read(int bookId);
	Book search(int bookId);
}
