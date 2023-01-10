<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@page import="com.jurgi.loginmodel.Login_UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<title>메인메뉴</title>

<link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/main_menu/main_menu_css/styles.css">
<link rel="stylesheet" href="resources/main_menu/main_menu_css/Team-Grid.css">
</head>

<body>
<%@include file="top_menubar.jsp" %>
	 
<a href="test1?str1=pwInquiry&str2=pwinquiry">테스트</a>
<input type="checkbox" id="auth1" name="authType" value="0"/>전체
<input type="checkbox" id="auth2" name="authType" value="1"/>관리자
<input type="checkbox" id="auth3" name="authType" value="2"/>회원
<input type="checkbox" id="auth4" name="authType" value="3"/>비회원

<div class="divclass">

<a href="javascript:void(0);" onclick="cmm.click(this)" class="">가</a>
<a href="javascript:void(0);" onclick="cmm.click(this)" class="">나</a>
<a href="javascript:void(0);" onclick="cmm.click(this)" class="">다</a>
<a href="javascript:void(0);" onclick="cmm.click(this)" class="">라</a>

</div>
<div id="MainMenuCategory_ShowData"></div>



	<script src="resources/bootstrap/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="resources/top/top_js/top.js"></script>
	<script src="resources/main_menu/main_menu_js/main_menu.js"></script>


</body>
<script>



$("input[name='authType']").each(function(){
	$(this).click(function(){
		oneCheckFunc($(this));
	})
	
})
function checkArray(){
	var checkArr=[];
	
	if($("input[name='authTypeAll']").is(":checked")==true){
		
		checkArr[0]=$("input[name='authTypeAll']").val();
		$("input[name='authType']:checked").each(function(i){
			
			checkArr.push($(this).val());
			
		})
	}else{
		$("input[name='authType']:checked").each(function(i){
			
			checkArr.push($(this).val());
			
		})
	}

	for (j=0;j<checkArr.length;j++){
		alert(checkArr[j]);
	}
}
function oneCheckFunc(obj)
{
	var allObj = $("[name='authType']");
	var objName = $(obj).attr("name");
	var objId= $(obj).attr("id");
	//1.전체를 클릭하면 모든 체크박스가 선택되야 한다.
	//2.전체를 다시클릭하면 모든 체크박스가 취소되야한다.
	//3.전체를 클릭후 다른체크박스를 클릭하면 전체가 취소되고 다른것도 취소된다.
	//4. 전체를 제외한 모든 체크박스를 클릭하면 전체도 체크 되야 한다.
	
	//현재 하나가 클릭되었있으면
	if( $(obj).prop("checked") )
	{
		alert("선택O")
		//전체 체크박스 갯수
		checkBoxLength = $("[name="+ objName +"]").length-1;
		//선택된 체크박스 갯수
		checkedLength = $("[name="+ objName +"]:checked").length;

		alert(checkBoxLength+"=========="+checkedLength)
		if($("input[id='auth1']").is(":checked")==true){
			alert("전체 선택된거 확인했다")
			allObj.prop("checked", true);
		}
		//체크박스 갯수(전체 제외)와 선택된 체크박스 갯수가 같으면
 		if( checkBoxLength == checkedLength ) {
			allObj.prop("checked", true);//체크박스 id가 전체인 체크박스 체크
		} else {
			obj.prop("checked", true);
		} 
	}
	else//체크박스 체크를 취소하면
	{
		alert("선택x")
		if(objId=='auth1'){
			alert("전체 선택취소 확인했다")
			allObj.prop("checked", false);
		}
		else
		{
			
			$("input[id='auth1']").prop("checked",false);
			obj.prop("checked", false);
		}

	}
	

}

var cmm = (function(){
	
	
	var fn_click = function(url)
	{
		$(".divclass a").prop('class',"");
		if($(url).prop('class')==false){
			$(url).prop('class',"on");
		}
	};

	

	return{
		click:fn_click
	};

	
})();


</script>
</html>