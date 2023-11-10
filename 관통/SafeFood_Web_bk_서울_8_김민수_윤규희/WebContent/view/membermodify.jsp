<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Jekyll v3.8.5">
<title>Checkout example · Bootstrap</title>

<link rel="canonical"
	href="https://getbootstrap.com/docs/4.3/examples/checkout/">

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">


<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link
	href="https://getbootstrap.com/docs/4.3/examples/checkout/form-validation.css"
	rel="stylesheet">
</head>
<body class="bg-light">
	<div class="container">
		<div class="py-5 text-center">
			<img class="d-block mx-auto mb-4" src="img/logo.png" alt=""
				width="72" height="72">
			<h2>회원정보 수정</h2>
		</div>

		<form method="post" action="membermodifyPs.food"
			class="needs-validation" novalidate>
			<div class="col-md-8 order-md-1">
				<div class="mb-3">
					<label for="id">ID</label>
					<div class="input-group">
						<input type="text" class="form-control" id="id" name="id"
							value="${m.id}" required>
						<div class="invalid-feedback" style="width: 100%;">ID는
							필수입니다.</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="password">PASSWORD</label>
					<div class="input-group">
						<input type="text" class="form-control" id="password"
							name="password" value="${m.password}" required>
						<div class="invalid-feedback" style="width: 100%;">PASSWORD는
							필수입니다.</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="username">이름</label>
					<div class="input-group">
						<input type="text" class="form-control" id="username"
							name="username" value="${m.name}" required>
						<div class="invalid-feedback" style="width: 100%;">이름은
							필수입니다.</div>
					</div>
				</div>

				<div class="mb-3">
					<label for="email">이메일</label> <input type="email"
						class="form-control" id="email" name="email" value="${m.email}">
					<div class="invalid-feedback">올바른 이메일 형식을 입력해주세요.</div>
				</div>

				<div class="mb-3">
					<label for="address">주소</label> <input type="text"
						class="form-control" id="address" name="address"
						value="${m.address}" required>
					<div class="invalid-feedback">주소는 필수입니다.</div>
				</div>

				<div class="mb-3">
					<label for="country">전화번호</label> <input type="text"
						class="form-control" id="phone" name="phone" value="${m.phone}"
						required>
					<div class="invalid-feedback">전화번호는 필수입니다.</div>
				</div>
			</div>
			<hr class="mb-4">
			<div class="col-md-8 order-md-1">
				<label for="username">알레르기 성분</label>
			</div>
			<div class="form-group">
				<label for="allergy"><b>알러지</b></label>
				<div class="col-sm-10">
					<div class="row">
						<div class="col">
							<label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="대두">대두
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="땅콩">땅콩
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="우유">우유
							</label>
						</div>
						<div class="col">
							<label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="새우">새우
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="참치">참치
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="연어">연어
							</label>
						</div>
						<div class="col">
							<label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="소고기">소고기
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="닭고기">닭고기
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="돼지고기">돼지고기
							</label>
						</div>
						<div class="col">
							<label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="복숭아">복숭아
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="민들레">민들레
							</label> <label class="checkbox-inline"> <input type="checkbox"
								id="allergy" name="allergy" value="계란흰자">계란흰자
							</label>
						</div>
					</div>
				</div>
			</div>
			<hr class="mb-4">
			<button class="btn btn-primary btn-lg btn-block" type="submit">회원정보
				수정</button>
		</form>
	</div>

	<footer class="my-5 pt-5 text-muted text-center text-small">
		<p class="mb-1">&copy;2019 Food Safe</p>
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js"><\/script>')
	</script>
	<script
		src="https://getbootstrap.com/docs/4.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-xrRywqdh3PHs8keKZN+8zzc5TX0GRTLCcmivcbNJWm2rs5C8PRhcEn3czEjhAO9o"
		crossorigin="anonymous"></script>
	<script
		src="https://getbootstrap.com/docs/4.3/examples/checkout/form-validation.js"></script>
</body>
</html>
