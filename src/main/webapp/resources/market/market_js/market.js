function market(master_market){
	      $("#password").hide();
	      $("#menushow").hide();
	      $("#infochange").hide();
	      $("#marketshow").show();
	      $("#orderlist").hide();
	$.ajax({
		type:"post",
		url:"market",
		data:{"master_market":master_market},
		dataType:"json",
		success:function(data){
			var str = "<div class='team-grid'><div class='container'><div class='row people'>";
			$(data.marketlists).each(function(idx,objArr){
				str +="<tbody>";
				str +="<tr><td><div class='col-md-4 col-lg-3 item'><div class='box'><div class='cover'>";
				str +="<h3 class='name'>" + objArr["market_name"] + "</h3>";
				str +="<a href='javascript:go_update("+objArr["market_no"]+")' id='d_market_no'>수정</a>";
				str +="/"
				str +="<a href='javascript:go_controller("+objArr["market_no"]+")' id='d_market_no'>삭제</a>";
				str +="</div></div></div></td></tr>";
				str +="</tbody>";
				return false;
			});
				
			str += "</div></div></div>";
			$("#market_ShowData").html(str);
		},
		error:function(){
			$("#market_ShowData").text("에러 발생");
		}
		})
	}

function go_controller(no){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
		location.href="delete_marketdata?no="+no;
	}else{   //취소
		return;
	}
	
}

function go_update(no){
		location.href="update_market?no="+no;
}