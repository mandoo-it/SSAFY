<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList, com.model.Book"%>
 <!--  자바코드에서 사용하는 패키지들 import시켜줘야함  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Book 데이터</h1>

<%
	//Controller가 보내준 데이터 꺼내기
	ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("list");
%>
<table border="1">
	<%for(Book c : list) {%>
		<tr>
			<td><%= c.getIsbn() %></td>
			<td><a href="read.cus?isbn=<%= c.getIsbn()%>"><%= c.getTitle() %></td>
		</tr>
	<%} %>
</table>
<br>
</body>
</html>