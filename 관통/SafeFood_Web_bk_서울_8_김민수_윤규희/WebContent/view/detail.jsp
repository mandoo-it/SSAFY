<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>safefood</title>
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
					<a href="#"
						style="background-image: url(images/bg_1.jpg);"> Safe<span>Food</span></a>
				</h1>
				<p class="pfooter">
					(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어<br> 1544-9001<br>
					admin@ssafy.com<br>
				</p>
			</div>
		</aside>

		<!-- END COLORLIB-ASIDE -->
		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-lg-12 px-md-5 py-5">
							<div class="row pt-md-4">
								<h1 class="mb-3">제품 정보</h1>
							</div>
							<img id="image" src="${f.img}" alt="${f.img}"
								width="200px" height="200px" style="float: left;">
							<div class="about-author d-flex p-4 bg-light">
								<div>
									<h4>제품명</h4>
									<p id="name">${f.name}</p>
									<hr>
									<h4>제조사</h4>
									<p id="maker">${f.maker}</p>
									<hr>
									<h4>원재료</h4>
									<p id="material">${f.material}</p>
								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- END-->
			</section>
		</div>


		<div id="colorlib-main">
			<section class="ftco-section ftco-no-pt ftco-no-pb">
				<div class="container">
					<div class="row d-flex">
						<div class="col-lg-12 px-md-5 py-5">
							<div class="row pt-md-4">
							</div>

							<div>
								<div id="chartContainer" style="height: 370px; width: 100%; float: left;">
								
								</div>
								<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
							</div>

							<div class="about-author d-flex p-4 bg-light">
								<div>
									<div>
										일일 제공량&nbsp;&nbsp;&nbsp; <span id="SERVING_WT">${f.supportpereat}</span>&nbsp;&nbsp;&nbsp;|
										칼로리&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT1">${f.calory}</span>&nbsp;&nbsp;&nbsp;|
										탄수화물&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT2">${f.carbo}</span>&nbsp;&nbsp;&nbsp;|
										단백질&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT3">${f.protein}</span>&nbsp;&nbsp;&nbsp;|
										지방&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT4">${f.fat}</span>&nbsp;&nbsp;&nbsp;|
										당류&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT5">${f.sugar}</span>&nbsp;&nbsp;&nbsp;|
										나트륨&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT6">${f.natrium}</span>&nbsp;&nbsp;&nbsp;|
										콜레스테롤&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT7">${f.chole}</span>&nbsp;&nbsp;&nbsp;|<br>
										포화 지방산&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT8">${f.fattyacid}</span>&nbsp;&nbsp;&nbsp;|
										트렌스 지방&nbsp;&nbsp;&nbsp; <span id="NUTR_CONT9">${f.transfat}</span>&nbsp;&nbsp;&nbsp;|
									</div>

								</div>

							</div>
						</div>
					</div>
				</div>
				<!-- END-->
			</section>
		</div>

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
		<script
			src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
		<script src="js/google-map.js"></script>
		<script src="js/main.js"></script>

		<script type="text/javascript">
			var serving_wt = ${f.supportpereat};
			var nutr1 = ${f.calory};
			var nutr2 = ${f.carbo};
			var nutr3 = ${f.protein};
			var nutr4 = ${f.fat};
			var nutr5 = ${f.sugar};
			var nutr6 = ${f.natrium};
			var nutr7 = ${f.chole};
			var nutr8 = ${f.fattyacid};
			var bgn = ${f.transfat};
			
			var chart = new CanvasJS.Chart("chartContainer",{
						animationEnabled : true,
						title : { text : "영양 그래프" },
						data : [ {
								type : "pie",
								startAngle : 240,
								yValueFormatString : "##0.00\"%\"",
								indexLabel : "{label} {y}",
								dataPoints : [
										{ y : nutr1 * 1, label : "칼로리" },
										{ y : nutr2 * 1, label : "탄수화물"},
										{ y : nutr3 * 1, label : "단백질" },
										{ y : nutr4 * 1, label : "지방" },
										{ y : nutr5 * 1, label : "당류" },
										{ y : nutr6 * 1/10, label : "나트륨" },
										{ y : nutr7 * 1, label : "콜레스테롤" },
										{ y : nutr8 * 1, label : "포화 지방산" }
										]
							}]
						});
			
				chart.render();			

		</script>
</body>
</html>