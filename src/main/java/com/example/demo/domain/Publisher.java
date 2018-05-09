package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.demo.domain.interfaces.IPublisher;

@Entity
public class Publisher implements IPublisher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	public Publisher() {
	}

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

}
