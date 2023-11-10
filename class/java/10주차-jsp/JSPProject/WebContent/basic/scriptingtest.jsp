<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	//선언
	int count = 100;
	public String hello(String name){
		return "hello,," + name;
	}
%>
<%--식(expression) : 출력(변수, 메소드 호출 결과, 계산 값 등 ), ;을 붙이지 않는다. --%>
count : <%= count %><br>
hello() : <%= hello("tommy") %><br>

<%--스크립트렛(scriptlet) : 자바코드 적는 영역 --%>
<% 
	int num = 123;
	out.println(++num);
%>
<hr>
count: <%= ++count %><br>
</body>
</html>