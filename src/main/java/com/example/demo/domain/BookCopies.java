package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.domain.interfaces.IBookCopies;

@Entity
public class BookCopies implements IBookCopies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String country;
	private String edition;
	private String isbn;
	private int price;
	
	@Override
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getISBN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEdition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	public BookCopies(int id, String country, String edition, String isbn, int price) {
		super();
		this.id = id;
		this.country = country;
		this.edition = edition;
		this.isbn = isbn;
		this.price = price;
	}

	public BookCopies() {}
	
}
