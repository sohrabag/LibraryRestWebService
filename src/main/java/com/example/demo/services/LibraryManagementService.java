package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.interfaces.ILibraryManagementService;

@Component
public class LibraryManagementService implements ILibraryManagementService {

	@Autowired
	BookManagementService BMS;
	
	@Autowired
	LoanManagemnetService LMS;
	
	@Autowired
	MemberManagementService MMS;
	
	
}
