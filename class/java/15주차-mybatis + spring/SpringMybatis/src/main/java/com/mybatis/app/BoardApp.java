package com.mybatis.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.service.BoardService;
import com.mybatis.vo.Board;

public class BoardApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config/mybatis-db.xml");
		BoardService service = context.getBean("board", BoardService.class); 
	
		List<Board> list = service.selectAll();
		
		
		for(Board b : list) {
			System.out.println(b.getNum() + " "  + b.getName() + " " + b.getTitle());
		}
		System.out.println("-----------------------------------------------------");
		System.out.println(service.selectOne("10").getName());
		System.out.println("-----------------------------------------------------");
		service.insert(new Board(null, "12","dd",null,"Dd","d",0));
		service.delete("50");
		service.update(new Board("10", "12","dd",null,"fdfd","fdfd",1));
		System.out.println("-----------------------------------------------------");
		List<Board> list2 = service.findByTitle2("9");
		for(Board b : list2) {
			System.out.println(b.getNum() + " "  + b.getName() + " " + b.getTitle());
		}
		System.out.println("-----------------------------------------------------");
		service.delete2(new String[] {"15", "16", "17"});	
	}

}
