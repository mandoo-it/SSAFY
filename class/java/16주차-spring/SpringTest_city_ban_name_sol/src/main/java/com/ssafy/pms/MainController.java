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
	
	@GetMapping("regPhone.do")
	public String reg(){
		return "pms/PhoneReg";
	}
	@PostMapping("savePhone.do")
	public String save(Phone p,Model model){
		try{
			service.insert(p);
			return "Result";
		}catch(RuntimeException e){
			model.addAttribute("msg", "문제 내용 - 저장 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	@GetMapping("searchPhone.do")
	public String search(Model model){
		try{
			List<Phone> list=service.selectAll();
			model.addAttribute("list",list);
			return "pms/PhoneList";
		}catch(RuntimeException e){
			model.addAttribute("msg", "문제 내용 - 목록조회 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	@GetMapping("viewPhone.do")
	public String view(String num,Model model){
		try{
			Phone p=service.selectOne(num);
			model.addAttribute("p",p);
			return "pms/PhoneView";
		}catch(RuntimeException e){
			model.addAttribute("msg", "문제 내용 - 조회 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	@PostMapping("delPhone.do")
	public String del(String[] nums,Model model){
		try{
			service.delete(nums);
			return "redirect:searchPhone.do";
		}catch(RuntimeException e){
			model.addAttribute("msg", "문제 내용 - 삭제 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	@PostMapping("login.do")
	public String login(HttpSession session, String user, String pass, Model model){
		try{
			if(service.loginCheck(user, pass)){
				session.setAttribute("user", user);
			}
			return "redirect:/";
		}catch(RuntimeException e){
			model.addAttribute("msg", "문제 내용 - 로그인 중 오류가 발생했습니다.");
			return "Error";
		}
	}
	@GetMapping("logout.do")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
