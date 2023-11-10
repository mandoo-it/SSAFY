<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html><body><center>	
<h1>회원 정보 </h1><p>

<TABLE BORDER=2 CELLSPACING=2 CELLPADDING = 2>
 		<TR>
				<TH WIDTH=200>회원 번호</TH><TD  width=300 align=center>${customer.num}</TD>
		</TR> 
		<TR>
				<TH WIDTH=300>이름</TH><TD width=300 align=center>${customer.name}</TD>
		<TR>
				<TH WIDTH=300>주소</TH><TD width=300 align=center>${customer.address}</TD>
		</TR> 
	</TABLE><br>
	<br><a href="main.do">회원 목록</a>&nbsp;&nbsp;&nbsp;	<a href="main.do?action=updateForm&num=${customer.num}">회원 수정</a>
	</center></body></html>
</table>
