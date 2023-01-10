<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>음식목록</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Barlow:300,400,500,600,700,900,900i">
    <link rel="stylesheet" href="resources/category_menu/category_menu_css/Contact-form.css">
    <link rel="stylesheet" href="resources/category_menu/category_menu_css/Projects-Horizontal.css">
    <link rel="stylesheet" href="resources/category_menu/category_menu_css/styles.css">
</head>

<style type="text/css">
 a:link { color: black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
 a:hover { color: blue; text-decoration: underline;}
</style>

<body>
<%@include file="top_menubar.jsp" %>
    <div class="card">
        <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs">
                <li class="nav-item"><a class="nav-link active" id="0" href="#" style="font-size: 28px;">&nbsp;전 체&nbsp;</a></li>
                <li class="nav-item"><a class="nav-link" id="7" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;분 식&nbsp;</a></li>
                <li class="nav-item"><a class="nav-link" id="8" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;카 페&nbsp;</a></li>
                <li class="nav-item"><a class="nav-link" id="1" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;치 킨&nbsp;</a></li>
                <li class="nav-item"><a class="nav-link" id="5" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;일 식&nbsp;</a></li>
                <li class="nav-item"><a class="nav-link" id="4" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;한 식&nbsp;<br></a></li>
                <li class="nav-item"><a class="nav-link" id="3" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;중 식&nbsp;</a></li>
                <li class="nav-item"><a class="nav-link" id="6" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;보 쌈&nbsp;</a></li>
                <li class="nav-item"><a class="nav-link" id="2" href="#" style="font-size: 28px;color: rgb(0,0,0);">&nbsp;피 자&nbsp;</a></li>
            </ul>
        </div>
    </div>
    <div style="margin-top: 20px;"><label style="margin-left: 15px;margin-bottom: 0px;">가게</label><input type="text" id="nowirum" style="margin-left: 15px;margin-top: 5px;"><button class="btn btn-primary text-left" type="button" id="nowsearch" style="background-color: rgb(24,194,217);font-size: 17px;height: 20px;margin-bottom: 3px;margin-left: 7px;padding-bottom: 25px;padding-top: 4px;">검색</button>
        <label
            style="margin-bottom: 0px;margin-left: 450px;">위치(시,구)</label><input type="text" id="nowlocation" value="" style="margin-left: 15px;margin-top: 5px;"><button class="btn btn-primary" type="button" id="nowmap" style="height: 30px;margin-left: 7px;margin-bottom: 3px;background-color: rgb(24,194,217);padding-top: 4px;padding-bottom: 25px;">검색</button>

                <div
                    class="dropdown-menu" role="menu"><a class="dropdown-item" role="presentation" href="#">추천순</a><a class="dropdown-item" role="presentation" href="#">위치순</a><a class="dropdown-item" role="presentation" href="#">가격순</a></div>
    </div>
    </div>

    <div id="category_showme"></div>
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6d726e0239ccc6993a47cbfc68aaa07b&libraries=services"></script>
    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/category_menu/category_menu_js/category_menu.js"></script>
    <script src="resources/top/top_js/top.js"></script>
</body>
</html>