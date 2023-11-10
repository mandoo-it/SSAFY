<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>핸드폰 목록</title>
</head>
<body>
<h1>핸드폰 관리 - 목록</h1>
<p/>
<jsp:include page="/loginCheck.jsp"/>
<p/>
<form method="post" action="delPhone.do">
<table>
<tr><td>모델번호</td><td>모델이름</td><td>가격</td><td>제조사명</td><td>삭제</td></tr>
<c:forEach var="c" items="${list}">
<tr>
<td><a href="viewPhone.do?num=${c.num}">${c.num}</a></td>
<td>${c.model}</td>
<td>${c.price}</td>
<td>${c.vcode}</td>
<td><input type="checkbox" name="nums" value="${c.num}"></td>
</tr>
</c:forEach>
</table>
<p/>
<button><a style="text-decoration:none" href="regPhone.do">추가 등록</a></button>&nbsp;
<input type="submit" value="선택항목 삭제">
</form>
</body>
</html>