<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>고객 등록 페이지</h1>
<form action="insertProcess.cus" method="post" >
<h1>상품을 등록 해 주세요.</h1>
<table>
<tr><td>고객이름</td><td><input type="text" name="name"></td></tr>
<tr><td>고객 번호</td><td><input type="text" name="num"></td></tr>
<tr><td>주소</td><td><input type="text" name="address"></td></tr>
<tr><td colspan="2"><input type="submit" value="저장">&nbsp;<input type="reset" value="취소"></td></tr>
</table>
</form>
</body>
</html>

