<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>tab example</title>
	<style>
		#container {
			width:960px;
			margin:0 auto;
			text-align:center;
		}
		.tab {
			list-style: none;
			margin: 0;
			padding: 0;
			overflow: hidden;
		}
		/* Float the list items side by side */
		.tab li {
			float: left;
		}
		/* Style the links inside the list items */
		.tab li a {
			display: inline-block;
			color: #000;
			text-align: center;
			text-decoration: none;
			padding: 14px 16px;
			font-size: 17px;
			transition:0.3s;
		}
		/* Style the tab content */
		.tabcontent {
			display: none;
			background-color:rgb(0,154,200);
			padding: 6px 12px;
			color:#fff;
		}
		ul.tab li.current{
			width:250px;
			background-color: rgb(0,154,200);
			color: #222;
		}
		.tabcontent.current {
			display: block;
		}
	</style>
	<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
</head>
<body>
<%@include file="top_menubar.jsp" %>

                       		 	<c:choose>
       								<c:when test="${str1 eq null && str2 eq null}">
           						<c:set var="star" value="${SelMarket.market_star}" />
       								</c:when>
       								<c:when test="${str1 eq 'idInquiry' && str2 eq 'idinquiry'}">
       								
       								<script>
       								$(function() {
												$('ul.tab li').removeClass('current');
												$('.tabcontent').removeClass('current');
												$('#ss1').addClass('current');
												$('#tab3').addClass('current');
       								})
       								</script>
       								
       								</c:when>
       								
       							<c:when test="${str1 eq 'pwInquiry' && str2 eq 'pwinquiry'}">
       								<script>
       								$(function() {		
										$('ul.tab li').removeClass('current');
										$('.tabcontent').removeClass('current');
										$('#ss2').addClass('current');
										$('#tab4').addClass('current');
       								})
       								</script>
       								
       								</c:when>
       								
       								<c:otherwise>
       								</c:otherwise>
   								</c:choose>

	<div id="container">
		<ul class="tab">
			<li data-tab="tab1"><a href="#">아이디찾기</a></li>
			<li data-tab="tab2"><a href="#">비밀번호 찾기</a></li>
			<li id="ss1"data-tab="tab3"><a href="#" id="idinquiry"  onmouseout="hideMenu('idinquiry');" onclick="showMenu('idinquiry','pwinquiry');goPage('idInquiry','idinquiry');" class="on"><span class="blind">아이디 찾기</span></a></li>
			<li id="ss2"data-tab="tab4"><a href="#" id="pwinquiry" onmouseover="showMenu('pwinquiry','idinquiry');" onmouseout="hideMenu('idinquiry');" onclick="showMenu('pwinquiry','idinquiry');goPage('pwInquiry','pwinquiry');"class=''><span class="blind">비밀번호 재설정</span></a></li>
			<li data-tab="tab5"><a href="#" id="pwinquiry"><span class="blind">비밀번호 재설정</span></a></li>
		</ul>

		<div id="tab1" class="tabcontent">
	        <div class="col-md-5" style="margin-right: 100px;">
            <form action="Id_find" id="Id_find"method="POST"><label style="margin-top: 40px;font-size: 30px;">아이디 찾기</label><input class="form-control" type="text" name="IdFind_Name" id="IdFind_Name" style="margin-top: 40px;height: 50px;" placeholder="이름"><input class="form-control" type="text" name="IdFind_Phone" id="IdFind_Phone" style="margin-top: 40px;margin-bottom: 40px;height: 50px;"
                    placeholder="폰번호"></form><button class="btn btn-primary" id ="btnId_Ok" type="button" style="margin-right: 200px;background-color: #18c2d9;">확인</button><button class="btn btn-primary" id="btnId_Cancel" type="button" style="background-color: #18c2d9;">취소</button></div>
       
		</div>

		<div id="tab2" class="tabcontent">
        <div
            class="col-md-5" style="margin-left: 100px;">
            <form action="Pwd_find" id="Pwd_find" style="width: 500px;" method="POST"><label style="margin-top: 40px;font-size: 30px;">비밀번호 찾기</label><input class="form-control" type="text" name="PwdFind_Id" id="PwdFind_Id" style="margin-top: 40px;height: 50px;width: 520px;" placeholder="아이디"><input class="form-control" type="text" style="margin-top: 40px;margin-bottom: 40px;height: 50px;width: 520px;"
                    placeholder="이름" name="PwdFind_Name" id="PwdFind_Name"><button class="btn btn-primary" id ="btnPwd_Ok" type="button" style="margin-right: 200px;background-color: #18c2d9;">확인</button><button class="btn btn-primary" id ="btnPwd_Cancel" type="button" style="background-color: #18c2d9;">취소</button></form>
    </div>
		</div>
		
		<div id="tab3" class="tabcontent">
		<p> 시험중</p>
		</div>
		
	<div id="tab4" class="tabcontent">
		<p> 시험중2</p>
		</div>
	</div>
	
    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/idpwd_find/idpwd_find_js/idpwd_find.js"></script>
    <script src="resources/top/top_js/top.js"></script>
	<script>
/* 		$(function() {
			$('ul.tab li').click(function() {
				var activeTab = $(this).attr('data-tab');
				$('ul.tab li').removeClass('current');
				$('.tabcontent').removeClass('current');
				$(this).addClass('current');
				$('#' + activeTab).addClass('current');
			})
		}); */
	</script>
	<script>
	function showMenu(obj, obj2){
		document.getElementById(obj).className = "on";
		document.getElementById(obj2).className = "";
	}
	
	
	function showMenu(obj, obj2){
		document.getElementById(obj).className = "on";
		document.getElementById(obj2).className = "";
	}

	var menuList = "idinquiry pwinquiry ";
	function hideMenu(obj){
		var otherMenu = menuList.split(" ");
		for (var i = 0; i < otherMenu.length - 1; i++) {
			document.getElementById(otherMenu[i]).className = "";
		}
		
		
		document.getElementById(obj).className = "on";
	}
	function goPage(obj, obj2){
		var url = "test1?str1="+obj+"&"+"str2="+obj2;
		location.href = url;
	}
	
	</script>
	
</body>
</html>