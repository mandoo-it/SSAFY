package com.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	//@RequestMapping : handerlerMapping의 역할 - > 어느 콘트롤러가 요청을 처리할 지 결정
	//home.mvc로 post방식으로 요청이 들어오면 homeController가 처리
	@RequestMapping(value = "/home.mvc", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//Model : map구조의 데이터 저장 객체(setattribute 대신)
		model.addAttribute("name", "jimmy brown");
		model.addAttribute("city", "seattle");
		return "home"; //논리적 view 이름을 return
	}
	
}
