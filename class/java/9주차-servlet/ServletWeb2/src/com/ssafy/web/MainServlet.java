package com.ssafy.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet({ "/MainServlet", "/main.do" })
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String action = request.getParameter("action");
		System.out.println(action);
//		if(action != null && action.equals("login")) {
//			String user = request.getParameter("user");
//			String pass = request.getParameter("pass");
//			if(user.equals("ssafy") && pass.equals("1111")) {
//				response.sendRedirect("result.html");
//			} else {
//				response.sendRedirect("login.html");
//			}
//		} else if(action != null && action.equals("register")) {
//			String isbn = request.getParameter("isbn");
//			String title = request.getParameter("title");
//			String author = request.getParameter("author");
//			out.print("<DOCTYPE html>");
//			out.print("<html>");
//			out.print("<head>");
//			out.print("<title>Book result</title>");
//			out.print("</head>");
//			out.print("<body>");
//			out.print("<h1>" + title + "</h1>");
//			out.print(isbn + "<br>" + author + "<br>");
//			out.print("</body>");
//			out.print("</html>");
//			
//		}
//	}

}}
