package com.example.demo.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.domain.interfaces.IAuthor;

@Entity
public class Author implements IAuthor {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(max=100)
	@Size(min=5)
	@Column(unique=true)
	private String name;
	
	@NotNull
	@Size(max=100)
	@Size(min=5)
	@Column(unique=true)
	private String dob;
	
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
	/**
	 * default constructor for Author
	 */
	public Author() {
	}

	/**
	 * The method returns date of birth property of author
	 * @return : It is a String
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * The method sets the date of birth property of author
	 * @param dob : input parameter of type String
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * The method sets the id property of the author
	 * @param id : input parameter of type integer
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * The method sets the name property of the author
	 * @param name : input parameter of type String
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
