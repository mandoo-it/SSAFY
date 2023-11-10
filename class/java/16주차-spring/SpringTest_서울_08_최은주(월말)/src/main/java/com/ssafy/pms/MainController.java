package com.ssafy.pms;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

	@Autowired
	IPhoneService service;

	@GetMapping("/index.do")
	public String index() {
		return "index";
	}

	@GetMapping("/regPhone.do")
	public String regPhone() {
		return "pms/PhoneReg";
	}

	@PostMapping("/savePhone.do")
	public String savePhone(Phone p) {
		service.insert(p);
		return "pms/Result";
	}

	@PostMapping("/delPhone.do")
	public String delPhone(String[] nums) {
		service.delete(nums);
		return "redirect:searchPhone.do";
	}

	@GetMapping("/searchPhone.do")
	public String searchPhone(Model model) {
		List<Phone> list = service.selectAll();
		model.addAttribute("list", list);
		System.out.println(list);
		return "pms/PhoneList";
	}

	@GetMapping("/detailPhone.do")
	public String detailPhone(Model model, String num) {
		System.out.println(num);
		Phone p = service.selectOne(num);
		model.addAttribute("p", p);
		System.out.println(p);
		return "pms/PhoneView";
	}

	@PostMapping("/login.do")
	public String login(HttpSession session, String user, String pass) {
		User u = service.login(user);
		if (u.getPw().equals(pass))
			session.setAttribute("id", user);
		return "redirect:index.do";
	}

	@GetMapping("/logout.do")
	public String logout(HttpSession session) {

		session.invalidate();
		return "redirect:index.do";
	}

}
