package com.example.domain;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.domain.interfaces.IBook;

@Entity
public class Book implements IBook {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	private String isbn;
	private String author;
	private int price;
	private String publish_date;
	private GenreEnum genre;
	private String shelf;
	private String country;
	private int loan_fk;
	private int author_fk;
	private int publishe_fk;
	
	@Override
	public String getISBN() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GenreEnum getGenre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPositionInLibrary() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCountry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNumberOfCopies() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Object> getListByAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getListByTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	public Book(int id, String title, String isbn, String author, int price, String publish_date, GenreEnum genre,
			String shelf, String country, int loan_fk, int author_fk, int publishe_fk) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
		this.genre = genre;
		this.shelf = shelf;
		this.country = country;
		this.loan_fk = loan_fk;
		this.author_fk = author_fk;
		this.publishe_fk = publishe_fk;
	}

	public Book() {}

	
}
