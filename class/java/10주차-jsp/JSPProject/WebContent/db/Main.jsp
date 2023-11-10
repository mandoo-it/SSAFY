<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<%!String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/scott?"
			+ "serverTimezone=UTC&useUnicode=yes&characterEncoding=UTF-8";
	String user = "scott";
	String password = "tiger";
	String query = "select empid,fname from emp order by empid";%>

<%
	// 1. Driver 등록: 앞으로 사용할 db driver 등록
	Class.forName(driver);
	// args[0]을 넣으면 실행할 때마다 com.~ 주면 생성객체가 매번 달라질수 있음,, new 보다 유동성있음
	// 2. Connection 생성(network)
	Connection con = DriverManager.getConnection(url, user, password);
	// 3. Statement 생성
	Statement stat = con.createStatement();
	// 4. Query 실행
	ResultSet rs = stat.executeQuery(query); // select
%>
<%-- 5.결과처리 --%>
<h1>EMP DATA</h1>
<table border=1>
	<%
		while (rs.next()) {
			String empid = rs.getString(1);
			String fname = rs.getString(2);
	%>
	<tr>
		<td><%=empid%></td>
		<td><a href=Detail.jsp?empid=<%=empid%>><%=fname%></a></td>
	<tr>
		<%
			}
		%>
	
</table>
<%
	// 6. 마무리 
	rs.close();
	stat.close();
	con.close();
%>

