<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<center>
<img alt="" src="resources/img/f1.jpg">
<jsp:include page="loginCheck.jsp"/>
<h1>
	Customer Data
</h1>
<table border="1">
	<c:forEach items="${list}" var="c">
		<tr>
			<td>${c.num}</td>
			<td><a href ="detail.mvc?num=${c.num}">${c.name}</a></td>
		</tr>
	</c:forEach>
</table>
<a href="insert.mvc">add customer</a>
</center>
</body>
</html>