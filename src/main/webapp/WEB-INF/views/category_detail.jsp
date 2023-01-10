<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@page import="com.jurgi.loginmodel.Login_UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>상세보기</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/category_detail/category_detail_fonts/font-awesome.min.css">
    <link rel="stylesheet" href="resources/category_detail/category_detail_css/styles.css">
</head>
<body>
<%@include file="top_menubar.jsp" %>


<span role="button" class="btn btn-sm btn-success" id="back"> 목록으로<i
		class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
	</span>
    <div class="container-fluid">
        <div class="row" style="margin-top: 30px;">
            <div class="col col-md-8" style="/*border: 1px solid;*/">
                <div class="row" style="margin-left: 30px;border: 1px solid;">
                    <div class="col text-center col-md-2"><img src="/img/upload/${SelMarket.market_image}"style="margin-top: 15%;margin-bottom: 15%;width: 100px;height: 100px;"></div>
                    <div class="col" style="margin-top: 15px;">
                        <div class="row">
                            <div class="col" style="margin-top: 5px;margin-right: -1px;margin-bottom: -1px;margin-left: -1px;"><label class="col-form-label">가계이름:${SelMarket.market_name}</label></div>
                        </div>
                        <div class="row" style="margin: -1px;margin-top: 3px;"><label>최소주문금액:${SelMarket.market_rowprice}</label></div>
                        <input type="hidden" id="rowprice" name="rowprice" value="${SelMarket.market_rowprice}">
                        <div class="row" style="margin-top: 3px;margin-right: -1px;margin-left: -1px;margin-bottom: -1px;"><label>별점</label>
                        <div class="col">
                        
     
                       		 	<c:choose>
       								<c:when test="${SelMarket.market_star eq 0}">
           						<c:set var="star" value="${SelMarket.market_star}" />
       								</c:when>
       								<c:otherwise>
          						<c:set var="star" value="${SelMarket.market_star-1}" />
       								</c:otherwise>
   								</c:choose>
                        
                         <c:set var="loop_flag" value="false" />
                         
                        <c:forEach begin="0" end="${star}">
                       		 <c:if test="${not loop_flag}">
                       		 	<c:choose>
       								<c:when test="${star eq 0}">
           								<c:set var="loop_flag" value="true" />
       								</c:when>
       								<c:otherwise>
          								 <i class="fa fa-star"></i>
       								</c:otherwise>
   								</c:choose>
                       		 </c:if>
                        </c:forEach>
                        
                        
                         </div>  
                            
                            
                            
                        </div>
                    </div>
                </div>
                
                
                
                <div class="row" style="margin-top: 20px;">
                    <div class="col" style="margin-right: 0px;margin-left: 3%;">
                        <div class="btn-group btn-group-lg d-flex" role="group"><button class="btn btn-primary" id="btnMenu" type="button" style="background-color: #18c2d9;">메뉴</button><button class="btn btn-primary" id="btnReview" type="button" style="background-color: #18c2d9;">리뷰</button><button class="btn btn-primary" type="button"
                                style="background-color: #18c2d9;">정보</button></div>
                    <input type="hidden" id="market_no" value="${SelMarket.market_no}">
                    </div>
                </div>
                
                <!-- 메뉴클릭했을 경우 -->
               <div class="row" id="divMenu" style="margin-top: 100px; margin-left: 30px; display: none;"> </div>
               
            <form action="order" id="Orderdata" name="Orderdata" method="POST">
            <%
		  	if(session.getAttribute("user")!=null){
		  		Udto = (Login_UserDto)session.getAttribute("user");
			
		  		%>
      
            <input type="hidden" name="user_id" value="<%=Udto.getUser_id() %>">
            <input type="hidden"  name="user_name" value="<%=Udto.getUser_name()%>">
            <input type="hidden"  name="user_no" value="<%=Udto.getUser_no()%>">
            <input type="hidden" name="orderlist_address" value="<%=Udto.getUser_address() %>">
            <input type="hidden"  name="orderlist_content" id="orderinput" value="">
            <input type="hidden" name="orderlist_pricetotal" id="Sumpriceinput" value="">
            <input type="hidden" name="market_no"  value="${SelMarket.market_no}">
            
            <%
		  	  }else if(session.getAttribute("master")!=null){
		  	  
		  		Mdto = (Login_MasterDto)session.getAttribute("master");


		  		%>
		  	<input type="hidden" name="master_id" value="<%=Mdto.getMaster_id() %>">
            <input type="hidden"  name="master_name" value="<%=Mdto.getMaster_name()%>">
            <input type="hidden"  name="master_no" value="<%=Mdto.getMaster_no()%>">
            <input type="hidden" name="orderlist_address" value="<%=Mdto.getMaster_address() %>">
            <input type="hidden" name="orderlist_content" id="orderinput"  value="">
            <input type="hidden" name="orderlist_pricetotal" id="Sumpriceinput" value="">
  
		  		<%
		  	  }else{
		  		  %>
		  	     <input type="hidden" id="master_id" name="master_id" value="">
		  	     <input type="hidden" id="user_id" name="user_id" value="">
		  	  <%
		  	  }
		  	  %>
            
            
            </form>

              
            <!-- 리뷰 클릭했을때!!! -->
            	 <div id="divReview">
            		<div class="row" style="margin-top:25px; margin-left: 30px">
            	   	<div class="col">
					<h2>리뷰작성</h2>
					</div>
					</div>
					<div class="row" style="margin-left:30px">
					<div class="col ">
					<h5 class="mt-0" style="margin-top:30px !important">
						</h5></div>
					</div>
					<input type="hidden" id="readsent_check" value="${SelMarket.market_no}">
					<form action="readsentInput" id="readsentInput" method="POST">
					<%
		  				if(session.getAttribute("user")!=null){
		  				Udto = (Login_UserDto)session.getAttribute("user");
					%><label >별 점 :</label>  <span class="starR on" id="1">별1</span>
					  <span class="starR" id="2">별2</span>
					  <span class="starR" id="3">별3</span>
					  <span class="starR" id="4">별4</span>
					  <span class="starR" id="5">별5</span>
							<input type="hidden" name="readsent_id" value="<%=Udto.getUser_id() %>">
							<div style="margin-left:30px">
							<textarea cols = "170" rows="4" id="readsent_content" name="readsent_content"></textarea>
							</div>
							<input type="hidden" id="readsent_star" name="readsent_star" value="0">
							<input type="hidden" name="readsent_market" value="${SelMarket.market_no}">
							<button type="button" id="reviewSubmit"class="btn btn-primary" style="background-color: #18c2d9; margin-left:95%">등록</button>	
					  <%
		  	  			}else if(session.getAttribute("master")!=null){
		  				Mdto = (Login_MasterDto)session.getAttribute("master");
		  			%><label >별 점 :</label>  <span class="starR on" id="1">별1</span>
					  		<span class="starR" id="2">별2</span>
					  		<span class="starR" id="3">별3</span>
					  		<span class="starR" id="4">별4</span>
					  		<span class="starR" id="5">별5</span>
					  		<input type="hidden" id="readsent_star" name="readsent_star" value="0">
		  				    <input type="hidden" name="readsent_id" value="<%=Mdto.getMaster_id() %>">
		  				    <div style="margin-left:30px">
							<textarea cols = "170" rows="4" id="readsent_content" name="readsent_content"></textarea>
							</div>
							<input type="hidden" name="readsent_market" value="${SelMarket.market_no}">
							<button type="button" id="reviewSubmit" class="btn btn-primary" style="background-color: #18c2d9; margin-left:95%">등록</button>	
		  			<%
		  			}else{
		  			%>
		  			<div style="margin-left:30px">
						<p>로그인 해라</p>
					</div>
		  			<%
		  			}
		  		  	%>
					</form>
					
				
				
				
				<!--리뷰 등록 버튼 밑에 -->
				<div id="readsentshow"><!-- 구분1 -->            	
                </div><!-- 구분1끝 -->
                		</div>
                </div>
             
            
            <!-- 응안써부분 -->
            <div class="col col-md-1"></div>
            
            

            
            <!-- 장바구니 부분 -->
            <div class="col col-md-3">
                <div class="text-left">
                    <div class="row">
                        <div class="col text-center"><label class="col-form-label text-center">장바구니</label></div>
                    </div>
                    <div role="tablist" id="accordion-1">
                        <div class="card">
                            <div class="card-header" role="tab">
                                <h5 class="mb-0"><a data-toggle="collapse" aria-expanded="false" aria-controls="accordion-1 .item-1" href="div#accordion-1 .item-1">주문목록</a></h5>
                            </div>
                            <div class="collapse item-1" role="tabpanel" data-parent="#accordion-1">
                                <div class="card-body">
                                    <ul id="ul">
                                    
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                </div>
                <div class="clearfix">
                
      			<span class="list-group-item clearfix text-right ng-binding">
       					 배달요금 1,000원 별도<span class="ng-binding ng-hide"> (0원 이상 주문시 배달무료)</span>
      			</span>
      			<span class="list-group-item minimum-order-price">
          				<Strong>최소주문금액 : ${SelMarket.market_rowprice}원 이상</Strong>
     			 </span>
      			<Strong>합계</Strong><span class="list-group-item cart-total-order-price ng-binding" id="Sumprice">
      			</span>
      			
    			</div>
    			
                <div class="row">
                    <div class="col"><button id="btnOrder" class="btn btn-primary btn-block" type="button" style="background-color: #18c2d9;">주 &nbsp; 문 &nbsp; 하 &nbsp; 기</button></div>
                </div>
            </div>
        </div>
    </div>
 
