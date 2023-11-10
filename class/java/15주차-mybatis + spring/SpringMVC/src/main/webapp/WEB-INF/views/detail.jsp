<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
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
<a href="list.mvc">back</a>&nbsp;&nbsp;&nbsp;
<a href="delete.mvc?num=${c.num}">delete</a>
</body>
</html>