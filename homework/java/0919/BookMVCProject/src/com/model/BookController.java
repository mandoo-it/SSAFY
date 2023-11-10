package com.model;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Book;
import com.model.BookDAO;
import com.model.IBookDAO;

/**
 * Servlet implementation class BookController
 */
@WebServlet("/BookController")
public class BookController extends HttpServlet {
IBookDAO dao; //인터페이스에 있는 메소드만 이용가능 
	
	public BookController() {
		dao = new BookDAO();
	}
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Book> list = dao.selectAll(); //Book 테이블 안의 모든 데이터 검색
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
		Book c = dao.selectOne(isbn);
		System.out.println(c.getIsbn());
		req.setAttribute("c", c);
		
		RequestDispatcher dis = req.getRequestDispatcher("/view/read.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
