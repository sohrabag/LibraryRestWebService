package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.demo.domain.interfaces.ILoan;

@Entity
public class Loan implements ILoan, Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String date_out;
	private String date_due;
	private String date_return;
//	private Integer book_Id;
//	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="book_id",nullable=false)
	private Book book;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="member_id",nullable=false)
	private Member member;
	
//	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="copy")
//	private List<Copies> copies;
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDateOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDateDue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDate_return() {
		
		return date_return;
	}

//	public Integer getBook_Id() {
//		return book_Id;
//	}
//
//	public void setBook_Id(Integer book_Id) {
//		this.book_Id = book_Id;
//	}

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
