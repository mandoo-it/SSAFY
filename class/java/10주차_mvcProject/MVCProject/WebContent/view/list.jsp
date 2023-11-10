<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.model.Customer"%>
 <!--  자바코드에서 사용하는 패키지들 import시켜줘야함  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="logincheck.jsp" %>
<h1>Customer 데이터</h1>

<%
	//Controller가 보내준 데이터 꺼내기
	ArrayList<Customer> list = (ArrayList<Customer>)request.getAttribute("list");
%>
<table border="1">
	<%for(Customer c : list) {%>
		<tr>
			<td><%= c.getNum() %></td>
			<td><a href="read.cus?num=<%= c.getNum()%>"><%= c.getName() %></td>
		</tr>
	<%} %>
</table>
<br>
<a href="insert.cus">add new data</a>
</body>
</html>