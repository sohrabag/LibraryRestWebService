package com.example.demo.domain.interfaces;

import java.util.List;

import com.example.demo.domain.Book;
import com.example.demo.domain.GenreEnum;

public interface IBook {
	String getTitle();
	String getGenre();
	String getPositionInLibrary();
	String getCountry();
	int getNumberOfCopies();
	List<Book> getListByAuthor();
	List<Book> getListByTitle();
}