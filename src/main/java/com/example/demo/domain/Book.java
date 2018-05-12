package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.domain.interfaces.IBook;

@Entity
public class Book implements IBook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String title;
	private String isbn;
	private int price;
	private String publish_date;
	private GenreEnum genre;
	private String shelf;
	private String country;

//	@OneToMany(cascade = CascadeType.REMOVE)
//	@JoinColumn(name="author")
//	private List<Author> authors;
//	
//	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="copy")
//	private List<Copies> copies;
	
	//relationships are here
//	@ManyToOne
//	@JoinColumn(name="loan_fk")
//	private int loan_fk;
//	
//	@ManyToOne
//	@JoinColumn(name="author_fk")
//	private int author_fk;
//	
//	@ManyToOne
//	@JoinColumn(name="publisher_fk")
//	private int publishe_fk;
	
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
	public List<Book> getListByAuthor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getListByTitle() {
		// TODO Auto-generated method stub
		return null;
	}


public Book(int id, String title, String isbn, String author, int price, String publish_date, GenreEnum genre,
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

	
}
