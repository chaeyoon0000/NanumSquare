<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <title>NANUM SQUARE</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    
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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    
    <script>
		function friendRemove() {
			return confirm("정말 삭제하시겠습니까?");		
		}
		
		function followingAccept() {
			return confirm("정말 수락하시겠습니까?");		
		}
		
		function followingReject() {
			return confirm("정말 거절하시겠습니까?");		
		}
		
		function followingCancel() {
			return confirm("정말 취소하시겠습니까?");		
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
    
    <section class="hero-wrap hero-wrap-2 js-fullheight" style="background-image: url('<%=request.getContextPath()%>/images/bg.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text js-fullheight align-items-end justify-content-start">
          <div class="col-md-9 ftco-animate pb-5">
          	<p class="breadcrumbs"><span class="mr-2"><a href="/NanumSquare/views/user/friendList">MyPage <i class="ion-ios-arrow-forward"></i></a></span></p>
            <h1 class="mb-3 bread">MyPage</h1>
          </div>
        </div>
      </div>
    </section>
    <br><br>
   
   <section class="ftco-section ftco-car-details">
      <div class="container">
      	<div class="row justify-content-center">
      		<div class="col-md-12">
      			<div class="car-details">
      				<div class="text text-left">
      					<span class="subheading">MyPage</span>
      					<h1><b>${myPage.name}</b></h1> 
      				</div>
      				<br>
      				
      				<div class="text text-left"> 
      					<table class="table table-striped">
					  <tbody>
					    <tr>
					      <th scope="row">USER_NO</th>
					      <td>${myPage.userNo}</td>
					    </tr>
					    <tr>
					      <th scope="row">ID</th>
					      <td>${myPage.id}</td>
					    </tr>
					    <tr>
					      <th scope="row">PASSWORD</th>
					      <td>${myPage.passwd}</td>
					    </tr>
					    <tr>
					      <th scope="row">PHONE</th>
					      <td>${myPage.phone}</td>
					    </tr>
					    <tr>
					      <th scope="row">E-MAIL</th>
					      <td>${myPage.email}</td>
					    </tr>
					    <tr>
					      <th scope="row">ADDRESS</th>
					      <td>${myPage.address}</td>
					    </tr>
					    <tr>
					      <th scope="row">POINT</th>
					      <td>${myPage.point}</td>
					    </tr>
					  </tbody>
					</table>
      				</div><br><br>
      				
      				<div>
      					<h4><b>Friend List</b></h4>
	      				<c:forEach var="uf" items="${user_friend}">
		      				<table class="table">
							  <tbody>
							    <tr>
							      <td>${uf.id} 의 친구는 ${uf.friendId}</td>
							      <td width="50%" align="center">
							      	<a href="<c:url value='/views/user/friend/delete'>
									<c:param name='friendno' value='${uf.friendNo}'/>
									</c:url>" onclick="return friendRemove();">
									<button type="button" class="btn btn-secondary btn-sm">삭제</button></a>
							      </td>
							    </tr>
							  </tbody>
							</table>
						</c:forEach>
      				</div><br><br>
      			
	      			<div>
	      				<h4><b>Friend Request List</b></h4>
	      				<!-- 나에게 온 친구 요청 목록 -->
	      				<c:forEach var="fr" items="${friend_request}">
		      				<table class="table" id ="table_request">
							  <tbody>
							    <tr>
							      <td width="50%">${fr.id}</td>
							      <td width="50%" align="center">
							      <a href="<c:url value='/views/user/following/accept'>
									<c:param name='friendno' value='${fr.userNo}'/>
									</c:url>" onclick="return followingAccept();">
									<button type="button" class="btn btn-secondary btn-sm">수락</button></a>&nbsp;
									
							      	<a href="<c:url value='/views/user/following/reject'>
									<c:param name='userno' value='${fr.userNo}'/>
									</c:url>" onclick="return followingReject();">
									<button type="button" class="btn btn-secondary btn-sm">거절</button></a>
							    </tr>
							  </tbody>
							</table>
						</c:forEach>
	      			</div><br><br>
	      			
	      			<div>
	      				<h4><b>Request List</b></h4>
	      				<!-- 내가 요청한 친구 목록 -->
	      				<c:forEach var="ur" items="${user_request}">
		      				<table class="table" id ="table_request">
							  <tbody>
							    <tr>
							      <td width="50%"> ${ur.friendId}</td>
							      <td width="50%" align="center"><a href="<c:url value='/views/user/following/cancel'>
							     	<c:param name='userno' value='${ur.userNo}'/>
									<c:param name='friendno' value='${ur.friendNo}'/>
									</c:url>" onclick="return followingCancel();">
									<button type="button" class="btn btn-secondary btn-sm">취소</button></a></td>
							    </tr>
							  </tbody>
							</table>
						</c:forEach>
	      			</div>
      			</div><br><br>
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