<%@page contentType="text/html; charset=utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%
	Diary selectDiary = (Diary)request.getAttribute("selectDiary");
	int diaryNo = (int)request.getAttribute("diaryNo");
%>
<!DOCTYPE html>
<html lang="en">
<head>
 
<script>

function writeCmt() {
	
	if (form.content.value == "") {
		alert("내용을 입력하십시오.");
		form.content.focus();
		return false;
	}
	
	form.submit();
}

</script>

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
          	<p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home <i class="ion-ios-arrow-forward"></i></a></span> <span>Diary <i class="ion-ios-arrow-forward"></i></span></p>
            <h1 class="mb-3 bread">Diary View</h1>
          </div>
        </div>
      </div>
    </section>
    
     <section class="ftco-section ftco-car-details">
      <div class="container">
      	<div class="row justify-content-center">
      		<div class="col-md-12">
      			<div class="car-details">
      				<div class="text text-center">
      					<h2>${selectDiary.title}</h2>
      					
      					<br><br>
      					
      					
      					<!-- 좋아요 기능 구현 -->
      					<c:if test="${! empty sessionScope.userId }">
	          				<a href="/NanumSquare/views/diary/likey?diaryNo=${selectDiary.diaryNo}"><button type="button" class="btn btn-danger py-2 px-3">좋아요</button></a>
	         			</c:if>
	         			
	         			<br><br>
	         			
						<font size="4" color="red">좋아요 수 ♥ ${selectDiary.likey}</font>
	         			
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
							      <a class="nav-link active" id="pills-description-tab" data-toggle="pill" href="#pills-description" role="tab" aria-controls="pills-description" aria-expanded="true">Content</a>
							    </li>
							  </ul>
						</div>
							
						  <div class="tab-content" id="pills-tabContent">
						    <div class="tab-pane fade show active" id="pills-description" role="tabpanel" aria-labelledby="pills-description-tab">
						    	
						    	<ul class="features">
						    		<div class="right-box">${selectDiary.cnt} Views</div><br>
						    		<li class="check"><span class="ion-ios-checkmark"></span>UploadDate</li>
						    			<p>${selectDiary.uploadDate}</p>
						    		<li class="check"><span class="ion-ios-checkmark"></span>Content</li>
						    			<p>${selectDiary.content}</p>
						    		<li class="check"><span class="ion-ios-checkmark"></span>Location</li>
						    			<p>${selectDiary.loc}</p>
						   			<br><br>
						   			
						    	</ul>
						    	
									<div class="form-group">
						              	<a class="btn btn-primary py-3 px-5" value="list" href="<c:url value='/views/diary/list'></c:url>">list</a>
						              	<a href="/NanumSquare/views/diary/delete?diaryNo=${selectDiary.diaryNo}"><button type="button" class="btn btn-primary py-3 px-5">Diary 삭제</button></a>
          								<a href="/NanumSquare/views/diary/update/form?diaryNo=${selectDiary.diaryNo}"><button type="button" class="btn btn-primary py-3 px-5">Diary 수정</button></a>
					              	</div>
				          
						    </div>

						  </div>
						</div>
		    	  </div>
				</div>
				
				
	<form name="form" method="POST" action="<c:url value='/views/comment_d/register' />">
		<input type="hidden" name="diaryNo" value="${diaryNo}">
		<table> 
		 	<tr> 
				
				<!-- 아이디 -->
				
				<td>
					<div>
						${sessionScope.sessionId}
					</div>
				</td>
				
				<!-- 본문 작성  -->
				
	 
				<td>
					<div>
						<textarea name="content" rows="4" cols="70"></textarea>
					</div>
				</td>
				
				<!-- 댓글 등록 버튼  -->
				<td>
					<button type="submit" class="btn btn-primary py-3 px-5" onClick="writeCmt()">작성 완료</button> &nbsp;
				</td>
			
				<td>
				
				</td>
				
			</tr>
		</table>
	</form>
	
    </div>
    
    <div class=container>
	 	<div class="row justify-content-center">
	 	<div class="col-md-12">
	 	<div class="car-details">
	 	<div class="text text-left">
	 		<c:if test="${comment_dList != null}">
			<c:forEach var="comment" items="${comment_dList}">
			
			
			<tr> 
				<td>
					<div>
						${comment.userName}<br> 
						<font size="2" color="lightgray">${comment.uploadDate}</font>
					</div>
				</td> 
				
				<td>
					<div class="text_wrapper">
						${comment.content}
					</div>
				</td>
			</tr>
			
			<tr class="hide">
			</tr>
			
			<tr>
					
				<td>
					<a href="/NanumSquare/views/comment_d/delete?commentNo=${comment.commentNo}&diaryNo=${comment.userNo}"><button type="button" class="btn btn-primary py-3 px-5">삭제</button></a>
				</td>
				
			</tr>
			<tr>
				<td>
					   <div align="center">
         				 
						<c:forEach var="recomment" items="${comment_d_cList}">
							<c:if test="${recomment.dParent == comment.commentNo}">
							<tr>
								<td>
									<div>
									
										${recomment.userName}<br>
										<font size="2" color="lightgray">${recomment.uploadDate}</font><br>
										${recomment.content}
										
										<br>
										<a href="/NanumSquare/views/comment_d_c/delete?dChildNo=${recomment.dCommentNo}&diaryNo=${comment.userNo}"><button type="button" class="btn btn-primary py-3 px-5">삭제</button></a>
										<br><font size="2" color="lightgray">-----------------------------------------</font>
									
									</div>
								</td>
								
								<td>
									
								</td>
							</tr>
							</c:if>
						</c:forEach>
						
						<br><br>
						<a href="/NanumSquare/views/comment_d_c/register/form?commentNo=${comment.commentNo}&diaryNo=${comment.userNo}"><button type="button" class="btn btn-primary py-3 px-5">답글 작성하기</button></a><br><br> 
						 
						</div>
				</td>
			</tr>
			
			
			<br>
			<hr>
			<br>
			</c:forEach>
	  		</c:if>
	  		</div>
	  		</div>
	  		</div>
	  	</div>
	 </div>
	 
	 
    </section>
      				
	  	

<%--
	  }
	}
--%>	 

    <section class="ftco-section">
    	<div class="container">
    		<div class="row">	
    		</div>
    	<div class="row mt-5">
          <div class="col text-center">
            <div class="block-27">
              <ul>
                <li><a href="#">&lt;</a></li>
                <li class="active"><span>1</span></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">&gt;</a></li>
              </ul>
              
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