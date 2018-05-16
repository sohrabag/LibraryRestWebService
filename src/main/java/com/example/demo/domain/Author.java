package com.example.demo.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.domain.interfaces.IAuthor;

@Entity
public class Author implements IAuthor, Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(max=100)
	@Column(unique=true)
	private String name;
	
	@NotNull
	@Size(max=100)
	@Column(unique=true)
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
		
		return this.id;
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public String getDateOfBirth() {
		
		return this.dob;
	}

	public Author() {
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
