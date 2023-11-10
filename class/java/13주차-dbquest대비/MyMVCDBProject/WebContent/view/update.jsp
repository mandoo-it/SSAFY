<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" import="java.util.ArrayList, com.domain.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Customer 상세 데이터</h1>
<table border="1">
    <tr>
        <td>${customer.num}</td>
        <td>${customer.name}</td>
        <td><input type="address" name = "address" id="address" placeholder=${customer.address}></input></td>
    </tr>
</table><br>
<a href="main.do?action=updateProcess&num=${customer.num}">수정하기</a>
</body>
</html>