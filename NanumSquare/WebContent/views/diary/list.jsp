<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@page import="model.*"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>NANUM SQUARE</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<link rel=stylesheet
	href="<%=request.getContextPath() %>/css/open-iconic-bootstrap.min.css"
	type="text/css">
<link rel=stylesheet
	href="<%=request.getContextPath() %>/css/animate.css" type="text/css">

<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/owl.carousel.min.css"
	type="text/css">
<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/owl.theme.default.min.css"
	type="text/css">
<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/magnific-popup.css"
	type="text/css">

<link rel=stylesheet href="<%=request.getContextPath()%>/css/aos.css"
	type="text/css">

<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/ionicons.min.css"
	type="text/css">

<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/bootstrap-datepicker.css"
	type="text/css">
<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/jquery.timepicker.css"
	type="text/css">

<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/flaticon.css" type="text/css">
<link rel=stylesheet
	href="<%=request.getContextPath()%>/css/icomoon.css" type="text/css">
<link rel=stylesheet href="<%=request.getContextPath()%>/css/style.css"
	type="text/css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<script>
	    function diarySearchByKeyword() {
	    	if (form_k.keyword.value == "") {
	    		alert("키워드를 입력하십시오.");
	    		form_k.keyword.focus();
	    		return false;
	    	}	
	    	form_k.submit();
	    }
	    
	    function diarySearchByUser() {
	    	if (form_u.user.value == "") {
	    		alert("사용자를 입력하십시오.");
	    		form_u.user.focus();
	    		return false;
	    	}	
	    	form_u.submit();
	    }
	</script>

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="<c:url value='/views/home' />">Nanum<span>Square</span></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="<c:url value='/views/home' />" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="<%=request.getContextPath()%>/views/circle/list" class="nav-link">Circle</a></li>
	          <li class="nav-item"><a href="<%=request.getContextPath()%>/views/diary/list" class="nav-link">Diary</a></li>
	          <li class="nav-item"><a href="<%=request.getContextPath()%>/views/qna/list" class="nav-link">QnA</a></li>
	          <li class="nav-item"><a href="<%=request.getContextPath()%>/views/game/list" class="nav-link">Game</a></li>
	          <li class="nav-item"><a href="<%=request.getContextPath()%>/views/category/DiaryCategoryList" class="nav-link">Category</a></li>
	          <c:if test="${!empty sessionScope.userId }">
	          	<li class="nav-item"><a href="<%=request.getContextPath()%>/views/user/mypage" class="nav-link">MyPage</a></li>
	          </c:if>
	        </ul>
	      </div>
	    </div>
	  </nav>
	<!-- END nav -->

	<section class="hero-wrap hero-wrap-2 js-fullheight"
		style="background-image: url('<%=request.getContextPath()%>/images/bg.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
				<div class="col-md-9 ftco-animate pb-5">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="index.html">Home <i
								class="ion-ios-arrow-forward"></i></a></span> <span>Diary <i
							class="ion-ios-arrow-forward"></i></span>
					</p>
					<h1 class="mb-3 bread">Diary List</h1>
				</div>
			</div>
		</div>
	</section>
	<br>
	<br>
	<br>
	<hr>
	<br>
	<br>
	<br>
	<br>

	<!--  <a href="<c:url value='/diary/register/form' />">사용자 추가</a> -->

	<c:if test="${! empty sessionScope.userId }">
		<div class="container">
			<a href="/NanumSquare/views/diary/register/form"><button type="button" class="btn btn-primary py-3 px-5">Write</button></a>&nbsp;
			<a href="/NanumSquare/views/diary/friend/list"><button type="button" class="btn btn-primary py-3 px-5">Friend</button></a><br><br><br>
			<br><br>
		</div>
	</c:if>

	<div class="container">
		<!-- 키워드로 검색 form -->
		<form name="form_k" method="POST"
			action="<c:url value='/views/diary/keyword'/>">
			<div class="input-group mb-3">
				<input type="text" name="keyword" class="form-control"
					placeholder="search by keyword">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="submit"
						onClick="diarySearchByKeyword()">Search</button>
				</div>
			</div>
		</form>
	</div>

	<div class="container">
		<!-- userId로 검색 form -->
		<form name="form_u" method="POST"
			action="<c:url value='/views/diary/s_user'/>">
			<div class="input-group mb-3">
				<input type="text" name="user" class="form-control"
					placeholder="user">
				<div class="input-group-append">
					<button class="btn btn-outline-secondary" type="button"
						onClick="diarySearchByUser()">Search</button>
				</div>
			</div>
		</form>
	</div>
	<br>
	<br>

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<c:forEach var="diary" items="${diaryList}">
					<c:if test="${!empty diaryList}">
						<div class="col-md-3">
							<div class="car-wrap ftco-animate">
								<div class="img d-flex align-items-end"
									style="background-image: url(<%=request.getContextPath()%>/images/dd.jpg);">
									<div class="price-wrap d-flex"></div>
								</div>
								<div class="text p-4 text-center">
									<h2 class="mb-0">
										<a
											href="/NanumSquare/views/diary/detail?diaryNo=${diary.diaryNo}">${diary.title}</a>
									</h2>
									<span></span>
									<div class="col text-center">
										<span>${diary.content}</span>
									</div>
								</div>
							</div>
						</div>
					</c:if>

				</c:forEach>
			</div>
		</div>
	</section>

 	<footer class="ftco-footer ftco-bg-dark ftco-section">
     <div class="container">
       <div class="row">
         <div class="col-md-12 text-center">
			<p>Database Programming Team Project</p>
          </div>
       </div>
     </div>
   </footer>
    
  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-migrate-3.0.1.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/popper.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.easing.1.3.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.waypoints.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.stellar.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/owl.carousel.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.magnific-popup.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/aos.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.animateNumber.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/bootstrap-datepicker.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.timepicker.min.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/google-map.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath()%>/js/main.js"></script>
    
  </body>
</html>