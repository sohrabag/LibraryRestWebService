package com.example.demo.domain;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import com.example.demo.domain.interfaces.IBook;

@Entity
public class Book implements IBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String title;
	private String isbn;
	private int price;
	private String publish_date;
	private GenreEnum genre;
	private String shelf;
	private String country;
	
	//relationships are here
	@ManyToOne(targetEntity = Loan.class)
	@JoinColumn(name="loan_fk")
	private Loan loan;
	
	@ManyToOne(targetEntity = Author.class)
	@JoinColumn(name="author_fk")
	private Author author;
	
	@ManyToOne(targetEntity = Publisher.class)
	@JoinColumn(name="publisher_fk")
	private Publisher publishe_fk;
	
	@Override
	public String getISBN() {
		// TODO Auto-generated method stub
		return null;
	}

	//methods starts here
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



	public Book(int id, String title, String isbn, int price, String publish_date, GenreEnum genre, String shelf,
			String country, Loan loan, Author author, Publisher publishe_fk) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.publish_date = publish_date;
		this.genre = genre;
		this.shelf = shelf;
		this.country = country;
		this.loan = loan;
		this.author = author;
		this.publishe_fk = publishe_fk;
	}

	public Book() {}

	
}
