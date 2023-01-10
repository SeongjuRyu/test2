$(document).ready(function(){
	//아이디 찾기 확인
	$("#btnId_Ok").on("click",function(){
		name=$("#IdFind_Name").val();
		phone=$("#IdFind_Phone").val();
		
		
		if(name==""){
			alert("이름을 입력해주세요")
		}else if(phone==""){
			alert("핸드폰번호를 입력하세요")
		}else{
		
		$("#Id_find").submit();
	}
			
	});
	
	//비밀 번호 찾기 확인
	$("#btnPwd_Ok").on("click",function(){
		id=$("#PwdFind_Id").val();
		Name=$("#PwdFind_Name").val();
		
		if(id==""){
			alert("아이디를 입력해주세요")
		}else if(Name==""){
			alert("이름을 입력해주세요")
		}else{
			$("#Pwd_find").submit();
		}
	});
	  	    
	$("#IdFind_Phone").on('keyup', function(e){
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


	
});

