package com.rest.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mybatis.vo.Customer;


@RestController
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		return "hello rest!";
	}
	
	// pon.xml에 jackson을 설치해서 json형태로 바꿔줘서 return 해준다. 
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public Customer test() {		
		return new Customer("111", "tommy", "seoul");
	}
	
}
