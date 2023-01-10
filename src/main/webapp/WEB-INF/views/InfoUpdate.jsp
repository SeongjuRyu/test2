<%@page import="com.jurgi.InsertMenuController.InsertMenuBean"%>
<%@page import="com.jurgi.InsertMenuModel.InsertMenuDto"%>
<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@page import="com.jurgi.loginmodel.Login_UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>회원 정보 수정</title>
    <link rel="stylesheet" href="resources/update_assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/update_assets/css/Login-Form-Clean.css">
    <link rel="stylesheet" href="resources/update_assets/css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="resources/update_assets/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="resources/update_assets/css/Sidebar-1.css">
    <link rel="stylesheet" href="resources/update_assets/css/Sidebar.css">
    <link rel="stylesheet" href="resources/update_assets/css/styles.css">
    
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/jumju_order/jumju_order_fonts/font-awesome.min.css">
    <link rel="stylesheet" href="resources/jumju_order/jumju_order_css/Sidebar-1.css">
    <link rel="stylesheet" href="resources/jumju_order/jumju_order_css/Sidebar.css">
    <link rel="stylesheet" href="resources/jumju_order/jumju_order_css/styles.css">
    
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_fonts/fontawesome-all.min.css">
 	<link rel="stylesheet" href="resources/gogek_order/gogek_order_fonts/font-awesome.min.css">
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_css/Sidebar-1.css">
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_css/Sidebar.css">
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_css/styles.css">
    
   <script type="text/javascript">
   window.onload = function(){
	   
	   $("#ok").click(function(){
			if($("#Update_name").val()==""){
				alert("정보를 제대로 입력해주세요");
				document.getElementById("Update_name").focus();
			}else if($("#Update_phone").val()==""){
				alert("정보를 제대로 입력해주세요");
				document.getElementById("Update_phone").focus();
			}else if($("#Update_address").val()==""){
				alert("정보를 제대로 입력해주세요");
				document.getElementById("Update_address").focus();
			}else if($("#Update_pwd").val()==""){
				alert("정보를 제대로 입력해주세요");
				document.getElementById("Update_pwd").focus();
			}else{
				document.getElementById('infochange').submit();
			}
		})
	   
		$("#btnokpwd").click(function(){
			if($("#npassword").val()==""){
				alert("정보를 제대로 입력해주세요");
				document.getElementById("npassword").focus();
			}else if($("#cpassword").val()==""){
				alert("정보를 제대로 입력해주세요");
				document.getElementById("cpassword").focus();
			}else if($("#rpassword").val()==""){
				alert("정보를 제대로 입력해주세요");
				document.getElementById("rpassword").focus();
			}else{
				document.getElementById('password').submit();
			}
		})
		
      $("#cancel").click(function(){
          history.back();
      })
      
      $("#btnokcancel").click(function(){
          history.back();
      })
   }
   function infochange(){
      $("#password").hide();
      $("#infochange").show();
      $("#marketshow").hide();
      $("#menushow").hide();
      $("#orderlist").hide();
   }
   function pwdchange(){
      $("#password").show();
      $("#infochange").hide();
      $("#marketshow").hide();
      $("#menushow").hide();
      $("#orderlist").hide();
   }
   /* function market(master_market){
      $("#password").hide();
      $("#menushow").hide();
      $("#infochange").hide();
      location.href="marketgo?master_market=" + master_market;
   } */
   
/*    function menu(master_market){
      $("#password").hide();
      $("#marketshow").hide();
      $("#infochange").hide();
      location.href="menugo?master_market=" + master_market;
   } */
   </script>
</head>
<body>
<div class="container-fluid">
<div class="row">
<div id="sidebar-main" class="sidebar sidebar-default sidebar-separate  col-md-3">
    <div class="sidebar-category sidebar-default" style="height:1000px; width:80%">
        <div class="category-title">
            <span>메뉴</span>
        </div>
        <%
        Login_MasterDto Mdto=null;
        Login_UserDto udto=null;
        if(session.getAttribute("master")!=null){
           Mdto = (Login_MasterDto)session.getAttribute("master");%>
           <div class="category-content">
            <ul id="fruits-nav" class="nav flex-column">
              <li class="nav-item">
                    <a href="javascript:infochange()" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 회원정보수정
                    </a>
                </li>
                <li class="nav-item">
                    <a href="javascript:pwdchange()" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 비밀번호변경
                    </a>
                </li>
                <li class="nav-item">
                    <a id="market" href="javascript:market('<%=Mdto.getMaster_market()%>')" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 마켓
                    </a>
                </li>
                <li class="nav-item">
                    <a href="javascript:menu('<%=Mdto.getMaster_market()%>')" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 메뉴
                    </a>
                </li>
                <li class="nav-item">
                    <a href="javascript:oderlistmaster(<%=Mdto.getMaster_no() %>)" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 주문내역
                    </a>
                </li> 
            </ul>
        </div>
        <%}else if(session.getAttribute("user")!=null){
           udto = (Login_UserDto)session.getAttribute("user");%>
           <div class="category-content">
            <ul id="fruits-nav" class="nav flex-column">
              <li class="nav-item">
                    <a href="javascript:infochange()" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 회원정보수정
                    </a>
                </li>
                <li class="nav-item">
                    <a href="javascript:pwdchange()" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 비밀번호변경
                    </a>
                </li>
                <li class="nav-item">
                    <a href="javascript:oderlistuser(<%=udto.getUser_no() %>)" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 주문내역
                    </a>
                </li>
            </ul>
        </div>
        <%
        }
        %>
    </div>
