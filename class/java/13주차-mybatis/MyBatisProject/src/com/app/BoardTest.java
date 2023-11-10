package com.app;

import java.util.List;

import com.dao.BoardDAO;
import com.dao.IBoard;
import com.domain.Board;



public class BoardTest {

	public static void main(String[] args) {
	     //dao 객체 생성 후 메소드 호출
	    	IBoard dao = new BoardDAO();
	    	List<Board> list = dao.selectAll();
	    	
	    	for(Board c : list) {
	    		System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getTitle());
	    	}
	    
	    	Board b1 = dao.selectOne("2");
	    	System.out.println(b1.getName() + " " + b1.getTitle() + " " + b1.getNum());
	    	//System.out.println(dao.insert(new Board(null,"kkyu", "이수민",null, "게시판엽습", "Dd", 0)));
	    	//dao.update("301", "강남구");
	    	dao.delete("45");
	    
//	    	for(Customer c : list) {
//	    		System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
//	    	}
//	    	System.out.println("--------------------------------------");
//	    	list = dao.findByAddress("seoul");
//	    	for(Customer c : list) {
//	    		System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getAddress());
//	    	}
	    	System.out.println("-----------------");
	    	List<Board> list2 = dao.search("", "9");
	    	
	    	for(Board c : list2) {
	    		System.out.println(c.getNum() + "--" + c.getName() + "--" + c.getTitle());
	    	}

	}

}
