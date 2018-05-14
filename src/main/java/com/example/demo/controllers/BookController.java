package com.example.demo.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.Book;
import com.example.demo.services.BookManagementService;

@RestController
public class BookController {
	private BookManagementService bms;
	
	@GetMapping("/members/books/{id}")
	public List<Book> getBooksById()
	{
		return null;
	}
}
