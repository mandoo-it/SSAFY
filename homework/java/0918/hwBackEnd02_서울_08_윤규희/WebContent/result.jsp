<%@page import="com.ssafy.web.Product"%>
<%@page
	import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Product p = (Product)request.getAttribute("data");
	%>
	<h1>상품이 저장되었습니다.</h1>
	<table border="1">
		<tr>
			<td>상품 번호</td><td><%=p.getPid()%></td>
		</tr>
		<tr>
			<td>상품 번호</td><td><%=p.getPname()%></td>
		</tr>
		<tr>
			<td>상품 가격</td><td><%=p.getPrice()%></td>
		</tr>
		<tr>
			<td>상품 소개</td><td><%=p.getDescription()%></td>
		</tr>
		<tr>
			<td>수량</td><td><%=p.getQuantity()%></td>
		</tr>
	</table>
	<a href="main.html">상품 목록</a>
</body>
</html>