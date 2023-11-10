<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1, h4 {
	text-align: center;
}
a {
	margin: 10px;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$('#q1').click(function(){
			//ajax요청 보내기
			$.ajax({//javascript안에서 {}은 json
				url : 'main.do?action=q1',
				data : {//client에서 서버로 보낼 데이터
					num1 : $('#num1').val(), //시험에서 구멍 뚜림
					num2 : $('#num2').val() //시험에서 구멍 뚜림
				},
				success : function(result, status, xhr) { //파라미터로 result만 받아도 된다. 
					//서버에서 성공적으로 응답이 도착 했을 때(callback 메소드)		
					$('#display').html(result); //시험에서 구멍 뚜림 (값을 뿌려할 부분이 span이거나 div면 .html(result) 이고 값을 뿌려야할 부분이 input type text이면 .val(result)이다. 
				}
			});
		});
			
		$('#q2').click(function(){
			//ajax요청 보내기
			$.ajax({//javascript안에서 {}은 json
				url : 'main.do?action=q2',
				data : {//client에서 서버로 보낼 데이터
					num1 : $('#num3').val(), //시험에서 구멍 뚜림
					num2 : $('#num4').val() //시험에서 구멍 뚜림
				},
				success : function(result, status, xhr) { //파라미터로 result만 받아도 된다. 
					//서버에서 성공적으로 응답이 도착 했을 때(callback 메소드)		
					$('#display').html(result); //시험에서 구멍 뚜림 (값을 뿌려할 부분이 span이거나 div면 .html(result) 이고 값을 뿌려야할 부분이 input type text이면 .val(result)이다. 
				}
			});
		});
	});
	
</script>
</head>
<body>
<h1> 메인 페이지 </h1>
<p/>

num1:	<input type="text" name="num1" id="num1">
num2:	<input type="text" name="num2" id="num2">
<button id="q1">get-1</button> 
<hr>
num3:	<input type="text" name="num3" id="num3">
num4:	<input type="text" name="num4" id="num4">
<button id="q2">get-2</button> 
<div id="display"></div>

</body>
</html>