<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
	<form action="/customer/CookieTest" method="post" id="f">
		아이디:<input type="text" name="id" id="id"><br> 
		패스워드:<input type="password" name="pass" id="pass"><br> 
		
		<input type="reset"	value="취소"> 
		<input type="submit" value="전송">
	</form>
</body>
</html>

