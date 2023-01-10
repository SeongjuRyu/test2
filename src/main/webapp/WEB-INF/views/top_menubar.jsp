<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@page import="com.jurgi.loginmodel.Login_UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

<link rel="stylesheet" href="resources/top/top_css/Navigation-Clean.css">
<link rel="stylesheet" href="resources/top/top_fonts/fontawesome-all.min.css"> 
<link rel="stylesheet" href="resources/top/top_css/styles.css"> 
<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css"> 
<script type="text/javascript">
window.onload = function(){
	$("#btn_Menu").click(function(){
		//alert("확인")
		document.getElementById('menulist_data').submit();
	})
	
	$("#btn_Market").click(function(){
		//alert($("#market_master").val());
		document.getElementById('market_data').submit();
	})
	
	$("#btn_Info").on("click", function() {
		location.href = "InfoUpdate";
	});
}
</script>
</head>
<body>

<div>

<nav class="navbar navbar-light navbar-expand-md navigation-clean"  style="background-color: red;">
	<div class="container">
		<a class="navbar-brand" href="/yo"><img src="resources/top/top_img/jeogiyo.png" style="width: 100px; height: 70px;"></a>
		<button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
			<span class="sr-only">Toggle navigation</span>
			<span class="navbar-toggler-icon"></span>
		</button>
			  <%
	  Login_UserDto Udto=null;
	  Login_MasterDto Mdto=null;
		  	if(session.getAttribute("user")!=null){
		  		Udto = (Login_UserDto)session.getAttribute("user");
		  		String s  = Udto.getUser_name();
		  		%>
		 <div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav ml-auto">
		 			<div class="btn-group" role="group" id="btnGroup" style="margin-right: 20px;">
		  				<button class="btn btn-primary" type="button" id="btn_Info" style="background-color: orange;">MyInfo</button>
		  				<button class="btn btn-primary" type="button" id="btn_Logout" style="background-color: orange;">로그아웃</button>
						<p><%=s %></p>
					</div>
				</ul>
			</div>
			
	<%
		  	  }else if(session.getAttribute("master")!=null){
		  	  
		  		Mdto = (Login_MasterDto)session.getAttribute("master");
		  		String s  = Mdto.getMaster_name();
		  		

		  		%>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav ml-auto">
		 			<div class="btn-group" role="group" id="btnGroup" style="margin-right: 20px;">
		  				<button class="btn btn-primary" type="button" id="btn_Insert_Menu" style="background-color: orange;">메뉴등록</button>
		  				<button class="btn btn-primary" type="button" id="btn_Market_Create" style="background-color: orange;">가게등록</button>
		  				<button class="btn btn-primary" type="button" id="btn_Info" style="background-color: orange;">MyInfo</button>
		  				<button class="btn btn-primary" type="button" id="btn_Logout" style="background-color: orange;">로그아웃</button>
						<p><%=s %></p>
					</div>
				</ul>
			</div>
		
		  		<%
		  	  }else{
		  	  %>
		<div class="collapse navbar-collapse" id="navcol-1">
			<ul class="nav navbar-nav ml-auto">
			
				<div class="btn-group" role="group" id="btnGroup" style="margin-right: 20px;">
					<button class="btn btn-primary" id="btn_Loginhandler" type="button" style="background-color: orange;">로그인</button>
					<button class="btn btn-primary" id="btn_Sign_Up" type="button" style="background-color: orange;">회원가입</button>
				</div>
			</ul>
		</div>
		  <%
		  	  }
		  %>

	</div>
</nav>
</div>

<div style="background-image: url('resources/top/top_img/food.jpeg');height: 250px;"></div>

</body>
</html>