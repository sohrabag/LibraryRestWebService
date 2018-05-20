package com.example.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.example.demo.domain.interfaces.IBookCopies;
import com.sun.istack.internal.NotNull;

@Entity
public class Copies implements IBookCopies {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String country;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String edition;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String isbn;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private int price;
//	
//	@ManyToOne
//	@JoinColumn(name="book_fk")
//	private Integer book_fk;
//	
//	//relationships are here
//	@ManyToOne
//	@JoinColumn(name="loan_fk")
//	private Integer loan;
//	
//	@ManyToOne
//	@JoinColumn(name="author_fk")
//	private Integer author;
//	
//	@ManyToOne
//	@JoinColumn(name="publisher_fk")
//	private Integer publishe_fk;
//	
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

	public Copies(int id, String country, String edition, String isbn, int price) {
		super();
		this.id = id;
		this.country = country;
		this.edition = edition;
		this.isbn = isbn;
		this.price = price;
	}

	public Copies() {}
	
}
