<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>핸드폰 로그인</title>
</head>
<body>
<c:if test="${empty user}">
  <a href="index.jsp">로그인</a>
</c:if>
<c:if test="${not empty user}">
  ${user} 님 로그인 되었습니다. <a href="logout.do">로그아웃</a>
</c:if>
</body>
</html>