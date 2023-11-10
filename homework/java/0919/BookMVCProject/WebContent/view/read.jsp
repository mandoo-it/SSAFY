<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.model.Book"%>
 <!--  자바코드에서 사용하는 패키지들 import시켜줘야함  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Book</h1>
<%
	//Controller가 보내준 데이터 꺼내기
	Book c = (Book)request.getAttribute("book");
%>
<table border="1">
		<tr>
			<td><%= c.getIsbn() %></td>
			<td><%= c.getTitle() %></td>
			<td><%= c.getPublisher() %></td>
			<td><%= c.getAuthor() %></td>
			<td><%= c.getPrice() %></td>
		</tr>
</table>
<br>
<a href = "list.cus">back</a>&nbsp;&nbsp;&nbsp;
</body>
</html>