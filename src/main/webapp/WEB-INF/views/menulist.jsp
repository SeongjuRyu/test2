<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@page import="com.jurgi.InsertMenuController.InsertMenuBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
	<title>메뉴리스트</title>


</head>
<body>
<%String menu_no = request.getParameter("menu_no");%>
<div id="Menulist_ShowData"></div>

	<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
	<script src="resources/menulist/menulist_js/menulist.js"></script>
	<script src="resources/bootstrap/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>