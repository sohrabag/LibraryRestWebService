package com.example.domain.interfaces;

import java.util.List;

import com.example.domain.GenreEnum;

public interface IBook {
	String getISBN();
	String getTitle();
	GenreEnum getGenre();
	String getPositionInLibrary();
	String getCountry();
	int getNumberOfCopies();
	List<Object> getListByAuthor();
	List<Object> getListByTitle();
}
