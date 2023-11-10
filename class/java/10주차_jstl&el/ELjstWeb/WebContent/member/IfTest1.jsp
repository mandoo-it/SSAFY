<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <img src="../images/tomcat.png"/> --><!-- url계산하기힘듬 -->
<img src="<c:url value='../image/tomcat.png'/>"/>
<c:url value="/IfTest.jsp" var="ifurl">
	<c:param name="name" value="손오공"/>
	<c:param name="age" value="22"/>	
</c:url>

<form action="${ifurl}" method="post">
User Type : <input type="text" name="user" />
<input type="submit"  value="전송"/>
</form>
</body>
</html>