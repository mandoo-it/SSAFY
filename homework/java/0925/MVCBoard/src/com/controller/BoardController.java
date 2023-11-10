package com.controller;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BoardDAO;
import com.dao.IBoardDAO;
import com.vo.Board;

//Front Controller에서 넘어온 요청을 받아 처리(Model에게 넘겨서 처리)
//Model이 작업한 결과를 받아서 request에 저장시키고 view(jsp)로 넘어감(forward)

public class BoardController {
	IBoardDAO dao; // 인터페이스안에 있는 메소드만 호출 가능

	public BoardController() {
		dao = new BoardDAO();
	}

	public void list(HttpServletRequest req, HttpServletResponse res) {
		ArrayList<Board> list = dao.selectAll(); // customer 테이블 안에 모든 데이터 검색

		req.setAttribute("list", list);//jsp에서 꺼내 쓰도록 list 저장
		//jsp로 forward 해서 넘어가기
		
		RequestDispatcher dis = req.getRequestDispatcher("/view/list.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void read(HttpServletRequest req, HttpServletResponse res) {
		String num = req.getParameter("num");
		dao.increaseCount(num);
		Board b = dao.selectOne(num);
		req.setAttribute("board", b);
		
		RequestDispatcher dis = req.getRequestDispatcher("/view/read.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e){
			e.printStackTrace();
		}		
	}

	public void insert(HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher dis = req.getRequestDispatcher("/view/insertForm.jsp");
		try {
			dis.forward(req, res);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void insertProcess(HttpServletRequest req, HttpServletResponse res) {
		String title = req.getParameter("title");
		String name = req.getParameter("name");
		String pass = req.getParameter("pass");
		String content = req.getParameter("content");
		//Calendar c = Calendar.getInstance();
		//new Board(num1,null,name,wdate,title,content,count);
		Board b = new Board(null, pass, name, null, title, content, 0);
		dao.insert(b);
		req.setAttribute("board", b);
		RequestDispatcher dis = req.getRequestDispatcher("/view/listSuccess.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	}

	public void delete(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	public void login(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	public void loginProcess(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	public void logout(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		
	}

	public void mouse(HttpServletRequest req, HttpServletResponse res) {
		// TODO Auto-generated method stub
		String num = req.getParameter("num");
		
		Board b= dao.selectOne(num);
		res.setCharacterEncoding("utf-8");
		req.setAttribute("mouse", b.getContent());
		RequestDispatcher dis = req.getRequestDispatcher("/view/mouse.jsp");
		try {
			dis.forward(req, res);
		} catch (Exception e) {
		}
	}

	
}


















