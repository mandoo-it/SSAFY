<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //java code 적는 영역
    //name, address 받기
    String name = request.getParameter("name");
    String address = request.getParameter("address");
    
    out.println("hello," + name + "! you live in " + address); //browser에 출력
    //?첫번째변수=데이터값&두번째변수=데이터값&...
    //?붙여서 보내면 서버로 값을 줄 수 있음
    //주소창 .jsp뒤에 ?name=tom&address=seoul붙이면 값이 나옴!
%>