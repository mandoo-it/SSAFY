package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDAO;
import com.dao.ICustomer;
import com.domain.Customer;


public class MainServlet extends HttpServlet {	
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		process(req, res);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
		req.setCharacterEncoding("utf-8");		
		String action = req.getParameter("action");		
		//dao 객체 생성
		ICustomer dao = new CustomerDAO();
		if(action == null){//초기요청	
			//dao에 db 작업 지시 후 결과 받기
			List<Customer> list = dao.selectAll();
			//req에 데이터 저장
			req.setAttribute("list", list);
			RequestDispatcher dis = req.getRequestDispatcher("view/index.jsp");
			dis.forward(req, res);	
		}else if(action.equals("read")){//detail
			Customer c = dao.selectOne(req.getParameter("num"));
			req.setAttribute("customer", c);
			RequestDispatcher dis = req.getRequestDispatcher("view/detail.jsp");
			dis.forward(req, res);
	
		}else if(action.equals("insertForm")){//새 데이터 입력화면
			
		}else if(action.equals("insertProcess")){//db에 insert하기
			
		}else if(action.equals("updateForm")) {//수정 전 원래 데이터 보여주는 화면. 상세화면에 링크 표시
			String num = req.getParameter("num");
            Customer c = dao.selectOne(num);
            req.setAttribute("customer", c);
            
            RequestDispatcher dis = req.getRequestDispatcher("view/update.jsp");
            dis.forward(req, res);
			
		}else if(action.equals("updateProcess")){//
			String num = req.getParameter("num");
			String address = req.getParameter("address");
			dao.update(num, address);
		}else if(action.equals("delete")){
			
		}else if(action.equals("findByAddress")){
			
		}else if(action.equals("loginForm")) {
			RequestDispatcher dis = req.getRequestDispatcher("view/loginForm.jsp");
			dis.forward(req, res);
		}else if(action.equals("loginProcess")) {
			HttpSession session = req.getSession();
			session.setAttribute("id", req.getParameter("id"));
			res.sendRedirect("main.do");
		}else if(action.equals("logout")) {
			HttpSession session = req.getSession();
			session.setAttribute("id", null);
		}
	}
	
	
	
	
}