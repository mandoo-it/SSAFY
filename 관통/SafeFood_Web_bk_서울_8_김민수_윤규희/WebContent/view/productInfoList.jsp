<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>safefood</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="css/animate.css">
<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">
<link rel="stylesheet" href="css/aos.css">
<link rel="stylesheet" href="css/ionicons.min.css">
<link rel="stylesheet" href="css/bootstrap-datepicker.css">
<link rel="stylesheet" href="css/jquery.timepicker.css">
<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/icomoon.css">
<link rel="stylesheet" href="css/style.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	
	$('.gu').click(function(){
		var id = $(this).attr('id');
		location.href = 'read.food?id='+id;
	})
})
</script>
</head>

<body>
	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight">
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li><a href="main.food">Home</a></li>
					<li><a href="list.food">상품 정보 목록</a></li>
				</ul>
			</nav>
			<div class="colorlib-footer">
				<h1 id="colorlib-logo" class="mb-5">
					<a href="#" style="background-image: url(images/bg_1.jpg);"> Safe<span>Food</span></a>
				</h1>
				<p class="pfooter"> (SSAFY) 서울시 강남구 테헤란로 멀티스퀘어<br> 1544-9001<br> admin@ssafy.com<br>
				</p>
			</div>
		</aside>
		<div id="colorlib-main">
			<section class="ftco-section">

				<div class="container">
					<h1>SafeFood Search</h1>
					
					<form id="target" class="form-inline" method="post" action="search.food">
						<div class="form-group">
							<label for="key">검색조건</label> 
							<select class="form-control"
								id="key" name="key">
								<option value="name" selected="selected">상품명</option>
								<option value="maker">제조사</option>
								<option value="material">재료명</option>
							</select>
							<label for="key">정렬조건</label> 
							<select class="form-control" id="sort" name="sort">
								<option value="code" selected="selected">상품번호순</option>
								<option value="calory">칼로리순</option>
								<option value="natrium">나트륨순</option>
							</select>
							<select class="form-control" id="sort2" name="sort2">
								<option value="asc">오름차순</option>
								<option value="desc" selected="selected">내림차순</option>
							</select>
						</div>
						<div class="form-group">
							<label for="word">검색단어</label> <input type="text"
								class="form-control" id="word" name="word" placeholder="검색어를 입력하세요">
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-primary">검색</button>
						</div>
					</form>
					<br><br>
					<p> <c:if test="${!empty word}">단어  &nbsp : &nbsp [${word}] &nbsp&nbsp | </c:if>&nbsp&nbsp정렬조건 &nbsp : &nbsp [${sort}]  &nbsp | &nbsp[${sort2}]&nbsp으로 검색한 결과입니다. </p>
				</div>
				<p>
				<div class="container">
					<table id="tdata" class="table table-borderless">
					<c:if test="${!empty list}">
						<c:forEach items="${list}" var="food">
							<tr class="gu" id="${food.code}">
								<td><img src="${food.img}" alt="${food.img}"
									width="200px" height="200px"></td>
								<td>
									<div class="col-md-12">
										<h3>${food.name}</h3>
										<hr>
										<p>${food.material}</p>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${empty list}"><h3>검색 결과가 없습니다.</h3></c:if>
					</table>
				</div>
				
				
			</section>
		</div>
		<!-- END COLORLIB-MAIN -->
	</div>
	<!-- END COLORLIB-PAGE -->
	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>
	
	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-migrate-3.0.1.min.js"></script>
	<script src="js/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.easing.1.3.js"></script>
	<script src="js/jquery.waypoints.min.js"></script>
	<script src="js/jquery.stellar.min.js"></script>
	<script src="js/owl.carousel.min.js"></script>
	<script src="js/jquery.magnific-popup.min.js"></script>
	<script src="js/aos.js"></script>
	<script src="js/jquery.animateNumber.min.js"></script>
	<script src="js/scrollax.min.js"></script>
	<script src="js/main.js"></script>


</body>
</html>