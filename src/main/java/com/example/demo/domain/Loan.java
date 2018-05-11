package com.example.demo.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.domain.interfaces.ILoan;

@Entity
public class Loan implements ILoan, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	private String date_out;
	private String date_due;
	private String date_return;
	private Integer book_Id;
//	
//	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="book")
//	private List<Book> books;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getBook_Id() {
		return book_Id;
	}

	public void setBook_Id(Integer book_Id) {
		this.book_Id = book_Id;
	}

}
