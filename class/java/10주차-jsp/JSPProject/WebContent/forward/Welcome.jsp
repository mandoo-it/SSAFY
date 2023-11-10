<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>어서와</h1>
<h3>hello <%= request.getParameter("id") %> NIM</h3>
<h2>password <%=request.getParameter("pass") %></h2> <!-- id는 paramater로 안써줬는데 쓸 수 있다 -->
<a href = "Login.html">back</a>
</body>
</html>