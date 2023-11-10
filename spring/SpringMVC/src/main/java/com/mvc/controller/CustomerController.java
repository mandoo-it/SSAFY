package com.mvc.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.service.CustomerService;
import com.mybatis.vo.Customer;

@Controller
public class CustomerController {
	@Autowired
	CustomerService service;
	
	//exceptionhandler 두개 중 1개 쓰면 된다. 
	@ExceptionHandler
	public ModelAndView errorHandle(Exception e) {
		ModelAndView mv = new ModelAndView("error");//생성할 때 뷰이름 지정
		mv.addObject("errMsg", e.getMessage());//데이터 저장
		return mv;
		
	}
	
	/*
	 * @ExceptionHandler public String errorHandle(Model model, Exception e) {
	 * model.addAttribute("errMsg", e.getMessage()); return "error"; //view 이름
	 * return 하는 구조
	 * 
	 * }
	 */
	
	//@RequestMapping : handerlerMapping의 역할 - > 어느 콘트롤러가 요청을 처리할 지 결정
	//home.mvc로 post방식으로 요청이 들어오면 homeController가 처리
	//@RequestMapping(value = "/home.mvc", method = RequestMethod.GET)
	@GetMapping(value="/list.mvc")
	public String list(Locale locale, Model model) {
		//service = null;
		List<Customer> list = service.selectAll();
		//Model : map구조의 데이터 저장 객체(setattribute 대신)
		model.addAttribute("list", list);
		return "list"; //논리적 view 이름을 return
	}
	
	@GetMapping(value="/detail.mvc")
	public String detail(@RequestParam(value="num") String num, Model model) {
		System.out.print(num);
		Customer c = service.selectOne(num);
		System.out.print(c.getNum());
		model.addAttribute("c", c);
		return "detail";
		
	}
	
	@GetMapping(value="/insert.mvc")
	public String insert(HttpSession session) {
		if(session.getAttribute("id") == null)
			return "login";
		else 
			return "insert";
	}
	
	@PostMapping(value="/insert.mvc")
//	//@ModelAttribute:입력화면에서 받아온 vo객체를 Model에 자동으로 저장해줌 view에서 사용 가능
	public String insert2(@ModelAttribute("c") Customer c) {
		//view에서 입력하는 필드명이랑 vo의 필드명이랑 같아야한다. 
		//Customer c = new Customer(num, name, address);
		//입력 화면에서 값 3개 받아와서 db에 insert
		service.insert(c);
		//model.addAttribute("c", c);
		return "insertSuccess";//입력성공화면 
	}
//	
	@GetMapping(value="/delete.mvc")
	public String delete(String num, HttpServletRequest req) {
		String num2 = req.getParameter("num");
		service.delete(num);
		return "redirect:/list.mvc";//논리적 view name
	}
	
	@GetMapping(value="/login.mvc")
	public String login() {//로그인 요청
		return "login";
	}
	
	@PostMapping(value="/login.mvc")
	public String loginProcess(String id, HttpSession session) {//사용자가 입력한 값을 받아와서 세션에 저장
		session.setAttribute("id", id);
		return "redirect:/list.mvc";
	}
	
	@GetMapping(value="/logout.mvc")
	public String logout(HttpSession session) {//로그인 요청
		session.setAttribute("id", null);
		return "redirect:/list.mvc";
	}
	
	
}
