<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<center>
<c:if test="${empty id}">
	로그인 하세요. <a href="login.mvc">로그인</a>
</c:if>
<c:if test="${not empty id}">
	welcome, ${id} &nbsp<a href="logout.mvc">로그아웃</a>
</c:if>



</center>
</body>
</html>






