package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import com.example.demo.domain.interfaces.IBook;
import com.sun.istack.internal.NotNull;

@Entity
public class Book implements IBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String title;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String isbn;
	@NotNull
	private double price;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String publish_date;
	@NotNull
	@Column(unique=true)
	private String genre;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String shelf;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String country;

	
//	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="copy")
//	private List<Copies> copies;
	
//	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="author_id", nullable=false)
	private Author author;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="publisher_id")
	private Publisher publishe;
	

	//methods starts here
	@Override
	public String getTitle() {
		
		return this.title;
	}

	@Override
	public String getGenre() {
		
		return this.genre;
	}

	@Override
	public String getPositionInLibrary() {
		
		return null;
	}

	@Override
	public String getCountry() {
		
		return this.country;
	}

	@Override
	public int getNumberOfCopies() {
		
		return 0;
	}

	@Override
	public List<Book> getListByAuthor() {
		
		return null;
	}

	@Override
	public List<Book> getListByTitle() {
		// TODO Auto-generated method stub
		return null;
	}


public Book(int id, String title, String isbn, String author, double price, String publish_date, String genre,
			String shelf, String country, List<Author> authors, List<Copies> copies, int loan_fk, int author_fk,
			int publishe_fk) {
		super();
		this.id = id;
		this.title = title;
		this.isbn = isbn;
		this.price = price;
		this.publish_date = publish_date;
		this.genre = genre;
		this.shelf = shelf;
		this.country = country;
//		this.authors = authors;
//		this.copies = copies;
//		this.loan_fk = loan_fk;
//		this.author_fk = author_fk;
//		this.publishe_fk = publishe_fk;
	}

	public Book() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(String publish_date) {
		this.publish_date = publish_date;
	}

	public String getShelf() {
		return shelf;
	}

	public void setShelf(String shelf) {
		this.shelf = shelf;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public Publisher getPublishe() {
		return publishe;
	}

	public void setPublishe(Publisher publishe) {
		this.publishe = publishe;
	}

	
}
