function menu(master_market){
      $("#password").hide();
      $("#marketshow").hide();
      $("#infochange").hide();
      $("#menushow").show();
      $("#orderlist").hide();
   
	$.ajax({
		type:"post",
		url:"InfoUpdate",
		data:{"master_market":master_market},
		dataType:"json",
		success:function(data){
			//var menu_no = "";
			var str = "<div class='team-grid'><div class='container'><div class='row people'>";
			$(data.menulists).each(function(idx,objArr){
				//menu_no += objArr["menu_no"];
				str +="<tbody>";
				str +="<tr><td><div class='col-md-4 col-lg-3 item'><div class='box'><div class='cover'>";
				str +="<h3 class='name'>" + objArr["menu_name"] + "</h3>";
				str +="<a href='javascript:go_menuupdate("+objArr["menu_no"]+")' id='d_market_no'>수정</a>";
				str +="/"
				str +="<a href='javascript:go_controller("+objArr["menu_no"]+")' id='d_menu_no1'>삭제</a>";
				str +="</div></div></div></td></tr>";
				str +="</tbody>";
			});
				
			str += "</div></div></div>";
			$("#menu_ShowData").html(str);
		},
		error:function(){
			$("#menu_ShowData").text("에러 발생");
		}
	})
}

function go_controller(no){
	if (confirm("정말 삭제하시겠습니까??") == true){    //확인
		location.href="delete_menudata?no="+no;
	}else{   //취소
		return;
	}
	
}

function go_menuupdate(no){
	location.href="update_menu?no="+no;
}