package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.domain.interfaces.IPublisher;

@Entity
public class Publisher implements IPublisher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Size(max=100)
	@Size(min=5)
	@Column(unique=true)
	private String name;
	
	
	public Publisher() {
	}

	@Override
	public int getId() {
		
		return this.id;
	}

	@Override
	public String getName() {
		
		return this.name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
