package com.db;

import java.io.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//이전 서블릿에서 empid 받아오기 
//테이블에서 해당 사번의 레코드 가져오기 
//가져온 정보를 화면에 출력

@WebServlet("/Detail") // url mapping 값 : 중복시 에러발생함....
//서버에 요청하는 방식
//1. get : url을 직접 입력후 요청할 때.
//........ <a> link를 요청할 때.
//2. post: <form> method= "post"로 요청할 때.
public class Detail extends HttpServlet {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?"
			+ "serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String query = "select empid, fname, hdate, phone, jobid, deptid, email "
			+ "from emp " + "where empid = ?";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8"); // contentType 지정
		PrintWriter out = response.getWriter(); // out 지정
		try {
			// 1. Driver 등록: 앞으로 사용할 db driver 등록
			Class.forName(driver);
			// args[0]을 넣으면 실행할 때마다 com.~ 주면 생성객체가 매번 달라질수 있음,
			// new 보다 유동성있음
			// 2. Connection 생성(network)
			Connection con = DriverManager.getConnection(url, user, password);
			// 3. PreparedStatement 생성
			PreparedStatement pstat = con.prepareStatement(query);
			// 3-1. ?에 값 세팅
			pstat.setString(1, request.getParameter("empid"));
			// 4. Query 실행
			ResultSet rs = pstat.executeQuery(); // select
			// 5.결과처리
			out.println("<h1>Employee Detail Data</h1>");
			out.println("<table border=1>");
			rs.next();

			String empid = rs.getString(1);
			String fname = rs.getString(2);
			String hdate = rs.getString(3);
			String phone = rs.getString(4);
			String jobid = rs.getString(5);
			String deptid = rs.getString(6);
			String email = rs.getString(7);


			out.println("<tr><th>사    번</th><td>" + empid + "</td></tr>"
					    + "<tr><th>이    름</th><td>" + fname + "</td></tr>"
					    + "<tr><th>입 사 일</th><td>" + hdate + "</td></tr>"
					    + "<tr><th>전화번호</th><td>" + phone + "</td></tr>"
					    + "<tr><th>업무번호</th><td>" + jobid + "</td></tr>"
					    + "<tr><th>부서번호</th><td>" + deptid + "</td></tr>"
					    + "<tr><th>이 메 일</th><td>" + email + "</td></tr>");

			out.println("</table>");
			out.println("<br><a href=jdbcServlet>back</a>");
			// 6. 마무리
			rs.close();
			pstat.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}