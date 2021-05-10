<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.Category" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	@SuppressWarnings("unchecked") 
	List<Category> list = (List<Category>)request.getAttribute("list");
	String curUserId = (String)request.getAttribute("curUserId");
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Category</title>
    
    <script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
	 $(document).ready(function(){ 
	  
	  $(".topnav").hover(function() {                    //마우스를 topnav에 오버시
	   $(this).parent().find(".subnav").slideDown('normal').show();                   //subnav가 내려옴.
	   $(this).parent().hover(function() { 
	   }, function(){ 
	    $(this).parent().find(".subnav").slideUp('fast');                 //subnav에서 마우스 벗어났을 시 원위치시킴 
	   }); 
	  }); 
	  
	 }); 
	</script>


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
    
    
  </head>
  <script>
  function search() {
	  if(form.keyword.value == "") {
		  alert("input keyword");
		  form.keyword.focus();
		  return false;
	  }
	  form.submit();
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

        
            <h1 class="mb-3 bread"><a href="<c:url value='/views/category/CircleCategoryList' />"> Circle </a>  &nbsp; &nbsp; &nbsp;  
            <a href="<c:url value='/views/category/DiaryCategoryList' />"  class="mb-3 bread"> Diary </a> </h1>
            <div class="col-md-9 ftco-animate pb-5">
          	<h1 class="mb-3 bread">Circle Category List</h1>
          </div>
        
          
        </div>
      </div>
    </section>
    
	<section class="ftco-section ftco-no-pb ftco-no-pt">
    	<div class="container">
	    	<div class="row">
				<div class="col-md-12">
					<div class="search-wrap-1 ftco-animate mb-5">
						<form action="<c:url value='/views/category/CircleView' />"  class="search-property-1">
						
		        		<div class="row">
		        			<div class="col-lg align-items-end">
		        				<div class="form-group">
		        					<label for="#">Select Category</label>
		        					<div class="form-field">
		          					<div class="select-wrap">
		                      			<div class="icon"><span class="ion-ios-arrow-down"></span></div>
		                      			<select name="catNo" id="" class="form-control">
		                      				<c:forEach var="cat" items="${CategoryList}">
		                      					<option value='${cat.catNo}'>${cat.catName}</option>
		                       				</c:forEach>
		                      			</select>
		                    			</div>
				              		</div>
			              		</div>
		        			</div>
		        			
		        			<div class="col-lg align-self-end">
		        				<div class="form-group">
		        					<div class="form-field">
				                	<input type="submit" value="search" onClick="search()" class="form-control btn btn-primary">
				                
				              		</div>
			              		</div>
		        			</div>
		        			
		        		</div>
		        		</form>
		        	</div>
				</div>
	    	</div>
	    </div>
    </section>
	
	
	<section class="ftco-section">
     <div class="container">
      <div class="row d-flex justify-content-center">
    <c:forEach var="circle" items="${circleList}">
         <div class="col-md-3">
                   <div class="car-wrap ftco-animate">
                      <div class="img d-flex align-items-end" style="background-image: url('<%=request.getContextPath()%>/images/dd.jpg');">
                         <div class="price-wrap d-flex">
                            <c:if test="${circle.state le '0'}"><span class="rate">Recruiting</span></c:if>
                            <c:if test="${circle.state eq circle.max}"><span class="rate">Completed</span></c:if>
                            <p class="from-day">
                               <span>End Date/ </span>
                               <span>${circle.endDate}</span>
                            </p>
                         </div>
                      </div>
                      <div class="text p-4 text-center">
                         <h2 class="mb-0"><a href="car-single.html">${circle.title}</a></h2>
                         <span>${circle.writerName}</span>
                         <div class="col text-center">
                            <a href="<c:url value='/views/circle/detail'><c:param name='circleNo' value='${circle.circleNo}'/></c:url>" class="btn btn-black btn-outline-black ml-1">Detail</a>
                         </div>
                      </div>
                   </div>
                </div>
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