<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<HTML><HEAD><TITLE></TITLE></HEAD>
<BODY>		
<center>
<form method=post action= 'insert.bod' >
<table>
<tr>
	<td><h1>글 추가</h1>
	</td>
</tr>
<tr>
	<td>제&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;목
	<input type=input name='title' size=42></td>
</tr>
<tr>
	<td>이&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;름
	<input type=input name='name' size=42></td>
</tr>
<tr>
	<td>비밀번호 <input type=password name='pass' size=42></td>
</tr>
<tr>
	<td colspan=2><textarea rows = 10 cols=50 name='content' ></textarea></td>
</tr>
<tr>
	<td><center>
		<input type=submit value=전송>
		<input type=reset value=취소></center>
	</td>
</tr>
</table>
</form>
<p>
	<a href="list.bod">전체화면</a>&nbsp;&nbsp;&nbsp;
	</center>

</BODY></HTML>











