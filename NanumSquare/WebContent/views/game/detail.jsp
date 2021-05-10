<!DOCTYPE html>
<html lang="en">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <head>
    <title>Autoroad - Free Bootstrap 4 Template by Colorlib</title>
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
  function betting() {
		if (form.bPoint.value == "") {
			alert("Input Betting Point");
			form.bPoint.focus();
			return false;
		} 
		form.submit();
	}
  function gameList(targetUri) {
		form.action = targetUri;
		form.submit();
	}
  function userRemove() {
		return confirm("Delete?");		
	}
  function apply(targetUri) {
		form.action = targetUri;
		form.submit();
	}
  </script>
<style>
.left-box {
  float: left;
}
.right-box {
  float: right;
}
</style>
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
          	<p class="breadcrumbs"><span class="mr-2"><a href="<%=request.getContextPath()%>/views/home">Home <i class="ion-ios-arrow-forward"></i></a></span><span>Game details <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-3 bread">Game Details</h1>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section ftco-car-details">
      <div class="container">
      	<div class="row justify-content-center">
      		<div class="col-md-12">
      			<div class="car-details">
      				<div class="img" style="background-image: url(<%=request.getContextPath()%>/images/dd.jpg)"></div>
      				<div class="text text-center">
      					<span class="subheading">
      						<c:if test="${game.state eq '0'}">Proceeding</c:if>
      						<c:if test="${game.state eq '1'}">Completed</c:if>
      					</span>																
      				</div>
      			</div>
      		</div>
      	</div>
<%-- 		<div class="right-box">${circle.cnt} Views</div> --%>
      	<div class="row">
      		<div class="col-md-12 pills">
						<div class="bd-example bd-example-tabs">
							<div class="d-flex justify-content-center">
							  <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							    <li class="nav-item">
							      <a class="nav-link active" id="pills-description-tab" data-toggle="pill" href="#pills-description" role="tab" aria-controls="pills-description" aria-expanded="true">Description</a>
							    </li>
							    <li class="nav-item">
							      <a class="nav-link" id="pills-review-tab" data-toggle="pill" href="#pills-review2" role="tab" aria-controls="pills-review" aria-expanded="true">Betting List</a>
							    </li>
							  </ul>
							</div>

						  <div class="tab-content" id="pills-tabContent">
						    <div class="tab-pane fade show active" id="pills-description" role="tabpanel" aria-labelledby="pills-description-tab">
						    	<ul class="features">
						    		<li class="check"><span class="ion-ios-checkmark"></span>Max Betting Point</li>
						    			<p>${game.maxPoint}</p>
						    		<li class="check"><span class="ion-ios-checkmark"></span>Max Betting User</li>
						    			<p>
							    			<c:if test="${game.maxPoint eq '0'}">None</c:if>
							    			<c:if test="${game.maxPoint ne '0'}">${maxbPointUser}</c:if>
						    			</p>
						    		<li class="check"><span class="ion-ios-checkmark"></span>End Date</li>
						    			<p>${endDate}</p>
						    		<li class="check"><span class="ion-ios-checkmark"></span>State</li>
						    			<c:if test = "${game.state eq '0'}"><p>Proceeding</p></c:if>
						    			<c:if test = "${game.state eq '1'}"><p>Completed</p></c:if>
						    	</ul>
						    	<form name="form" method="GET" action="<c:url value='/views/circle/update' />">
									<div class="form-group">
										<c:if test="${sessionScope.userId eq game.id}">
										<c:if test="${game.state eq '0'}"><c:if test="${empty bettingList }">
							                <a class="btn btn-primary py-3 px-5" href="<c:url value='/views/game/update'><c:param name='gameNo' value='${game.gameNo}'/></c:url>">modify</a>
							                	<a class="btn btn-primary py-3 px-5" href="<c:url value='/views/game/delete'><c:param name='gameNo' value='${game.gameNo}'/></c:url>" onclick="return gameRemove();">delete</a>
						              	</c:if></c:if>
						              	</c:if>
						              	<a class="btn btn-primary py-3 px-5" value="list" href="<c:url value='/views/game/list'></c:url>">list</a>
					              	</div>
				              	</form>
						    </div>
						    
 						   <div class="tab-pane fade" id="pills-review2" role="tabpanel" aria-labelledby="pills-review-tab">
						      <div class="row">
							   		<div class="col-md-7">
							   			<h3 class="head">Betting List</h3>
							   			<c:if test="${empty bettingList}">
						      				<p>There is no participant.</p>
						      			</c:if>
							   			<c:if test="${!empty bettingList}">
							   			<div class="review d-flex">
							   			<c:forEach var="bet" items="${bettingList}">
									   		<div class="user-img" style="background-image: url(<%=request.getContextPath()%>/images/person_1.jpg)"></div>
									   		<div class="desc">
									   			<h4>
									   				<span class="text-left" style="color:#A4A4A4; font-size:15px;">Betting Point: ${bet.bPoint}</span>
									   				<span class="text-right">${bet.uploadDate}</span>
									   			</h4>
									   			<p>ID: ${bet.id}</p>
									   		</div>
									   	</c:forEach>
									   	</div>
									   	</c:if>
									   	<c:if test="${sessionScope.userId ne game.id}">
									   	<c:if test="${betInfo.state eq '0' || empty betInfo}"><c:if test="${game.state eq '0'}">
									   		<form name="form" method="POST" action="<c:url value='/views/game/participate'><c:param name='gameNo' value='${game.gameNo}'/></c:url>">
								              	<input name="bPoint" id="bPoint" type="text" class="form-control" placeholder="betting point">
								              	<input type="submit" value="bet" onClick="betting()" class="btn btn-primary py-3 px-5">
							              	</form>
							            </c:if>
						              	</c:if></c:if>
							   		</div>
							   	</div>
						    </div>
						  </div>
						</div>
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