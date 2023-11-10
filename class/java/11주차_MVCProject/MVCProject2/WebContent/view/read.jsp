<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.model.Customer"%>
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
	Customer c = (Customer)request.getAttribute("c");
%>
<table border="1">
		<tr>
			<td><%= c.getNum() %></td>
			<td><%= c.getName() %></td>
			<td><%= c.getAddress() %></td>
		</tr>
</table>
<br>
<a href = "list.cus">back</a>&nbsp;&nbsp;&nbsp;
<a href="delete.cus?num=<%= c.getNum()%>">삭제</a>
</body>
</html>