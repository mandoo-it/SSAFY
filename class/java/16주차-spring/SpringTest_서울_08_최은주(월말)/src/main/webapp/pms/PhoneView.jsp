<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>핸드폰 관리</title>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
  <c:if test="${not empty id}">
	${id} 님 로그인 되었습니다. <a href="logout.do">로그아웃</a>
</c:if>
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰 조회</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <!-- write Form  -->
	  <form method="get" action="index.do">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
			${p.num}
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모 델 명</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
			${p.model}
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">가&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;격</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
			${p.price}
			</td>
		  </tr>
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">제 조 사</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
			${p.vcode}
			</td>
		  </tr>		  
	  </table>

	  <br>
	  
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="submit" value="메인페이지로" /> &nbsp;
			</td>
		  </tr>
	  </table>
	  </td>
	</tr>
</table>  

</body>

</html>