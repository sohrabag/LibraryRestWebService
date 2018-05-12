package com.example.demo.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.domain.interfaces.IAuthor;

@Entity
public class Author implements IAuthor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String name;
	private String dob;
//	
//	@OneToMany(cascade = CascadeType.REMOVE)
//	@JoinColumn(name="book")
//	private List<Book> books;
//	
//	@OneToMany(cascade = CascadeType.REMOVE)
//	@JoinColumn(name="copy")
//	private List<Copies> copies;
//	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDateOfBirth() {
		// TODO Auto-generated method stub
		return null;
	}

	public Author() {
	}

	
}
