<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<center>
<img src="resources/img/f3.jpg"><br>
<h1>
	Customer detail
</h1>
${c.num }
<table border="1">
	<tr>
		<td>${c.num}</td>
		<td>${c.name}</td>
		<td>${c.address}</td>
	</tr>
</table>
<a href="list.mvc">back</a>
<a href="insert.mvc">insert more</a>
</center>
</body>
</html>