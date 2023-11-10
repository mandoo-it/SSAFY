<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>핸드폰 조회</title>
</head>
<body>
<h1>핸드폰 관리 - 핸드폰 조회</h1>
<p/>
<jsp:include page="/loginCheck.jsp"/>
<p/>
<table>
<tr><td>모델번호:</td><td>${p.num}</td></tr>
<tr><td>모델이름:</td><td>${p.model}</td></tr>
<tr><td>모델가격:</td><td>${p.price}</td></tr>
<tr><td>제조사명:</td><td>${p.vcode}</td></tr>
</table>
<p/>
<a href="searchPhone.do">핸드폰 목록 조회</a>
</body>
</html>