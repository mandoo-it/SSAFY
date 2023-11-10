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
 * Servlet implementation class HelloServlet
 */
@WebServlet("/content.do") //브라우저에서 요청이 오면 서블렛이 처리한다 
public class ContentTypeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/xml");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<customerlist>");
		out.print("<customer>");
		out.print("<name>희망이</name>");
		out.print("<address>서울</address>");
		out.print("<phone>0102245154</phone>");
		out.print("</customer>");
		out.print("</customerlist>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
