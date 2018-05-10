package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.interfaces.ILibraryManagementService;

public class LibraryManagementService implements ILibraryManagementService {

	@Autowired
	BookManagementService BMS;
	
	@Autowired
	LoanManagemnetService LMS;
	
	@Autowired
	MemberManagementService MMS;
	
	
}
