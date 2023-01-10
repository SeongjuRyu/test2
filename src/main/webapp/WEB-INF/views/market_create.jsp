<%@page import="com.jurgi.InsertMenuController.InsertMenuBean"%>
<%@page import="com.jurgi.InsertMenuModel.InsertMenuDto"%>
<%@page import="com.jurgi.loginmodel.Login_MasterDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>가계등록</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/market_create/market_create_css/styles.css">
    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/market_create/market_create_js/market_create.js"></script>

    <script type="text/javascript"> 
    window.onload = function () {
    	$("#btn_ok").click(function(){
    		if($("#market_name").val()==""){
    			alert("정보를 제대로 입력해주세요");
    			document.getElementById("market_name").focus();
    		}else if($("#market_tel").val()==""){
    			alert("정보를 제대로 입력해주세요");
    			document.getElementById("market_tel").focus();
    		}else if($("#market_address").val()==""){
    			alert("정보를 제대로 입력해주세요");
    			document.getElementById("market_address").focus();
    		}else if($("#market_content").val()==""){
    			alert("정보를 제대로 입력해주세요");
    			document.getElementById("market_content").focus();
    		}else if($("#market_rowprice").val()==""){
    			alert("정보를 제대로 입력해주세요");
    			document.getElementById("market_rowprice").focus();
    		}else{
    			var time1 = $("#market_time1 option:selected").val();
    	   		$("#time1").val()==time1;
    	   		//alert(time1)
    	   		var time2 = $("#market_time2 option:selected").val();
    	   		$("#time2").val()==time2;
    	   		//alert(time2)
    	   		var time3 = $("#market_time3 option:selected").val();
    	   		$("#time3").val()==time3;

    	   		var time4 = $("#market_time4 option:selected").val();
    	   		$("#time4").val()==time4;
    	   		$("#totime").val(time1+":"+time2+"~"+time3+":"+time4)
    	   		
    	   		var ftype = $("#foodtype option:selected").val();
    	   		$("#food_type").val() == ftype;
    	   		$("#category").val(ftype);
    	   		
    			var market_Img = $("#market_img").val();
    			$('#market_Img').val(market_Img);
    			
    			document.getElementById('market_createdata').submit();
    		}
    		
    	$("#btn_cancel").click(function(){
        	history.back();
        })
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
    <form id="market_createdata" action='market_createdata' method="post" enctype="multipart/form-data">
    <div class="container">
    	<%
		Login_MasterDto Mdto=null;
		if(session.getAttribute("master")!=null){ Mdto = (Login_MasterDto)session.getAttribute("master"); %>
		<input type="hidden" id="master_market" name="master_market" value="<%=Mdto.getMaster_market()%>"/>
		<input type="hidden" id="master_no" name="master_no" value="<%=Mdto.getMaster_no()%>"/>
		<%}%>
        <div class="row">
            <div class="col text-center" style="margin-top: 50px;">
            	<img id="Img" style="width: 150px;height: 150px;margin-top: 10px;">
            	<input class="d-xl-flex" type="file" style="margin-left: 700px;" name="aa" id="market_img" onchange="LoadImg(this);">
            	<input type="hidden" id="market_Img" name="market_Img" value=""/>
            </div>
        </div>
        <div class="row">
            <div class="col text-center" style="margin-top: 35px;">
            <input type="text" style="width: 500px;height: 43px;" placeholder="가게이름" name="market_name" id="market_name"></div>
        </div>
        <div class="row">
            <div class="col text-center" style="margin-top: 35px;">
            <input type="text" style="width: 500px;height: 43px;" placeholder="가게 전화번호" name="market_tel" id="market_tel"></div>
        </div>
        <div class="row">
            <div class="col text-center" style="margin-top: 35px;">
            <input type="text" style="width: 500px;height: 43px;" placeholder="가게 주소" name="market_address" id="market_address"></div>
        </div>
        <div class="row">
            <div class="col text-center" style="margin-top: 35px;">
            <input type="text" style="width: 500px;height: 43px;" placeholder="가게 설명" name="market_content" id="market_content"></div>
        </div>
        <div class="row">
            <div class="col text-center" style="margin-top: 35px;">
            <p>영업시간</p>
            <select id='market_time1'>
            	<option value="00" selected="selected">00</option>
            	<option value="01">01</option>
            	<option value="02">02</option>
            	<option value="03">03</option>
            	<option value="04">04</option>
            	<option value="05">05</option>
            	<option value="06">06</option>
            	<option value="07">07</option>
            	<option value="08">08</option>
            	<option value="09">09</option>
            	<option value="10">10</option>
            	<option value="11">11</option>
            	<option value="12">12</option>
            	<option value="13">13</option>
            	<option value="14">14</option>
            	<option value="15">15</option>
            	<option value="16">16</option>
            	<option value="17">17</option>
            	<option value="18">18</option>
            	<option value="19">19</option>
            	<option value="20">20</option>
            	<option value="21">21</option>
            	<option value="22">22</option>
            	<option value="23">23</option>
            	<option value="24">24</option>
            </select>
			<input type="hidden" id="totime" name="market_time" value=""/>
            <%String time1 = request.getParameter("time1"); %>
			<input type="hidden" id="time1" value="<%=time1%>"/>
            :
            <select id='market_time2'>
            	<option value="00" selected="selected">00</option>
            	<option value="01">01</option>
            	<option value="02">02</option>
            	<option value="03">03</option>
            	<option value="04">04</option>
            	<option value="05">05</option>
            	<option value="06">06</option>
            	<option value="07">07</option>
            	<option value="08">08</option>
            	<option value="09">09</option>
            	<option value="10">10</option>
            	<option value="11">11</option>
            	<option value="12">12</option>
            	<option value="13">13</option>
            	<option value="14">14</option>
            	<option value="15">15</option>
            	<option value="16">16</option>
            	<option value="17">17</option>
            	<option value="18">18</option>
            	<option value="19">19</option>
            	<option value="20">20</option>
            	<option value="21">21</option>
            	<option value="22">22</option>
            	<option value="23">23</option>
            	<option value="24">24</option>
            	<option value="25">25</option>
            	<option value="26">26</option>
            	<option value="27">27</option>
            	<option value="28">28</option>
            	<option value="29">29</option>
            	<option value="30">30</option>
            	<option value="31">31</option>
            	<option value="32">32</option>
            	<option value="33">33</option>
            	<option value="34">34</option>
            	<option value="35">35</option>
            	<option value="36">36</option>
            	<option value="37">37</option>
            	<option value="38">38</option>
            	<option value="39">39</option>
            	<option value="40">40</option>
            	<option value="41">41</option>
            	<option value="42">42</option>
            	<option value="43">43</option>
            	<option value="44">44</option>
            	<option value="45">45</option>
            	<option value="46">46</option>
            	<option value="47">47</option>
            	<option value="48">48</option>
            	<option value="49">49</option>
            	<option value="50">50</option>
            	<option value="51">51</option>
            	<option value="52">52</option>
            	<option value="53">53</option>
            	<option value="54">54</option>
            	<option value="55">55</option>
            	<option value="56">56</option>
            	<option value="57">57</option>
            	<option value="58">58</option>
            	<option value="59">59</option>
            </select>
            <%String time2 = request.getParameter("time2"); %>
			<input type="hidden" id="time2" value="<%=time2%>"/>
            ~
            <select id='market_time3'>
            	<option value="00" selected="selected">00</option>
            	<option value="01">01</option>
            	<option value="02">02</option>
            	<option value="03">03</option>
            	<option value="04">04</option>
            	<option value="05">05</option>
            	<option value="06">06</option>
            	<option value="07">07</option>
            	<option value="08">08</option>
            	<option value="09">09</option>
            	<option value="10">10</option>
            	<option value="11">11</option>
            	<option value="12">12</option>
            	<option value="13">13</option>
            	<option value="14">14</option>
            	<option value="15">15</option>
            	<option value="16">16</option>
            	<option value="17">17</option>
            	<option value="18">18</option>
            	<option value="19">19</option>
            	<option value="20">20</option>
            	<option value="21">21</option>
            	<option value="22">22</option>
            	<option value="23">23</option>
            	<option value="24">24</option>
            </select>
            <%String time3 = request.getParameter("time3"); %>
			<input type="hidden" id="time3" value="<%=time3%>"/>
            :
            <select id='market_time4'>
            	<option value="00" selected="selected">00</option>
            	<option value="01">01</option>
            	<option value="02">02</option>
            	<option value="03">03</option>
            	<option value="04">04</option>
            	<option value="05">05</option>
            	<option value="06">06</option>
            	<option value="07">07</option>
            	<option value="08">08</option>
            	<option value="09">09</option>
            	<option value="10">10</option>
            	<option value="11">11</option>
            	<option value="12">12</option>
            	<option value="13">13</option>
            	<option value="14">14</option>
            	<option value="15">15</option>
            	<option value="16">16</option>
            	<option value="17">17</option>
            	<option value="18">18</option>
            	<option value="19">19</option>
            	<option value="20">20</option>
            	<option value="21">21</option>
            	<option value="22">22</option>
            	<option value="23">23</option>
            	<option value="24">24</option>
            	<option value="25">25</option>
            	<option value="26">26</option>
            	<option value="27">27</option>
            	<option value="28">28</option>
            	<option value="29">29</option>
            	<option value="30">30</option>
            	<option value="31">31</option>
            	<option value="32">32</option>
            	<option value="33">33</option>
            	<option value="34">34</option>
            	<option value="35">35</option>
            	<option value="36">36</option>
            	<option value="37">37</option>
            	<option value="38">38</option>
            	<option value="39">39</option>
            	<option value="40">40</option>
            	<option value="41">41</option>
            	<option value="42">42</option>
            	<option value="43">43</option>
            	<option value="44">44</option>
            	<option value="45">45</option>
            	<option value="46">46</option>
            	<option value="47">47</option>
            	<option value="48">48</option>
            	<option value="49">49</option>
            	<option value="50">50</option>
            	<option value="51">51</option>
            	<option value="52">52</option>
            	<option value="53">53</option>
            	<option value="54">54</option>
            	<option value="55">55</option>
            	<option value="56">56</option>
            	<option value="57">57</option>
            	<option value="58">58</option>
            	<option value="59">59</option>
            </select>
            <%String time4 = request.getParameter("time4"); %>
			<input type="hidden" id="time4" value="<%=time4%>"/>
        	</div>
        </div>
        <div class="row">
            <div class="col text-center" style="margin-top: 35px;">
            <input type="text" style="width: 500px;height: 43px;" placeholder="최소결제금액" name="market_rowprice" id="market_rowprice"></div>
        </div>
        <div class="row" style="filter: sepia(0%);">
            <div class="col text-center" style="margin-top: 25px;filter: saturate(0%);">
                <select id="foodtype">
                    	<option selected="selected" value="1">치킨</option>
                    	<option value="2">피자</option>
                    	<option value="3">중국집</option>
                    	<option value="4">한식</option>
                        <option value="5">일식</option>
                        <option value="6">족발/보쌈</option>
                        <option value="7">분식</option>
                        <option value="8">카페</option>
                </select>
                <input type="hidden" id="category" name="market_category" value=""/>
                <%String ftype = request.getParameter("ftype"); %>
				<input type="hidden" id="food_type" value="<%=ftype%>"/>
        	</div>
    	</div>
    <div class="row">
        <div class="col text-center" style="margin-top: 30px;">
        	<button class="btn btn-primary" id="btn_ok" type="button" style="margin-right: 115px;background-color: #18c2d9;">등록</button>
        	<button class="btn btn-primary" id="btn_cancle" type="button" style="background-color: #18c2d9;">취소</button>
        </div>
    </div>
    </div>
    </form>
    
    


</body>
</html>