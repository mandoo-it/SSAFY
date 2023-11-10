<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<Script Language ="JavaScript">
			function Del(){
					document.FrmDel.submit() ;
			}

</Script>
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
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>핸드폰 관리 - 핸드폰 등록</b></td>
		  </tr>
	  </table>  
	  <br>
	  
	  <form method="post" action="delPhone.do" name = "FrmDel">
	  <table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
		  <tr>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델번호</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">모델이름</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">가격</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">제조사명</td>
			<td width=100 align=center bgcolor="E6ECDE" height="22">삭제</td>
		  </tr>
		  <c:forEach items="${list}" var="p">
		  <tr>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
			<a href="detailPhone.do?num=${p.num}">${p.num}</a>
			</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">${p.model}
			</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">${p.price}
			</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">${p.vcode}
			</td>
			<td width=490 bgcolor="ffffff" style="padding-left:10">
			<input type="checkbox" name="nums" value="${p.num}">
			</td>
		  </tr>
		  
		  </c:forEach>
	  </table>

	  <br>
	  
		<center>
			<a href = "regPhone.do">추가 등록</a> &nbsp;
			<a href = "JavaScript:Del();">선택 항목 삭제</a> &nbsp;
		</center>
		</form>
</table>  
</body>

</html>