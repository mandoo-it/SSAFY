<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "com.model.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body>
<h1>성공</h1>
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
</body>
</body>
</html>