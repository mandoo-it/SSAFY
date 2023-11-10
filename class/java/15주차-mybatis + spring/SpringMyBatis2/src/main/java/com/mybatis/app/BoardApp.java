package com.mybatis.app;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.service.BoardService;
import com.mybatis.vo.Board;

public class BoardApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("config/mybatis-db.xml");
		BoardService service = context.getBean("bor", BoardService.class);
		
		
		service.insert(new Board(null, "추가된글1","추가된글",null,"추가된글","추가된글", 0));
		
		
		List<Board> list = service.selectAll();
		for(Board b : list) 
			System.out.println(b.getNum()+"--"+b.getTitle()+"--"+b.getContent()+"--"+b.getCount());
		
		
		System.out.println("----------------insert 후------------------");
		Board bor = service.selectOne("26");
		System.out.println(bor.getNum()+"--"+bor.getTitle()+"--"+bor.getContent()+"--"+bor.getCount());
		
		/*
		 * service.delete("10");
		 * System.out.println("------------------delete 후--------------------"); list =
		 * service.selectAll(); for(Board b : list)
		 * System.out.println(b.getNum()+"--"+b.getTitle()+"--"+b.getContent()+"--"+b.
		 * getCount());
		 */
		
		service.update(new Board("11", null,null,null,"수정","수정된글입니다.",0));
		System.out.println("-------------------update 후-------------------");
		list = service.selectAll();
		for(Board b : list) 
			System.out.println(b.getNum()+"--"+b.getTitle()+"--"+b.getContent()+"--"+b.getCount());
		
		
		System.out.println("------------------제목 : 수정 으로 검색--------------------");
		list = service.findByTitle("수정");
		for(Board b : list) 
			System.out.println(b.getNum()+"--"+b.getTitle()+"--"+b.getContent()+"--"+b.getCount());
		
		
		System.out.println("-----------------이름 : 임선우로 검색 ---------------------");
		list = service.findByName("임선우");
		for(Board b : list) 
			System.out.println(b.getNum()+"--"+b.getTitle()+"--"+b.getContent()+"--"+b.getCount());
		
		System.out.println("---------------------제목에 게시가 들어간 글 검색-----------------");
		list = service.findbyTitle2("게시");
		for(Board b : list) 
			System.out.println(b.getNum()+"--"+b.getTitle()+"--"+b.getContent()+"--"+b.getCount());
		
		String[] nums = {"35", "36","37","38"};
		service.delete2(nums);
		System.out.println("---------------------한꺼번에 삭제 후 -----------------");
		list = service.selectAll();
		for(Board b : list) 
			System.out.println(b.getNum()+"--"+b.getTitle()+"--"+b.getContent()+"--"+b.getCount());
		
	}

}
