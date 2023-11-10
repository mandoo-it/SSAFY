package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.model.Book;
import com.model.BookDAO;
import com.model.IBookDAO;

//FrontController에서 넘어온 요청을 받아 처리(Model1(CustomerDAO)에게 넘겨서 처리)
//Model이 작업한 결과를 받아서 request에 저장시키고 view(jsp)로 넘어감(forward)
public class BookController {
	IBookDAO dao; //인터페이스에 있는 메소드만 이용가능 
	
	public BookController() {
		dao = new BookDAO();
	}
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Book> list = dao.selectAll(); //customer 테이블 안의 모든 데이터 검색
		System.out.println(list.size());
		req.setAttribute("list", list); //jsp에서 꺼내 쓰도록 list 저장 
		
		//jsp로 forward해서 넘어가기 
		RequestDispatcher dis = req.getRequestDispatcher("/view/list.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
				
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
		String isbn = req.getParameter("isbn");
		Book b = dao.selectOne(isbn);
		req.setAttribute("book", b);
		
		RequestDispatcher dis = req.getRequestDispatcher("/view/read.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
