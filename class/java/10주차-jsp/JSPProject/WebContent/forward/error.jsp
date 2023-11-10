<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--isErrorPage:error 처리 페이지가 반드시 가져야 되는 지시어 속성 내장 객체 중 exception 객체를 사용할 수 있음 --%>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>예외발생</h1>
예외종류 : <%=exception.getClass().getName() %><br>
메세지 : <%= exception.getMessage() %><br>
<hr>
<h3>숫자를 입력해주세요</h3>
</body>
</html>