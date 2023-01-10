$(document).ready(function(){
	
	//회원가입 취소 버튼
	$("#sign_cancel").on("click",function(){
		location.href="sign_cancel";
	})
	//이메일 중복체크
	
	var regExp = /[0-9a-zA-Z][_0-9a-zA-Z-]*@[_0-9a-zA-Z-]+(\.[_0-9a-zA-Z-]+){1,2}$/;
	$("#sign_email").on("keyup", function() {
		var id = $('#sign_email').val();
		
		$.ajax({
			url : 'check',
			type : 'POST',
			dataType:"json",
			data : {
				"e_id" : id
			},
			success : function(data) {
				if ($.trim(data) == 0) {
					if(!id.match(regExp)){
						$('#chkMsg').html("아이디를 정확히 입력하시오");
						$("#sign_email").focus();
						idflag=2;
						return;
					}
					$('#chkMsg').html("사용가능한 아이디 입니다");
					idflag=1
				} else {
					$('#chkMsg').html("사용이 불가능한 아이디 입니다");
					idflag=0
				}
			},
			error : function() {
				alert("에러입니다");
			}
		});
	});
	
	//비밀번호 확인
	  $("#sign_password").on("keyup",function(){
          $('#chkPwdMsg').html("");
       })
       
       $("#sign_repassword").on("keyup",function(event){
          
          if($("#sign_password").val()!=$("#sign_repassword").val()){
             flag=0;
             $('#chkPwdMsg').html("비밀번호를 확인해주세요");
          }else{
        	 flag=1;
             $('#chkPwdMsg').html("비밀번호가 일치합니다");
          }
       });
	  
    //체크박스
	    //라디오 요소처럼 동작시킬 체크박스 그룹 셀렉터
	    $('input[type="checkbox"][name="sign_select"]').click(function(){
	        //클릭 이벤트 발생한 요소가 체크 상태인 경우
	    	//alert($(this).val()+"첫번째");
	    	//prop 속성값을 가져온다.
	        if ($(this).prop('checked')) {//체크 안되있으면 true 체크 되있으면 false
	            //체크박스 그룹의 요소 전체를 체크 해제후 클릭한 요소 체크 상태지정
	            $('input[type="checkbox"][name="sign_select"]').prop('checked', false);
	            $(this).prop('checked', true);
	            //alert($(this).val()+"두번째");
	            
	        }
	    });

	    
	    $("#sign_phone").on('keyup', function(e){
	      	// 숫자만 입력받기
	        var trans_num =  $(this).val($(this).val().replace(/[^0-9]/g,""));
	    		var k = e.keyCode;
	    				
	    		if(trans_num.length >= 11 && ((k >= 48 && k <=126) || (k >= 12592 && k <= 12687 || k==32 || k==229 || (k>=45032 && k<=55203)) ))
	    		{
	    			e.preventDefault();
	    		}
	      }).on('blur', function(){
	      if($(this).val() == '') return;//커서가 다른곳에 있을때
	    				
	            var trans_num = $(this).val().replace(/-/gi,'');
	            if(trans_num != null && trans_num != '')
	            {
	                if(trans_num.length==11 || trans_num.length==10) 
	                {   
	                    var regExp_ctn = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})([0-9]{3,4})([0-9]{4})$/;
	                    if(regExp_ctn.test(trans_num))
	                    {
	                        trans_num = trans_num.replace(/^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?([0-9]{3,4})-?([0-9]{4})$/, "$1-$2-$3");                  
	                        $(this).val(trans_num);
	                        alert($(this).val(trans_num))
	                    }
	                    else
	                    {
	                        alert("유효하지 않은 전화번호 입니다.");
	                        $(this).val("");
	                        $(this).focus();
	                    }
	                }
	                else 
	                {
	                    alert("유효하지 않은 전화번호 입니다.");
	                    $(this).val("");
	                    $(this).focus();
	                }
	            }
	      });  

       
	//회원추가
	$("#sign_up").on("click",function(){
		id=$("#sign_email").val();
		
		pwd=$("#sign_password").val();
		repwd=$("#sign_password").val();
		
		name=$("#sign_name").val();
		phone=$("#sign_phone").val();
		
			//우편번호
		//postcode=$("#postcode").val();
		address=$("#address").val();
		detailAddr=$("#detailAddress").val();
		extraAddr=$("#extraAddress").val();
		
		select_jik=$('input:checkbox[name="sign_select"]:checked').val();
	
		Alladdress=$("#sign_address").val(address+" "+detailAddr+" "+extraAddr);
		
		
		if(id==""){
			alert("아이디를 입력해주세요");
			$("#sign_email").focus();
		}else if(idflag==0||idflag==2){
			alert("아이디를 확인해주세요")
			$("#sign_email").focus();
		}else if(pwd==""){
			alert("비밀 번호를 입력해주세요");
			$("#sign_password").focus();
		}else if((pwd!=""&& flag==0)||repwd==""){
			alert("비밀번호가 맞는지 확인해주세요")
			$("#sign_repassword").val("");
			$("#sign_repassword").focus();
		}else if(name==""){
			alert("이름을 입력해주세요");
			$("#sign_name").focus();
		}else if(phone==""){
			alert("핸드폰 번호를 입력해주세요");
			$("#sign_phone").focus();
		}else if(address==""||detailAddress==""){
			alert("주소를 입력해주세요")
			$("#postcode").focus();
		}else if(select_jik==""){
			alert("선택하셔야 합니다");
		}else{
			if(select_jik==1){
				$("#sign_email").attr("name","master_id");
				$("#sign_password").attr("name","master_passwd");
				$("#sign_name").attr("name","master_name");
				$("#sign_phone").attr("name","master_phone");
				$("#sign_address").attr("name","master_address");
				$("input:checkbox[name='sign_select']").attr("name", "master_gubun"); 
		
				$("#Sign_up").attr("action", "Sign_up_Master");
				$("#Sign_up").submit();
				alert(id+" "+ pwd+""+name+""+phone+""+Alladdress+""+select_jik)
			}else if(select_jik==0){
				$("#sign_email").attr("name","user_id");
				$("#sign_password").attr("name","user_passwd");
				$("#sign_name").attr("name","user_name");
				$("#sign_phone").attr("name","user_phone");
				$("#sign_address").attr("name","user_address");
				$("input:checkbox[name='sign_select']").attr("name", "user_gubun");
				alert(id+" "+ pwd+""+name+""+phone+""+Alladdress+""+select_jik)
		
				$("#Sign_up").attr("action", "Sign_up_User");
				$("#Sign_up").submit();
			}	
		
		}
		
		
	});
	
});

