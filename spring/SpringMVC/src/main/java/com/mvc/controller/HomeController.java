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
	
	//@RequestMapping : handerlerMapping�� ���� - > ��� ��Ʈ�ѷ��� ��û�� ó���� �� ����
	//home.mvc�� post������� ��û�� ������ homeController�� ó��
	@RequestMapping(value = "/home.mvc", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		//Model : map������ ������ ���� ��ü(setattribute ���)
		model.addAttribute("name", "jimmy brown");
		model.addAttribute("city", "seattle");
		return "home"; //���� view �̸��� return
	}
	
}