<div id="modal-testNew" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="테스트정보 등록" aria-describedby="테스트 모달">
    <div class="modal-dialog" style="width:1200px;height:700px">
        <div class="modal-content">
        <div class="modal-header">
	<button type="button" class="btn pull-left" data-dismiss="modal"
		aria-label="Close" aria-hidden="true">×</button>
		
	<h3 class="smaller lighter blue no-margin modal-title">메뉴상세</h3>
</div>

<div class="modal-body">
<span id="name"></span>
<img id="images" src="" style="width:100%; height:250px; align:center;" class="card-img-top" alt="...">
<Strong id="priceS">가격:<span id="price"></span></Strong>
<input type="hidden" id="no" value=""/>
<span id="content"></span>


      <div class=" mmosolution-quantity-container" style="width: 40%;">
         <div class="input-group">
                 <span class="input-group-btn">
                         <button class="btn btn-danger mmosolution-quantity-decrease" id="decreaseQuantity"type="button"><i class="fa fa-minus"></i></button>
                  </span>
                                  <input id="input-quantity" style="min-width: 0;" name="quantity" type="text" class="form-control mmosolution-quantity" value="1" readonly>
                   <span class="input-group-btn">
                        <button class="btn btn-primary mmosolution-quantity-increas" id="increaseQuantity"type="button"><i class="fa fa-plus"></i></button>
                   </span>
           </div>                
      </div>

      
      <div class="detail-total-wrap" class="get_order_btn_class()">
        <strong>총 주문금액</strong>
        <div class="total"><strong class="ng-binding"><span id="menu_price"></span></strong><br><span class="ng-binding" id="modal_rowprice"></span></div>
      </div>
        
</div>

<div class="modal-footer">
	<span role="button" class="btn btn-sm btn-warning" id="Ordertable"> 주문표에담기<i
		class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
	</span> <span role="button" class="btn btn-sm btn-success" id="Order"> 주문하기<i
		class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
	</span>
	<button class="btn btn-sm btn-danger pull-right" data-dismiss="modal"
		id="btnClose">
		<i class="ace-icon fa fa-times"></i>닫기
	</button>
</div>
        </div>
    </div>
</div>




	<script src="resources/bootstrap/js/jquery.min.js"></script>
	<script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/top/top_js/top.js"></script>
    <script src="resources/category_detail/category_detail_js/category_detail.js"></script>
</body>
</html>