<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>핸드폰 등록</title>
</head>
<body>
<h1>핸드폰 관리 - 등록</h1>
<p/>
<jsp:include page="/loginCheck.jsp"/>
<p/>
<form method="post" action="savePhone.do">
<table>
<tr><td>모델번호</td><td><input type="text" name="num"/></td></tr>
<tr><td>모델이름</td><td><input type="text" name="model"/></td></tr>
<tr><td>모델가격</td><td><input type="text" name="price"/>원</td></tr>
<tr><td>제조사명</td><td><select name="vcode" id="vcode">
						<option value="10">삼성</option>
						<option value="20">엘지</option>
						<option value="30">애플</option>
						</select></td></tr>		  
</table>
<p/>
<input type="submit" value="핸드폰등록" />&nbsp;
<input type="reset" value="취소" />
</form>
</body>
</html>