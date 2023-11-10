package com.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
	//장바구니 보기(세션안의 정보 확인), 주문하기(세션삭제 or 세션안의 데이터 삭제)처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=euc-kr");
	  	PrintWriter out = response.getWriter();
	  	
	  	String msg = "";
	  	HttpSession session = request.getSession(false);//세션이 없으면 null, 있으면 return
	  	if(session == null) { //물건을 하나도 안 산 경우
	  		out.println("<center><h1>장바구니에 물건이 하나도 없습니다. </h1>");
	  		out.println("<a href=ShopServlet>초기화면</a></center>");
	  	} else {
	  		//session에 접근하려면 
	  		//session에 저장된 데이터 꺼내기
	  		int[] apple = (int[])session.getAttribute("apple");
			int[] tomato = (int[])session.getAttribute("tomato");
			
			if(request.getParameter("see") != null) {
				msg = "쇼핑백에 사과" + apple[0] +"개 있구 토마토는 " + tomato[0] + "개 있습니다.";
			} else { //주문하기
				msg = "사과" + apple[0] + "개와 토마토" + tomato[0] + "개를 주문했습니다. ";
			}
			out.println("<center><h1>장바구니</h1>");
			out.println(msg + "<hr>");
			out.println("<a href=ShopServlet>초기화면</a></center>");
	  	}
	  	
	}

}
