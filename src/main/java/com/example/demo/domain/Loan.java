package com.example.demo.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.domain.interfaces.ILoan;

@Entity
public class Loan implements ILoan {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String date_out;
	private String date_due;
	private String date_return;
	
//	@ManyToOne(targetEntity = Book.class)
//	@JoinColumn(name="book_fd")
	@OneToMany
	private List<Book> books;
	
	@ManyToOne(targetEntity = Member.class)
	@JoinColumn(name="members_fk")
	private Member members_fk;
	
//	@ManyToOne(targetEntity = BookCopies.class)
//	@JoinColumn(name="copies_fk")
	@OneToMany
	private List<BookCopies> copies;
	
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

}
