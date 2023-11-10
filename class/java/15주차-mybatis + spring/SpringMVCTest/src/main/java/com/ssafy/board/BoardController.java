package com.ssafy.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardController {
	@Autowired
	BoardService service;
	
	@GetMapping("/list.bod")
	public String list(Model model) {
		List<Board> list = service.selectAll();
		model.addAttribute("list", list);
		return "list";
	}
	
	@GetMapping("/insert.bod")
	public String insert() {
		return "insert";
	}
	
	@PostMapping("/insert.bod")
	public String insert2(@ModelAttribute("b") Board b) {
		service.insert(b);
		return "insertSuccess";
	}
	
	@GetMapping("/read.bod")
	public String detail(String num, Model model) {
		Board b = service.selectOne(num);
		model.addAttribute("b", b);
		return "read";
	}
	
	@GetMapping("/delete.bod")
	public String delete(String num) {
		System.out.print(num);
		service.delete(num);
		return "redirect:/list.bod";
	}
	
	@GetMapping("/update.bod")
	public String update(String num, Model model) {
		model.addAttribute("b", service.selectOne(num));
		return "update";
	}
	
	@PostMapping("/update.bod")
	public String update2(Board b, Model model) {
		service.update(b);
		model.addAttribute("b", b);
		return "redirect:/list.bod";
	}

}
