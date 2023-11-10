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
		boardList();//모든 사용자 정보 요청 
		boardSelect();//한 사람 선택시 처리할 이벤트 등록
		boardDelete();//한 사람 삭제시 처리할 이벤트 등록
		boardUpdate();//한 사람 정보 수정시 처리할 이벤트 등록
		boardInsert();//한 사람 정보 입력시 처리할 이벤트 등록
		boardSearch();
		init();
		
	});//필수
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡSearch
	function boardSearch(){
		$('body').on('click','#btnSearch',function(){
			var condition = $('#condition').val();
			var word = $('#word').val();
			//ajax 요청
			$.ajax({
				url:'boards/' + condition + '/' + word,
				type:'get',
				dataType:'json',
				success: function(data) {
                    boardListResult(data);
                }
			});
		});
	}
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡList
	//모든 사용자 목록 조회 요청
	function boardList() {//REST 서버에 모든 고객 정보에 대한  ajax 요청 보내기
		clear();
		$.ajax({
			url:'boards',
			type:'get',
			dataType:'json',//서버가 보내주는 데이터 타입
			success:function(data){
				boardListResult(data);	
			},
			error:function(xhr,status,msg){
				alert("상태값 : "+status + "http 에러 메세지 : "+ msg)
			}
		});
	}//customerList	
		
	function boardListResult(data){
		$('tbody').empty();
		$.each(data,function(idx,item){
			$('<tr>').append($('<td>').html(item.num))
					.append($('<td>').html(item.name))
					.append($('<td>').html(item.title))
					.append($('<td>').html(item.content))
					.append($('<td>').html(item.wdate))
					.append($('<td>').html(item.count))
					.append($('<td>').html('<button id="btnSelect">조회</button>'))
					.append($('<td>').html('<button id="btnDelete">삭제</button>'))
					.append($('<input type="hidden" id="hidden_num">').val(item.num))
					.appendTo('tbody');
		});
		
		
	}
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡSelect
	//사용자 조회 요청
	function boardSelect() {//on 은 이벤트 등록 . 바디
		$('body').on('click','#btnSelect',function(){
			var num = $(this).closest('tr').find('#hidden_num').val();
			//ajax 요청
			$.ajax({
				url:'boards/' + num,
				type:'get',
				dataType:'json',
				success: boardSelectResult
			});
			
			
		});
	}//customerSelect
	function boardSelectResult(data){
		$('#num').val(data.num);
		$('#name').val(data.name);
		$('#pass').val(data.pass);
		$('#title').val(data.title);
		$('#content').val(data.content);
		
	}
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡDelete
	//사용자 삭제 요청
	function boardDelete() {
		$('body').on('click','#btnDelete',function(){
			var num = $(this).closest('tr').find('#hidden_num').val();
			//ajax 요청
			$.ajax({
				url:'boards/' + num,
				type:'delete',
				success: boardList
			});
		});
	}//customerDelete
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡUpdate
	
	//사용자 수정 요청
	
	function boardUpdate() {//customerUpdate
		$('#btnUpdate').on('click', function() {
			var num = $('#num').val()
			var name = $('#name').val()
			var pass = $('#pass').val()
			var title = $('#title').val()
			var content = $('#content').val()
			$.ajax({
				url : 'boards/',
				type : 'put',
				datatype : 'json', //from server
				data : JSON.stringify({// data to server
					num : num,
					pass : pass,
					name : name,
					title : title,
					content : content,
				}),
				contentType : 'application/json',//to server
				success : function() {
					boardList();
					clear();
				}
			});
		})
	}
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡInsert
	//사용자 등록 요청
	function boardInsert() {
		$('#btnInsert').on('click', function() {
			//1. 입력값 받아오기
			//2. ajax 요청 보내기
			//3. 성공시 화면 refresh
			var num = $('#num').val()
			var name = $('#name').val()
			var pass = $('#pass').val()
			var title = $('#title').val()
			var content = $('#content').val()
			$.ajax({
				url : 'boards/',
				type : 'post',
				datatype : 'json', //from server
				data : JSON.stringify({// data to server
					pass : pass,
					name : name,
					title : title,
					content : content
				}),
				contentType : 'application/json',//to server
				success : function() {
					boardList();
					clear();
				}
			});
		});
	}//customerInsert
	function clear() {
		$('#num').val('');
		$('#name').val('');
		$('#pass').val('');
		$('#title').val('');
		$('#content').val('');
	}
	//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡInit	
	//초기화
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
		<form id="form1" class="form-horizontal">
			<h2>게시판 관리</h2>
			<div class="form-group">
				<label>번호:</label> <input type="text" class="form-control"	id="num" readonly>
			</div>
			<div class="form-group">
				<label>이름:</label> <input type="text" class="form-control"	id="name">
			</div>
			<div class="form-group">
				<label>비밀번호:</label> <input type="password" class="form-control" id="pass">
			</div>
			<div class="form-group">
				<label>제목:</label> <input type="text" class="form-control" id="title">
			</div>
			<div class="form-group">
				<label>내용:</label> <input type="text" class="form-control" id="content">
			</div>
			<div class="btn-group">
				<input type="button" class="btn btn-primary" value="등록"	 id="btnInsert" /> 
				<input type="button" class="btn btn-primary" value="수정" id="btnUpdate" /> 
				<input type="button" class="btn btn-primary" value="초기화" id="btnInit" />
			</div>
		</form>
	</div>
	<hr />
	<div class="container">
		<select id="condition" name="condition">
			<option id="name" value="name">작성자</option>
			<option id="title" value="title">글제목</option>
		</select> <input type="text" id="word" name="word" placeholder="검색어를 입력하세요">
		<input type="button" class="btn btn-primary" value="검색" id="btnSearch" />
		<input type="button" class="btn btn-primary" value="전체 목록" id="btnList" onclick="boardList()" />
	</div>
	<hr />

	<div class="container">
		<h2>게시글 목록</h2>
		<table class="table text-center">
			<thead>
				<tr>
					<th class="text-center">번호</th>
					<th class="text-center">이름</th>
					<th class="text-center">제목</th>
					<th class="text-center">내용</th>
					<th class="text-center">날짜</th>
					<th class="text-center">조회수</th>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</body>
</html>