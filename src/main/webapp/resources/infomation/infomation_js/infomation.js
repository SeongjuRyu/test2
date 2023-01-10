$(document).ready(function(){
});
function oderlistmaster(master_no){
	$("#password").hide();
    $("#menushow").hide();
    $("#infochange").hide();
    $("#marketshow").hide();
    $("#orderlist").show();
	$.ajax({
	      type:"POST",
	      url:"orderlist_master",
	      data:{"master_number":master_no},
	      dataType:"json",
	      success:function(data){
	    	  cstr="";
	    	  $(data.master_list).each(function(idx,objArr){
	    		  cstr+="<div class='row' style='border:1px solid; margin-top:45px'>"
	    		  cstr+="<div class='col-5' style='margin-top:20px'>"
	    		  cstr+="<label style='border-bottom:1px solid'>등록번호/날짜 : </label><span>"+objArr["orderlist_no"]+"</span>/<span>"+objArr["orderlist_title"]+"</span><br/>"
	    		  cstr+="<label style='border-bottom:1px solid'>위치 : </label><span>"+objArr["orderlist_address"]+"</span><br/>"
	    		  cstr+="<label style='border-bottom:1px solid'>주문내역 및 합계 : </label><br/><span>"+objArr["orderlist_content"]+"</span><span>"+objArr["orderlist_pricetotal"]+"</span>"
	    		  cstr+="</div>"
	    		  cstr+="<div class='col-md-6' style='margin-top:20px'>"
	    		if(objArr["orderlist_state"]=='4'){
	    		  cstr+="<button class='circle1' id='deliver'>배송완료</button>"
	    		}else{
	    		  cstr+="<button class='circle1' id='deliver' name='1' onclick='oderlistfind("+objArr["orderlist_no"]+",1);'>접수</button>" +
	    		  		"<button class='circle1' id='delivering name='2' onclick='oderlistfind("+objArr["orderlist_no"]+",2);'>배송중</button>" +
	    		  		"<button class='circle1' id='delivered' name='3' onclick='oderlistfind("+objArr["orderlist_no"]+",3);'>배송완료</button>"
	    	   }
	    		  cstr+="</div>"

	    		  cstr+="</div>"
	    	  });
	    	  $("#orderlist").html(cstr);
	      },
	      error:function(){
	    	  
	      }
	});
}

function oderlistuser(user_no){
	$("#password").hide();
    $("#menushow").hide();
    $("#infochange").hide();
    $("#marketshow").hide();
    $("#orderlist").show();
	$.ajax({
	      type:"POST",
	      url:"orderlist_user",
	      data:{"user_number":user_no},
	      dataType:"json",
	      success:function(data){
	    	  cstr="";
	    	  $(data.master_list).each(function(idx,objArr){
	    		  cstr+="<div class='card' style= 'width: 92%'>";
                  cstr+="<div class='card-body'>";
                      cstr+="<span>주문 시간/날짜:"+objArr["orderlist_title"]+"</span>";
                      if(objArr["orderlist_state"]=='0'){                
                    	  cstr+="<span style='margin: 10px; font-size: 15px;' class = 'text-info'>주문 접수</span>";
                      }else if(objArr["orderlist_state"]=='1'){
                    	  cstr+="<span style='margin: 10px; font-size: 15px;' class = 'text-info'>접수 완료</span>";
                      }else if(objArr["orderlist_state"]=='2'){
                    	  cstr+="<span style='margin: 10px; font-size: 15px;' class = 'text-info'>배송중</span>";
                      }else if(objArr["orderlist_state"]=='3'){
                    	  cstr+= "<span style='margin: 10px; font-size: 15px;' class = 'text-info'>배송 완료</span>";
                      }else if(objArr["orderlist_state"]=='4'){
                    	  cstr+= "<span style='margin: 10px; font-size: 15px;' class = 'text-info'>배달 완료</span>";
                      }else{
                    	  cstr+=  "<span style='margin: 10px; font-size: 15px;' class = 'text-info'>배달 취소</span>";
                      }
                      
                      cstr+="<div><img class='border rounded-0'><span style='font-size: 20px;'>메뉴명/가격:"+objArr["orderlist_content"]+"</span> &nbsp;";
                      cstr+="<div class='text-right'><span>합계: "+objArr["orderlist_pricetotal"]+"</span></div>";
                 cstr+="</div>";
              cstr+="</div>";
              cstr+="</div>";
	    	  });
	    	  $("#orderlist").html(cstr);
	      },
	      error:function(){
	    	  
	      }
	});

}

function oderlistfind(orderlist_no,state_value){
	location.href="statehandle?orderlist_no="+orderlist_no+"&state_value="+state_value;
}