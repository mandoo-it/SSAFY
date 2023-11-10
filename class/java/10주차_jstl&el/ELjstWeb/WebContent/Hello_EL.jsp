<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%pageContext.setAttribute("name", "페이지스콥");
request.setAttribute("name", "메ㅗ");
%>
리터널 : ${'Literals'}<br>
연산자:${8>3}<br>
내장객체:${header.host}<br>
파라미터:${param}<br>
파라미터:${param.name}<br>
파라미터:${param.age}<br>
파라미터:${param.age}<br>
파라미터:${param.hobby[0]}<br>
파라미터:${param.hobby[0]}<br>
파라미터:${param.hobby[0]}<br>
범위:${name}<br> <!-- getAttribute -->
범위:${requestScope.name}<br>
</body>
</html>