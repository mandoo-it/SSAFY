<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html><body><center>	
<h1>게시판 글 등록 성공 </h1><p>

<TABLE BORDER=2 CELLSPACING=2 CELLPADDING = 2>
 		<TR>
				<TH WIDTH=300>NAME</TH><TD width=300 align=center>${board.name}</TD>
		</TR> 
		<TR>
					<TH WIDTH=300>COUNT</TH><TD width=300 align=center>${board.count}</TD>
		</TR>
		<TR>
					<TH WIDTH=200>TITLE</TH>
					<TD COLSPAN=3>${board.title}</TD>
		</TR>
		<TR>
					<TH WIDTH=200>CONTENT</TH>
			<TD COLSPAN=3><textarea readonly cols=120 rows=20>${board.content}</textarea></TD>
		</TR> 		
	</TABLE><br>
	<br><a href="list.bod">전체화면</a>&nbsp;&nbsp;&nbsp;	
	</center></body></html>
</table>
