<%@page import="com.jurgi.InsertMenuController.InsertMenuBean"%>
<%@page import="com.jurgi.InsertMenuModel.InsertMenuDto"%>
<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

<link rel="stylesheet" href="resources/Insert_menu/Insert_bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/Insert_menu/Insert_css/Registration-Form-with-Photo.css"> 
<link rel="stylesheet" href="resources/Insert_menu/Insert_css/styles.css"> 

<script type="text/javascript">
window.onload = function () {
	$("#btn_Insert").click(function(){
		if($("#Insert_menu_irum").val()==""){
			alert("정보를 제대로 입력해주세요");
			document.getElementById("Insert_menu_irum").focus();
		}else if($("#Insert_menu_price").val()==""){
			alert("정보를 제대로 입력해주세요");
			document.getElementById("Insert_menu_price").focus();
		}else if($("#Insert_menu_content").val()==""){
			alert("정보를 제대로 입력해주세요");
			document.getElementById("Insert_menu_content").focus();
		}else{
			
			var menu_Img = $("#Insert_menu_img").val();
			$('#menu_Img').val(menu_Img);
			
			document.getElementById('insert_menudata').submit();
		}
	})
	
	$("#btn_Insertcancel").click(function(){
    		history.back();
    })
}

var sel_file;


function LoadImg(value){
	if(value.files && value.files[0]){
		var reader = new FileReader();
		reader.onload = function(e){
			$("#Img").attr('src', e.target.result);
		}
		reader.readAsDataURL(value.files[0]);
	}
}

</script>

</head>
<body>

<div class="register-photo">
      <div class="form-container">
            <form id="insert_menudata" action="insert_menudata" method="post" enctype="multipart/form-data">
                <h2 class="text-center"><strong>메뉴 등록</strong></h2>
                <%
				Login_MasterDto Mdto=null;
				if(session.getAttribute("master")!=null){ Mdto = (Login_MasterDto)session.getAttribute("master"); %>
					<input type="hidden" id="Insert_menu_market" name="menu_market" value="<%=Mdto.getMaster_market()%>"/>
					<input type="hidden" id="Insert_menu_market" name="master_no" value="<%=Mdto.getMaster_no()%>"/>
				<%}%>
                <div class="form-group"><img id = "Img" style="width: 150px;height: 150px;margin-top: 10px;"><input type="file" id="Insert_menu_img" name="aa" onchange="LoadImg(this);"></div>
                <input type="hidden" id="menu_Img" name="menu_Img" value=""/>
                <div class="form-group"><input class="form-control" type="text" id="Insert_menu_irum" name="menu_name" placeholder="메뉴이름"></div>
                <div class="form-group"><input class="form-control" type="text" id="Insert_menu_price" name="menu_price" placeholder="가격"></div>
                <div class="form-group"><textarea class="form-control" id="Insert_menu_content" name="menu_content" placeholder="메뉴설명"></textarea></div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col"><button class="btn btn-primary btn-block" id="btn_Insert" type="button">&nbsp;등록</button></div>
                        <div class="col"><button class="btn btn-primary btn-block" id="btn_Insertcancel" type="button">취소</button></div>
                    </div>
                </div>
            </form>
      </div>
</div>

<script src="resources/Insert_menu/Insert_js/jquery.min.js"></script>
<script src="resources/Insert_menu/Insert_bootstrap/js/bootstrap.min.js"></script>
</body>
</html>