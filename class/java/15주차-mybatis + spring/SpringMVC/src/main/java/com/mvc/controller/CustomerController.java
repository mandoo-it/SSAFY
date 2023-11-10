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
	
	//exceptionhandler �ΰ� �� 1�� ���� �ȴ�. 
	@ExceptionHandler
	public ModelAndView errorHandle(Exception e) {
		ModelAndView mv = new ModelAndView("error");//������ �� ���̸� ����
		mv.addObject("errMsg", e.getMessage());//������ ����
		return mv;
		
	}
	
	/*
	 * @ExceptionHandler public String errorHandle(Model model, Exception e) {
	 * model.addAttribute("errMsg", e.getMessage()); return "error"; //view �̸�
	 * return �ϴ� ����
	 * 
	 * }
	 */
	
	//@RequestMapping : handerlerMapping�� ���� - > ��� ��Ʈ�ѷ��� ��û�� ó���� �� ����
	//home.mvc�� post������� ��û�� ������ homeController�� ó��
	//@RequestMapping(value = "/home.mvc", method = RequestMethod.GET)
	@GetMapping(value="/list.mvc")
	public String list(Locale locale, Model model) {
		//service = null;
		List<Customer> list = service.selectAll();
		//Model : map������ ������ ���� ��ü(setattribute ���)
		model.addAttribute("list", list);
		return "list"; //���� view �̸��� return
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
//	//@ModelAttribute:�Է�ȭ�鿡�� �޾ƿ� vo��ü�� Model�� �ڵ����� �������� view���� ��� ����
	public String insert2(@ModelAttribute("c") Customer c) {
		//view���� �Է��ϴ� �ʵ���̶� vo�� �ʵ���̶� ���ƾ��Ѵ�. 
		//Customer c = new Customer(num, name, address);
		//�Է� ȭ�鿡�� �� 3�� �޾ƿͼ� db�� insert
		service.insert(c);
		//model.addAttribute("c", c);
		return "insertSuccess";//�Է¼���ȭ�� 
	}
//	
	@GetMapping(value="/delete.mvc")
	public String delete(String num, HttpServletRequest req) {
		String num2 = req.getParameter("num");
		service.delete(num);
		return "redirect:/list.mvc";//���� view name
	}
	
	@GetMapping(value="/login.mvc")
	public String login() {//�α��� ��û
		return "login";
	}
	
	@PostMapping(value="/login.mvc")
	public String loginProcess(String id, HttpSession session) {//����ڰ� �Է��� ���� �޾ƿͼ� ���ǿ� ����
		session.setAttribute("id", id);
		return "redirect:/list.mvc";
	}
	
	@GetMapping(value="/logout.mvc")
	public String logout(HttpSession session) {//�α��� ��û
		session.setAttribute("id", null);
		return "redirect:/list.mvc";
	}
	
	
}
