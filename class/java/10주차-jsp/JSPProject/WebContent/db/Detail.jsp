<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>


<%!String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?"
			+ "serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String query = "select empid, fname, hdate, phone, jobid, deptid, email "
			+ "from emp " + "where empid = ?";%>

<%
	// 1. Driver 등록: 앞으로 사용할 db driver 등록
	Class.forName(driver);
	// 2. Connection 생성(network)
	Connection con = DriverManager.getConnection(url, user, password);
	// 3. PreparedStatement 생성
	PreparedStatement pstat = con.prepareStatement(query);
	// 3-1. ?에 값 세팅
	pstat.setString(1, request.getParameter("empid"));
	// 4. Query 실행
	ResultSet rs = pstat.executeQuery(); // select
%>
<%-- 5.결과처리 --%>
<h1>Employee Detail Data</h1>
<table border=1>
	<%
		rs.next();

		String empid = rs.getString(1);
		String fname = rs.getString(2);
		String hdate = rs.getString(3);
		String phone = rs.getString(4);
		String jobid = rs.getString(5);
		String deptid = rs.getString(6);
		String email = rs.getString(7);
	%>

	<tr>
		<th>사 번</th>
		<td><%=empid%></td>
	</tr>
	<tr>
		<th>이 름</th>
		<td><%=fname%></td>
	</tr>
	<tr>
		<th>입 사 일</th>
		<td><%=hdate%></td>
	</tr>
	<tr>
		<th>전화번호</th>
		<td><%=phone%></td>
	</tr>
	<tr>
		<th>업무번호</th>
		<td><%=jobid%></td>
	</tr>
	<tr>
		<th>부서번호</th>
		<td><%=deptid%></td>
	</tr>
	<tr>
		<th>이 메 일</th>
		<td><%=email%></td>
	</tr>

</table>
<br>
<a href=Main.jsp>back</a>
<%
	// 6. 마무리
	rs.close();
	pstat.close();
	con.close();
%>
