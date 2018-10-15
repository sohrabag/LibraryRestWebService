package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class TestController {
	
	@RequestMapping("/")
	public ModelAndView homePage()
	{
		return new ModelAndView("testRestController");
	}
}
