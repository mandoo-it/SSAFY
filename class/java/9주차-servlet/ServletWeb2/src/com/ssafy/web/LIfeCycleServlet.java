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
@WebServlet("/life.do")
public class LIfeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LIfeCycleServlet() throws ServletException{
        super.init();
        System.out.println("init()");//서블렛을 만들 때 특정 초기값이 필요하면 여기서 멤버변수등을 초기화한다.
        // TODO Auto-generated constructor stub
    }
    private void deystroy() {
		// TODO Auto-generated method stub
    	super.destroy();
    	System.out.println("destroy()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet()");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='utf-8'>");
		out.print("<title>LIfeCycleServlet</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>hello word</h1>");
		Calendar today = Calendar.getInstance();
		out.print(today.get(Calendar.HOUR));

		out.print("<title>HelloServlet</title>");
		out.print("</body>");
		out.print("</html>");
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
