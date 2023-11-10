<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html><body><center>	
<h1>글 수정하기 </h1><p>
<img src="resources/images/f2.jpg">
<form method="post" action="update.bod">
	<TABLE BORDER=2 CELLSPACING=2 CELLPADDING = 2>
	 		<TR>
					<TH WIDTH=200>NUM</TH><TD  width=300 align=center>${b.num}</TD>
					<TH WIDTH=300>NAME</TH><TD width=300 align=center >${b.name}</TD>
			</TR> 
			<TR><TH WIDTH=200>DATE</TH><TD width=300 align=center><input type="text" name="wdate" value="${b.num }" hidden></TD>
						<TH WIDTH=300>COUNT</TH><TD width=300 align=center><input type="text" name="count" value="${b.num }"hidden></TD>
			</TR>
			<TR>
						<TH WIDTH=200>TITLE</TH>
						<TD COLSPAN=3><input type="text" name="title" value= "${b.title}"></TD>
			</TR>
			<TR>
						<TH WIDTH=200>CONTENT</TH>
				<TD COLSPAN=3><textarea name="content" cols=120 rows=20 value="${b.num }">${b.content}</textarea></TD>
			</TR> 		
		</TABLE><br>
		<br><a href="list.bod">전체화면</a>&nbsp;&nbsp;&nbsp;	
		<input type="hidden" name="num" value="${b.num }">
		<input type="submit" value="수정하기">
		</center></body></html>
	</table>
</form>

