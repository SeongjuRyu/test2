<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>order list</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_fonts/fontawesome-all.min.css">
 	<link rel="stylesheet" href="resources/gogek_order/gogek_order_fonts/font-awesome.min.css">
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_css/Sidebar-1.css">
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_css/Sidebar.css">
    <link rel="stylesheet" href="resources/gogek_order/gogek_order_css/styles.css">
</head>

<body>
<div class="container-fluid">
<div class="row">
<div id="sidebar-main" class="sidebar sidebar-default sidebar-separate  col-md-3">
    <div class="sidebar-category sidebar-default" style="height:1000px; width:80%" >
        <div class="category-title">
            <span>메뉴</span>
        </div>
        <div class="category-content">
            <ul id="fruits-nav" class="nav flex-column">
              <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 전체
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 피자
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 치킨
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 분식
                    </a>
                </li>
                 <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 보쌈/족발
                    </a>
                </li>
                 <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 카페/디저트
                    </a>
                </li>
                 <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 일식
                    </a>
                </li>
                 <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 한식
                    </a>
                </li>
                 <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="fa fa-pencil" aria-hidden="true"></i> 중식
                    </a>
                </li>

            </ul>
        </div>
    </div>
</div>

<div class="col-md-8" style="margin-top: 4%;">
	  <div class="card" style= "width: 92%">
                        <div class="card-body">
                            <span>가게 이름/주문 시간+ 날짜</span> 
                              <span style="margin: 10px; margin-left: 40%; width: auto; font-size: 15px;" class = "text-warning">주문</span><i class="fas fa-arrow-right"></i><span style="margin: 10px;font-size: 15px;" class = "text-danger">주문확인</span><i class="fas fa-arrow-right"></i><span style="margin: 10px;font-size: 15px;" class = "text-success">배달중</span>
                			<i class="fas fa-arrow-right"></i><span style="margin: 10px; font-size: 15px;" class = "text-info">배달 완료</span>
                            
                            <div><img class="border rounded-0"><span style="font-size: 20px;">메뉴명:</span> &nbsp;
                            <span style="font-size: 20px;">가격:</span></div>
        
            			<div class="text-right"><span>합계: 0</span></div>
                       </div>
                    </div>
</div>
</div>
</div>
<div>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>주문목록</th>
			<th>주소</th>
			<th>가격</th>
			<th>주문상태</th>
		</tr>

		<c:forEach var="list" items="${orderlist}">
			<tr>
				<td>${list.orderlist_no}</td>
				<td>${list.orderlist_content}</td>
				<td>${list.orderlist_address}</td>
				<td>${list.orderlist_pricetotal}</td>
				<td>${list.orderlist_state}</td>
			</tr>

		</c:forEach>
	</table>


</div>    

    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>