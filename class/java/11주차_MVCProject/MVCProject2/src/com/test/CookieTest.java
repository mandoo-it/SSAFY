package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	  throws IOException, ServletException {
		PrintWriter out = response.getWriter();		
		response.setContentType("text/html;charset=KSC5601");
		

		//저장된 쿠키를 모두가져옴
		Cookie[] cookies = request.getCookies();

		if(cookies == null || cookies.length == 0) { //cookie�� ������
			
			return;

		}else{ //cookie가 하나라도 있을때
			
			for(int i=0; i < cookies.length; i++) {			
				String cookieName = cookies[i].getName();				
				String cookieValue = cookies[i].getValue();
				
				out.println(cookieName+":"+cookieValue +"<BR>");
	   }	
		
			out.println("<html><body><center><h2>cookie test</h2></center>");
			out.println("<HR>");		
			out.println("<a href=CookieTest>visit again</a>");//doget으로가니까 저장된 쿠키가 계속 뜸
			out.println("</body></html>");
		}		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	   throws IOException, ServletException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=euc-kr");
	
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//cookie 생성
		Cookie idCookie = new Cookie("login", id);//이름, 값
		idCookie.setMaxAge(60*60*24*365);//cookie를 만들어 보내는데 이정보를 클라이언트에게 얼마동안 저장시킬것인지 설정 = 쿠키 유지시간 설정(초 단위)

		Cookie passCookie = new Cookie("pass", pass);
		passCookie.setMaxAge(-1);//-1은 브라우저를 끄면 사라짐
		
		//응답 객체에 쿠키 추가 res+쿠키
		response.addCookie(idCookie);
		response.addCookie(passCookie);

		out.println("<html><body>");
		out.println("<h1>쿠키의 정보를 저장 했습니다</h1>");
		out.println("<hr><a href=CookieTest>visit again</a>");//자기자신에게 보냄(로그인없이)->get방식으로 보냄
		out.println("</body></html>");   
	}

}





