package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;

import com.model.Customer;
import com.model.CustomerDAO;
import com.model.ICustomerDAO;

//FrontController에서 넘어온 요청을 받아 처리(Model1(CustomerDAO)에게 넘겨서 처리)
//Model이 작업한 결과를 받아서 request에 저장시키고 view(jsp)로 넘어감(forward)
public class CustomerController {
	ICustomerDAO dao; //인터페이스에 있는 메소드만 이용가능 
	
	public CustomerController() {
		dao = new CustomerDAO();
	}
	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Customer> list = dao.selectAll(); //customer 테이블 안의 모든 데이터 검색
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
		String num = req.getParameter("num");
		Customer c = dao.selectOne(num);
		req.setAttribute("c", c);
		
		RequestDispatcher dis = req.getRequestDispatcher("/view/read.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void insert(HttpServletRequest req, HttpServletResponse res) {
		HttpSession session = req.getSession();
		String login = (String)session.getAttribute("login");
		if(login != null) { //login 한 경우
			
		} else {
			RequestDispatcher dis = req.getRequestDispatcher("/view/login.jsp");
			try {
				dis.forward(req, res);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void insertProcess(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		String name = req.getParameter("name");
		String address = req.getParameter("address");
		
		Customer c = new Customer(num,name,address);
		req.setAttribute("c", c);
		dao.insert(c);
		RequestDispatcher dis = req.getRequestDispatcher("/view/insertSuccess.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	public void delete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String num = req.getParameter("num");
		dao.delete(num);
		
		//초기화면으로 가기
		try {
			res.sendRedirect("list.cus");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void login(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		RequestDispatcher dis = req.getRequestDispatcher("/view/login.jsp");
		try {
			dis.forward(req, res);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void loginProcess(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		//사용자가 입력한 id,pass 받아와서 체크하기
		String id = req.getParameter("id");
		HttpSession session = req.getSession();
		session.setAttribute("login", id);
		
		try {
			res.sendRedirect("list.cus");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void logout(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		session.setAttribute("login", null);
		
		try {
			res.sendRedirect("list.cus");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
