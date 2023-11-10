<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
			$(".preview").mouseover(function(){
				var id = $(this).attr('id');
				$.ajax({
					url:'mouse.bod?num='+id,
					success:function(result){
						$('#preview').css("visibility","visible");
						$('#preview').html("<h1>"+result+"</h1>");
					}
					
				});
			
			$(".preview").mouseleave(function(){
				$('#preview').css("visibility","hidden");
			});
		});
	});
</script>
<body>
<center>
		<h1>JSP 게시판</h1>
		<br>
		<div id="preview" style="visibility: hidden;"><h3>123</h3></div>
		<TABLE BORDER=1 CELLSPACING=1 CELLPADDING = 1><TR>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>번호</th>
		<th width=200 bgcolor=#113366><font color=#ffffee size=2>제목</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>글쓴이</th>
		<th width=150 bgcolor=#113366><font color=#ffffee size=2>날짜</th>
		<th width=100 bgcolor=#113366><font color=#ffffee size=2>조회수</th>

	  <c:forEach items="${list}" var="b">
	    <tr bgcolor=pink>
			<td align=center bgcolor=pink>&nbsp;<font size=2>${b.num}</td>
	      	<td align=center bgcolor=pink class="preview" id="${b.num}">&nbsp;<font size=2><a href="read.bod?num=${b.num}">${b.title}</a></td>
	      	<td align=center bgcolor=pink>&nbsp;<font size=2>${b.name}</td>
	     	<td align=center bgcolor=pink>&nbsp;<font size=2>${b.wdate}</td>
	      	<td align=center bgcolor=pink>&nbsp;<font size=2>${b.count}</td>	       
	    </tr>	  
	  </c:forEach>
	   
</table>
<br></br>
<a href=insert.bod>새 글 등록</a>

</body></html>