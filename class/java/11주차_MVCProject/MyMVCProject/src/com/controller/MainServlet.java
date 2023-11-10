package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.algo.Algo;


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
		
		if(action == null){
			//res.sendRedirect("view/index.jsp");
			RequestDispatcher dis = req.getRequestDispatcher("view/index.jsp"); //초기화면이 여기 action이 없을 때
			dis.forward(req, res);
			return;		
		
		}else if(action.equals("q1")){//1번문제
			//parameter받아오기
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			
			//Algo 문제풀이 객체 생성 후 메소드 호출해서 결과 받기
			Algo a = new Algo(num1, num2);
			int result = a.doJob();
			
			//결과 저장 후 jsp로 forward
			req.setAttribute("result", result);
			RequestDispatcher dis = req.getRequestDispatcher("view/result.jsp"); //ajax요청이라 실제 화면이 바뀌는게 아니라 응답결과만 받느다.
			dis.forward(req, res);
			
		}else if(action.equals("q2")){//2번문제
			//parameter받아오기
			String num1 = req.getParameter("num1");
			String num2 = req.getParameter("num2");
			
			//Algo 문제풀이 객체 생성 후 메소드 호출해서 결과 받기
			Algo a = new Algo(num1, num2);
			int result = a.doJob2();
			
			//결과 저장 후 jsp로 forward
			req.setAttribute("result", result);
			RequestDispatcher dis = req.getRequestDispatcher("view/result.jsp"); //ajax요청이라 실제 화면이 바뀌는게 아니라 응답결과만 받느다.
			dis.forward(req, res);
		}
	}
	
	
	
	
}