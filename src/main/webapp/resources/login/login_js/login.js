$(document).ready(function(){
	

	
	//login.jsp에서 로그인 버튼
	$("#btn_Login").on("click",function(){
		id=$("#login_id").val();
		pwd=$("#login_password").val();
		var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
		
		if(id==""){
			alert("아이디를 입력해주세요");
			$("#login_id").focus();
		}
		else if(pwd==""){
			alert("비밀번호를 입력해 주세요")
			$("#login_password").focus();
		}
		else if(!id.match(regExp)){
			alert("아이디를 정확하게 입력하시오 ");
			$("$login_id").focus();	
		}else{
			$.ajax({
				type:'POST',
				url:'login',
				data:{"email":id,"password":pwd},
				dataType:"json",
				success:function(data){
					if(data.datas.length>=1){
						location.href="main_menu";
					}else{
						alert("아이디 및 비밀번호를 확인해주세요")
					}
				},error :function(){
					alert("에러입니다");
				}
			})
			
		}
	});
	//회원가입 창으로 이동
	$("#sign_up").on("click",function(){
		location.href="sign_up";
	});
	//취소 버튼
	$("#btn_Cancel").on("click",function(){
		location.href="main_menu"
	})
	//아이디  및 비밀번호 찾기로 이동
	$("#search_id").on("click",function(){
		location.href="IdPwd_Find"
	})
	
});