</div>
<div class="col-md-8" style="margin-top: 4%;" id="listhere">
<form id="infochange" action="infochange" method="get">
      <h2 class="text-center"><strong>회원 정보 수정</strong></h2>
      <%
      String master_no = request.getParameter("master_no");
      String user_no = request.getParameter("user_no");
      if(session.getAttribute("master")!=null){%>
         <input type="hidden" id="master_no" name="master_no" value="<%=Mdto.getMaster_no()%>"/>
         <input type="hidden" id="master_passwd" name="master_passwd" value="<%=Mdto.getMaster_passwd()%>"/>
      <%}else if(session.getAttribute("user")!=null){%>
         <input type="hidden" id="user_no" name="user_no" value="<%=udto.getUser_no()%>"/>
         <input type="hidden" id="user_passwd" name="user_passwd" value="<%=udto.getUser_passwd()%>"/>
      <%}%>
      <div class="form-group"><input class="form-control" type="text" id="Update_name" name="Update_name" placeholder="이름(ex:홍길동)"></div>
      <div class="form-group"><input class="form-control" type="tel" id="Update_phone" name="Update_phone" placeholder="휴대폰 번호 (ex:010-111-1111)"></div>
      <div class="form-group"><input class="form-control" type="text" id="Update_address" name="Update_address" placeholder="주소"></div>
      <div class="form-group"><input class="form-control" type="password" id="Update_pwd" placeholder="현재 지정된 비밀번호 입력" name="Update_pwd"></div>
   <div class="form-group">
         <div class="form-row">
            <div class="col"><button id="ok" class="btn btn-primary btn-block" type="button" style="background-color: #18c2d9; border:none;">확인</button></div>
            <div class="col"><button id="cancel" class="btn btn-primary btn-block" type="button" style="background-color: #18c2d9;padding: 6px; border:none;">취소</button></div>
      </div>
   </div>
</form>

<form id="password" action="passwdchange" method="get">
   <h2 class="text-center"><strong>비밀번호 변경</strong></h2>
    <%
    if(session.getAttribute("master")!=null){%>
    	<input type="hidden" id="master_id" name="master_id" value="<%=Mdto.getMaster_id()%>"/>
         <input type="hidden" id="master_no" name="master_no" value="<%=Mdto.getMaster_no()%>"/>
         <input type="hidden" id="master_passwd" name="master_passwd" value="<%=Mdto.getMaster_passwd()%>"/>
      <%}else if(session.getAttribute("user")!=null){%>
      	<input type="hidden" id="user_id" name="user_id" value="<%=udto.getUser_id()%>"/>
         <input type="hidden" id="user_no" name="user_no" value="<%=udto.getUser_no()%>"/>
         <input type="hidden" id="user_passwd" name="user_passwd" value="<%=udto.getUser_passwd()%>"/>
      <%}%>
       <div class="form-group"><input class="form-control" type="password" id="npassword" name="npassword" placeholder="기존 비밀번호를 입력하세요"></div>
       <div class="form-group"><input class="form-control" type="password" id="cpassword" name="cpassword" placeholder="새 비밀번호를 입력하세요"></div>
       <div class="form-group"><input class="form-control" type="password" id="rpassword" name="rpassword" placeholder="비밀번호 확인(비밀번호 한번 더 입력하세요)"></div>
      <div class="form-group">
         <div class="form-row">
               <div class="col"><button id="btnokpwd" class="btn btn-primary btn-block" type="button" style="background-color: #18c2d9; border:none;">확인</button></div>
               <div class="col"><button id="btnokcancel" class="btn btn-primary btn-block" type="button" style="background-color: #18c2d9;padding: 6px; border:none;">취소</button></div>
         </div>
      </div>      
</form>

<form id="marketshow">
	<div id="market_ShowData"></div>
</form>

<form id="menushow">
	<div id="menu_ShowData"></div>
</form>
<div id="orderlist">
</div>
</div>
</div>
</div>
    <script src="resources/update_assets/js/jquery.min.js"></script>
    <script src="resources/update_assets/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/menulist/menulist_js/menulist.js"></script>
    <script src="resources/jumju_order/jumju_order_js/jumju.js"></script>
    <script src="resources/market/market_js/market.js"></script>
    <script src="resources/infomation/infomation_js/infomation.js"></script>


</body>
</html>