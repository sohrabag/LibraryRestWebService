package com.example.demo.controllers;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstControler {
	
	@RequestMapping("/home")
	public ModelAndView firstMethod()
	{
		System.out.println("from within LibraryRest");
		Date dateAndTime = new Date();
		
		return new ModelAndView("home", "dateAndTime", dateAndTime);
	}
	
}
