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
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	
	private String dob;
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPhone() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmail() {
		// TODO Auto-generated method stub
		return null;
	}

}
