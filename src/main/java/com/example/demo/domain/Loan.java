package com.example.demo.domain;

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

import com.example.demo.domain.interfaces.ILoan;
import com.sun.istack.internal.NotNull;

@Entity
public class Loan implements ILoan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String date_out;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String date_due;
	@NotNull
	@Size(min=5)
	@Size(max=100)
	@Column(unique=true)
	private String date_return;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="book_id",nullable=false)
	private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="member_id",nullable=false)
	private Member member;

	@Override
	public int getId() {
		
		return this.id;
	}

	@Override
	public String getDateOut() {
		
		return this.date_out;
	}

	@Override
	public String getDateDue() {
		
		return this.date_due;
	}

	@Override
	public String getDate_return() {
		
		return date_return;
	}

	public String getDate_out() {
		return date_out;
	}

	public void setDate_out(String date_out) {
		this.date_out = date_out;
	}

	public String getDate_due() {
		return date_due;
	}

	public void setDate_due(String date_due) {
		this.date_due = date_due;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDate_return(String date_return) {
		this.date_return = date_return;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
