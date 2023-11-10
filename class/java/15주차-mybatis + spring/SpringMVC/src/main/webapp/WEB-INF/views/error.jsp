<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>ERROR</title>
</head>
<body>
<center>
<img alt="" src="resources/img/f4.jpg">
<h1>
	예외 발생
</h1>
<h3>${erroMsg}<br>예외발생했습니다.다시 시도해주세요.</h3>
<a href="list.mvc">돌아가기</a>
</center>
</body>
</html>