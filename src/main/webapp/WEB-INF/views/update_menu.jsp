<%@page import="com.jurgi.InsertMenuController.InsertMenuBean"%>
<%@page import="com.jurgi.InsertMenuModel.InsertMenuDto"%>
<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/update_menu/update_css/Registration-Form-with-Photo.css"> 
<link rel="stylesheet" href="resources/update_menu/update_css/styles.css"> 

<script type="text/javascript">
window.onload = function () {
	$("#btn_Update").click(function(){
		if($("#Update_menu_irum").val()==""){
			alert("정보를 제대로 입력해주세요");
			document.getElementById("Update_menu_irum").focus();
		}else if($("#Update_menu_price").val()==""){
			alert("정보를 제대로 입력해주세요");
			document.getElementById("Update_menu_price").focus();
		}else if($("#Update_menu_content").val()==""){
			alert("정보를 제대로 입력해주세요");
			document.getElementById("Update_menu_content").focus();
		}else{
			var update_menu_Img = $("#Update_menu_img").val();
			$('#update_menu_Img').val(update_menu_Img);
			
			document.getElementById('update_menudata').submit();
		}
	})
	
	$("#btn_Updatecancel").click(function(){
    		history.back();
    })
}

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
            <form id="update_menudata" action="update_menudata" method="post" enctype="multipart/form-data">
                <h2 class="text-center"><strong>메뉴 수정</strong></h2>
                <%
				String menu_no = request.getParameter("menu_no");
				Login_MasterDto Mdto=null;
				if(session.getAttribute("master")!=null){ Mdto = (Login_MasterDto)session.getAttribute("master"); %>
					<input type="hidden" id="Update_menu_market" name="Update_menu_market" value="<%=Mdto.getMaster_market()%>"/>
					<input type="hidden" id="menu_no" name="menu_no" value="<%=menu_no%>"/>
				
				<%}%>
                <div class="form-group"><img id="Img" style="width: 150px;height: 150px;margin-top: 10px;"><input type="file" id="Update_menu_img" name="Update_menu_img" onchange="LoadImg(this);"></div>
               	 <input type="hidden" id="update_menu_Img" name="update_menu_Img" value=""/>
                <div class="form-group"><input class="form-control" type="text" id="Update_menu_irum" name="Update_menu_irum" placeholder="메뉴이름"></div>
                <div class="form-group"><input class="form-control" type="text" id="Update_menu_price" name="Update_menu_price" placeholder="가격"></div>
                <div class="form-group"><textarea class="form-control" id="Update_menu_content" name="Update_menu_content" placeholder="메뉴설명"></textarea></div>
                <div class="form-group">
                    <div class="form-row">
                        <div class="col"><button class="btn btn-primary btn-block" id="btn_Update" type="button">&nbsp;수정</button></div>
                        <div class="col"><button class="btn btn-primary btn-block" id="btn_Updatecancel" type="button">취소</button></div>
                    </div>
                </div>
            </form>
      </div>
</div>

<script src="resources/bootstrap/js/jquery.min.js"></script>
<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>