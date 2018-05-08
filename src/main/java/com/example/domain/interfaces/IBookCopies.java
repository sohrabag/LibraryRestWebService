package com.example.domain.interfaces;

public interface IBookCopies {
	int getPrice();
	String getISBN();		//ISBN may be different because of different countries
	String getEdition();
	String getCountry();	//different ISBN because it is from different countries
}
