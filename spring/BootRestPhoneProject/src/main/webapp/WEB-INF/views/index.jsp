<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>RESTful 웹서비스 클라이언트(JSON)</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		phoneList();
		phoneSelect();
		phoneDelete();
		phoneUpdate();
		phoneInsert();
		loginCheck();
		btnLogout();
		init();
	});
	
	function phoneList() {
		clear();
		$.ajax({
			url:'phones',
			type:'get',
			dataType:'json',
			success:function(data){
				phoneListResult(data);	
			},
			error:function(xhr,status,msg){
				alert("상태값 : "+status + "http 에러 메세지 : "+ msg)
			}
		});
	}
	
	function loginCheck() {
		$('#btnLogin').on('click',function(){
			var id = $('#id').val()
			var pw = $('#pw').val()
			$.ajax({
				url:'login/' + id + '/' + pw,
				type:'get',
				dataType:'json',
				success: function(data) {
					if(data){
						location.reload()
					} else {
						alert("로그인에 실패하였습니다. 다시 시도해주세요. ")
					}
					
				},
				error:function(xhr,status,msg){
					alert("로그인에 실패하였습니다. 다시 시도해주세요. ")
				}
			});
		});
	}
		
	function phoneListResult(data){
		$('tbody').empty();
		$.each(data,function(idx,item){
			$('<tr>').append($('<td>').html(item.num))
					.append($('<td>').html(item.model))
					.append($('<td>').html(item.price))
					.append($('<td>').html(item.vcode))
					.append($('<td>').html('<button id="btnSelect">조회</button>'))
					.append($('<td>').html('<button id="btnDelete">삭제</button>'))
					.append($('<input type="hidden" id="hidden_num">').val(item.num))
					.appendTo('tbody');
		});
		
		
	}
	
	function phoneSelect() {
		$('body').on('click','#btnSelect',function(){
			var num = $(this).closest('tr').find('#hidden_num').val();
			//ajax 요청
			$.ajax({
				url:'phones/' + num,
				type:'get',
				dataType:'json',
				success: phoneSelectResult
			});
			
			
		});
	}
	
	function phoneSelectResult(data){
		$('#num').val(data.num);
		$('#model').val(data.model);
		$('#price').val(data.price);
		$('#vcode').val(data.vcode);
	}
	
	function phoneDelete() {
		$('body').on('click','#btnDelete',function(){
			var num = $(this).closest('tr').find('#hidden_num').val();
			
			$.ajax({
				url:'phones/' + num,
				type:'delete',
				success: phoneList
			});
		});
	}
	
	function phoneUpdate() {
		$('#btnUpdate').on('click', function() {
			var num = $('#num').val()
			var model = $('#model').val()
			var price = $('#price').val()
			var vcode = $('#vcode').val()
	
			$.ajax({
				url : 'phones/',
				type : 'put',
				datatype : 'json', 
				data : JSON.stringify({
					num : num,
					model : model,
					price : price,
					vcode : vcode
				}),
				contentType : 'application/json',
				success : function() {
					phoneList();
					clear();
				}
			});
		})
	}

	function phoneInsert() {
		$('#btnInsert').on('click', function() {
			var num = $('#num').val()
			var model = $('#model').val()
			var price = $('#price').val()
			var vcode = $('#vcode').val()
			
			$.ajax({
				url : 'phones/',
				type : 'post',
				datatype : 'json',
				data : JSON.stringify({
					num : num,
					model : model,
					price : price,
					vcode : vcode
				}),
				contentType : 'application/json',
				success : function() {
					phoneList();
					clear();
				}
			});
		});
	}
	
	function btnLogout() {
		$('#btnLogout').on('click', function() {
			$.ajax({
				url : 'logout/',
				type : 'get',
				success: function() {
					location.reload()
				},
				error:function(xhr,status,msg){
					alert("상태값 : "+status + "http 에러 메세지 : "+ msg)
				}
			});
		});
	}
	
	function clear() {
		var num = $('#num').val('')
		var model = $('#model').val('')
		var price = $('#price').val('')
		var vcode = $('#vcode').val('')
	}
	
	function init() {
		//초기화 버튼 클릭
		$('#btnInit').on('click', function() {
			clear();
		});
	}
</script>
</head>
<body>
	<div class="container">
<c:if test="${empty user}">
 	<form id="form2" class="form-horizontal">
 		<div class="form-group">
 		<h2>로그인</h2>
				<label>아이디 : </label> <input type="text" class="form-control"	id="id">
			</div>
			<div class="form-group">
				<label>비밀번호 : </label> <input type="text" class="form-control"	id="pw">
			</div>
			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="로그인"	 id="btnLogin" /> 
			</div>
 	</form>
</c:if>
<c:if test="${not empty user}">
<form> ${user} 님 로그인 되었습니다. <input type="button" class="btn btn-primary" id="btnLogout" value="로그아웃"></form>
 
</c:if>

		<form id="form1" class="form-horizontal">
			<h2>핸드폰 관리</h2>
			<div class="form-group">
				<label>번호 : </label> <input type="text" class="form-control"	id="num">
			</div>
			<div class="form-group">
				<label>모델명 : </label> <input type="text" class="form-control"	id="model">
			</div>
			<div class="form-group">
				<label>가격 : </label> <input type="text" class="form-control" id="price">
			</div>
			<div class="form-group">
				<label>제조사 : </label> <input type="text" class="form-control" id="vcode">
			</div>
			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="등록"	 id="btnInsert" /> 
				<input type="button" class="btn btn-primary" value="수정" id="btnUpdate" /> 
				<input type="button" class="btn btn-primary" value="초기화" id="btnInit" />
			</div>
		</form>
	</div>
	<hr />
	<hr />

	<div class="container">
		<h2>핸드폰 목록</h2>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-center">번호</th>
					<th class="text-center">모델명</th>
					<th class="text-center">가격</th>
					<th class="text-center">제조사</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
</html>