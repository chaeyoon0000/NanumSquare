<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
  <head>
    <title>Nanum Square</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">

    <link rel=stylesheet href="<%=request.getContextPath() %>/css/open-iconic-bootstrap.min.css" type="text/css">
	<link rel=stylesheet href="<%=request.getContextPath() %>/css/animate.css" type="text/css">
    
	<link rel=stylesheet href="<%=request.getContextPath()%>/css/owl.carousel.min.css" type="text/css">
    <link rel=stylesheet href="<%=request.getContextPath()%>/css/owl.theme.default.min.css" type="text/css">
    <link rel=stylesheet href="<%=request.getContextPath()%>/css/magnific-popup.css" type="text/css">

    <link rel=stylesheet href="<%=request.getContextPath()%>/css/aos.css" type="text/css">

    <link rel=stylesheet href="<%=request.getContextPath()%>/css/ionicons.min.css" type="text/css">

    <link rel=stylesheet href="<%=request.getContextPath()%>/css/bootstrap-datepicker.css" type="text/css">
    <link rel=stylesheet href="<%=request.getContextPath()%>/css/jquery.timepicker.css" type="text/css">

    <link rel=stylesheet href="<%=request.getContextPath()%>/css/flaticon.css" type="text/css">
    <link rel=stylesheet href="<%=request.getContextPath()%>/css/icomoon.css" type="text/css">
    <link rel=stylesheet href="<%=request.getContextPath()%>/css/style.css" type="text/css">
  </head>
<script>
function userCreate() {
	if (form.id.value == "") {
		alert("input id");
		form.userId.focus();
		return false;
	} 
	if (form.password.value == "") {
		alert("input password");
		form.password.focus();
		return false;
	}
	if (form.password.value != form.password2.value) {
		alert("not correct password");
		form.name.focus();
		return false;
	}
	if (form.name.value == "") {
		alert("input name");
		form.name.focus();
		return false;
	}
	var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	if(emailExp.test(form.email.value)==false) {
		alert("check your email");
		form.email.focus();
		return false;
	}
	var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
	if(phoneExp.test(form.phone.value)==false) {
		alert("check your phone number");
		form.phone.focus();
		return false;
	}
	form.submit();
}
function home(targetUri) {
	form.action = targetUri;
	form.submit();
}
</script>
<script type="text/JavaScript" src="http://code.jquery.com/jquery-1.7.min.js"></script>
<script type="text/JavaScript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
		function openDaumZipAddress() {
			new daum.Postcode({
				oncomplete:function(data) {
					jQuery("#postcode1").val(data.postcode1);
					jQuery("#postcode2").val(data.postcode2);
					jQuery("#zonecode").val(data.zonecode);
					jQuery("#address").val(data.address);
					jQuery("#address_etc").focus();
					console.log(data);
				}
			}).open();
		}
</script>
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
    
    <section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('<%=request.getContextPath()%>/images/bg.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Register<i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-3 bread">New Register</h1>
          </div>
        </div>
      </div>
    </section>

<!-- start form -->
	<section class="ftco-section contact-section">
      <div class="container">
        <div class="row d-flex mb-5 contact-info justify-content-center">
        </div>
        <div class="row block-9 justify-content-center mb-5">
          <div class="col-md-8 mb-md-5">
          	<h2 class="text-center">Register User</h2>
          	<form name="form" method="POST" action="<c:url value='/views/user/register' />" class="bg-light p-5 contact-form">
              <div class="form-group">
              	<label for="name">ID</label>
                <input name="id" id="id" type="text" class="form-control" placeholder="ID">
              </div>
              <div class="form-group">
              	<label for="name">Password</label>
                <input name="password" id="password" type="password" class="form-control" placeholder="Password">
              </div>
              <div class="form-group">
              	<label for="name">Check Password</label>
                <input name="password2" id="password2" type="password" class="form-control" placeholder="Password">
              </div>
              <div class="form-group">
              	<label for="name">Name</label>
                <input name="name" id="Name" type="text" class="form-control" placeholder="Name">
              </div>
              <div class="form-group">
              	<label for="name">Phone</label>
                <input name="phone" id="phone" type="text" class="form-control" placeholder="Phone">
              </div>
              <div class="form-group">
              	<label for="name">Email</label>
                <input name="email" id="email" type="text" class="form-control" placeholder="Email">
              </div>
              <div class="form-group">
              	<label for="name">Address</label>
              	<br/>
                	<input id="postcode1" name = "addr1" type="text" value="" style="width:50px;" readonly/>
					&nbsp;-&nbsp;
					<input id="postcode2" name = "addr2" type="text" value="" style="width:50px;" readonly/>
					&nbsp;&nbsp;
					<input id="zonecode" name = "addr3" type="text" value="" style="width:50px;" readonly/>
					&nbsp;
					<input type="button" onClick="openDaumZipAddress();" value = "find address" />
					<br/>
					<input type="text" name = "addr4" id="address" value="" style="width:240px;" readonly/>
					<input type="text" name = "addr5" id="address_etc" value="" style="width:200px;"/>
              </div>
              <div class="form-group">
                <input type="button" value="register" onClick="userCreate()" class="btn btn-primary py-3 px-5">
              	<input type="button" value="Home" onClick="home('<c:url value='/views/home' />')" class="btn btn-primary py-3 px-5">
              </div>
            </form>      
          </div>
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