<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Ssafy Safe Food</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap"
	rel="stylesheet">

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
	<c:set var="s" value="${login}" />
	<div id="colorlib-page">
		<a href="#" class="js-colorlib-nav-toggle colorlib-nav-toggle"><i></i></a>
		<aside id="colorlib-aside" role="complementary" class="js-fullheight">
			<nav id="colorlib-main-menu" role="navigation">
				<ul>
					<li><a href="main.food">Home</a></li>
					<li><a href="list.food">상품 정보 목록</a></li>
					<c:if test="${!empty s}">
						<li><a href="membermodify.food">회원정보 수정</a></li>
						<li><a href="memberdelete.food">회원정보 삭제</a></li>
					</c:if>
				</ul>
			</nav>

			<div class="colorlib-footer">
				<h1 id="colorlib-logo" class="mb-5">
					<a href="#"
						style="background-image: url(images/bg_1.jpg);"> Safe<span>Food</span></a>
				</h1>
				<p class="pfooter">
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
					(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어<br> 1544-9001<br>
					admin@ssafy.com<br>
					<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
				</p>
			</div>
		</aside>



		<!-- END COLORLIB-ASIDE -->
		<div id="colorlib-main">
			<section class="ftco-about img ftco-section ftco-no-pt ftco-no-pb"
				id="about-section">
				<div class="container-fluid px-0">

					<c:if test="${empty s}">
						<a href="signin.food"
							style="float: right; margin: 30px 20px 0px 0px;">SignUp</a>
						<a href="login.food"
							style="float: right; margin: 30px 30px 0px 0px;">Login</a>
					</c:if>
					<c:if test="${!empty s}">
						<a href="logout.food"
							style="float: right; margin: 30px 30px 0px 0px;">LogOut</a>
					</c:if>
					<div class="row d-flex">
						<div class="col-md-6 d-flex">
							<div
								class="img d-flex align-self-stretch align-items-center js-fullheight"
								style="background-image: url(images/about.jpg);"></div>
						</div>
						<div class="col-md-6 d-flex align-items-center">
							<div class="text px-4 pt-5 pt-md-0 px-md-4 pr-md-5 ftco-animate">
								<h2 class="mb-4">
									Ssafy <span>SafeFood</span><br>Web project
								</h2>
								<br> <br>

								<!-- ------------------------------------------- -->
								<form id="target" class="form-inline" method="post"
									action="search_main.food">
									<div>
										검색조건<select id="key" name="key">
											<option value="name" selected="selected">상품명</option>
											<option value="maker">제조사</option>
											<option value="material">재료명</option>
										</select>
									</div>
									<div>
									검색단어<input type="text" name="word"
										placeholder="검색어를 입력하세요">
									<button type="submit" class="btn btn-primary">검색</button>
									</div>
								</form>

							</div>
							<p>
							<div>
								<table id="tdata">
									<c:forEach items="${list}" var="food" end="5">
										<tr class="gu" id="${food.code}">
											<td><img src="${food.img}" alt="${food.img}"
												width="100px" height="50px"></td>
										</tr>
									</c:forEach>

								</table>
							</div>
							<!-- --------------------------------------------- -->
							<p></p>

						</div>
					</div>
				</div>
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

	<!-- ----------------------------------------------------- -->
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