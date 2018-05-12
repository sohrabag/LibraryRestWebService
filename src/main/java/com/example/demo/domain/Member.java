package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.domain.interfaces.IMember;

@Entity
public class Member implements IMember {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

    @NotNull
    @Size(max = 100)
    @Column(unique = true)
	private String name;
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)    
	private String address;
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
	private String phone;
    
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
	private String email;
	
//	@OneToMany(cascade=CascadeType.REMOVE)
//	@JoinColumn(name="loan")
//	private List<Loan> loans;
	
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
	private String dob;
	
	@Override
	public String getName() {
		
		return this.name;
	}

	@Override
	public String getAddress() {
		
		return this.address;
	}

	@Override
	public String getPhone() {
		
		return this.phone;
	}

	@Override
	public String getEmail() {
		
		return this.email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
