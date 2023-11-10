<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page info="tomcat에 지시할 사항을 적는 부분" %> <!-- 나중에 자바파일에서 주석부분으로 들어간다 -->
<%@ page import="java.util.ArrayList, java.util.Date"%>
<%@ page errorPage="error.jsp" %>
<%-- jsp 주석 : import 속성을 제외한 다른 속성은 두번 이상 사용하면 에러 발생(브라우저 콘솔 창에서 안보인당.)--%> 
<!-- html 주석 (브라우저 콘솔 창에서 보인당.-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>first jsp헤헤</h1>
<%
	int count = 99;
	out.println(count);
%>
</body>
</html>