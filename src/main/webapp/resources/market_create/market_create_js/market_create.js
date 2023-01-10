    $(document).ready(function(){
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
    	   		var time2 = $("#market_time2 option:selected").val();
    	   		$("#time2").val()==time2;
    	   		var time3 = $("#market_time3 option:selected").val();
    	   		$("#time3").val()==time3;
    	   		var time4 = $("#market_time4 option:selected").val();
    	   		$("#time4").val()==time4;
    	 		$("#totime").val(time1+":"+time2+"~"+time3+":"+time4)
    	 		
    	 		var ftype = $("#foodtype option:selected").val();
	   			$("#food_type").val() == ftype;
	   			$("#category").val(ftype);
    	 		
    			document.getElementById('market_createdata').submit();
    		}
    	})
    	
    	$("#btn_cancle").click(function(){
    		history.back();
    	})
//    $("#market_img").on("change", handleImgFileSelect);
    
    	
    });
// function handleImgFileSelect(e) {
//		var files = e.target.files;
//		var filesArr = Array.prototype.slice.call(files);
//
//		filesArr.forEach(function(f) {
//			if (!f.type.match("image.*")) {
//				alert("확장자는 이미지 확장자만 가능합니다.");
//				return;
//			}
//
//			sel_file = f;
//
//			var reader = new FileReader();
//			reader.onload = function(e) {
//				$('#img').attr('src', e.target.result);
//			}
//			reader.readAsDataURL(f);
//		});
//	}