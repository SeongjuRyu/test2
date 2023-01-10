//테이블 전체중 가게가 하나인 경우 전체목록이 안뜸.

inputIndex="";//현재 출력된 목록의 개수
isEnd =false
index=8;//처음에는 index가 8로 들어가고 이후에는 2씩 더해야 한다.
end=0;//index증가 끝낼곳 정하는 변수
add=0;//2씩 더해주기 위한 변수
ss="";
newIndex=0;
flag=0;
flag2=0;
flag3=0;//ajax로 목록 클릭할 경우 

$(document).ready(function(){

	$(document).scroll(function() {
		//inputIndex = $(".col-md-5").length;
		

		
		
	    var maxHeight = $(document).height();
	    var currentScroll = $(window).scrollTop() + $(window).height();
	    console.log("documentHeight:" + maxHeight + " | scrollTop:" + $(window).scrollTop() + " | windowHeight: " + $(window).height());
	    

	    if (flag3==0&&maxHeight <= currentScroll + 35) {

	    	  
		      if(isEnd == true||flag2==1){
		    	  return
		        }else{
		        	
		        	
			    	  index=index+add;	    	  
			    	  add=2;
			    	$.ajax({
					      type:"POST",
					      url:"category_output",
					      data:{
					    	  "start":index,
					    	  "end":end
					      },
					      dataType:"json",
					      success:function(data){
					    	  newIndex=data.category_menu.length 
					    	  
					    	  inputIndex=inputIndex+newIndex;
					    	  end=inputIndex;
					    	  
					   $(data.category_menu).each(function(idx,objArr){
						   
						   ss=objArr["cnt"]
						   //alert("끝"+" " +end+" "+"ajax들어갈 값 "+index+" "+"inputIndex"+inputIndex+""+"생기는 index"+data.category_menu.length+" "+flag )
						   //alert(inputIndex+" "+ss)
						   
						   

						   
						   if(inputIndex>ss){
							   isEnd=true;
							   flag2=1;
							   return false;
						   }
						   
						 if(flag==0){
						      if(objArr["market_no"]=="no"){
							    	 
						    	  
						    	  cstr="찾는 가게가 없습니다." 
							      $("#category_showme").html(cstr);
							        if(objArr["market_no2"]=="0"){
							        		 ClassChange($("#0"))
							        		 
							        }else if(objArr["market_category"]=="1"){
							        		 ClassChange($("#1"))
							        }else if(objArr["market_category"]=="2"){
							        		 ClassChange($("#2"))
							        }else if(objArr["market_category"]=="3"){
							        		 ClassChange($("#3"))
							        }else if(objArr["market_category"]=="4"){
							        		 ClassChange($("#4"))
							        }else if(objArr["market_category"]=="5"){
							        		ClassChange($("#5"))
							        }else if(objArr["market_category"]=="6"){
							        		 ClassChange($("#6"))
							        }else if(objArr["market_category"]=="7"){
							        		ClassChange($("#7"))
							        }else if(objArr["market_category"]=="8"){
							        		ClassChange($("#8"))
							        }else if(objArr["market_category"]=="9"){
							        		ClassChange($("#9"))
							        }
							        	 
						      }else if(objArr["market_no"]!="no"){
						         var cstr1="";
						         var cstr2="";
						         var cstr3="";
						         var cstr4="";//모든 목록 합치기
						         
						         var str1=0;
						         var str2=0;
						         var str3=0;
						         
						       
						         
						         $(data.category_menu).each(function(idx,objArr){
							        	 if(objArr["market_no2"]=="0"){
							        		 ClassChange($("#0"))
									        }else if(objArr["market_category"]=="1"){
									        		 ClassChange($("#1"))
									        }else if(objArr["market_category"]=="2"){
									        		 ClassChange($("#2"))
									        }else if(objArr["market_category"]=="3"){
									        		 ClassChange($("#3"))
									        }else if(objArr["market_category"]=="4"){
									        		 ClassChange($("#4"))
									        }else if(objArr["market_category"]=="5"){
									        		ClassChange($("#5"))
									        }else if(objArr["market_category"]=="6"){
									        		 ClassChange($("#6"))
									        }else if(objArr["market_category"]=="7"){
									        		ClassChange($("#7"))
									        }else if(objArr["market_category"]=="8"){
									        		ClassChange($("#8"))
									        }else if(objArr["market_category"]=="9"){
									        		ClassChange($("#9"))
									        }
							        	 
							        	 if(str1==0){
							        		 
								                cstr1+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
								                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
								                	  "<div class='row'>";
								                cstr1+="<div class='col-md-5'>" +
								                		"<div class='row' style='border: 1px solid;'>";
								                cstr1+="<div class='col' style='width: 120px;'>" +
								                
								                
								                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
								                "</div>";
								                cstr1+="<div class='col' style='height: 120px;'>";
								               
								                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
								                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
								                cstr1+="</div>";
								                
								                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
								                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
								                cstr1+="</div>";
								                
								                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
								                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
								                cstr1+="</div></a>";
								                
								                cstr1+="</div></div></div>";
								                cstr1+="<div class='col-md-1'></div>";
								                
								                str1=1;
								                str2=1;
								                str3+=1;
								                if(data.category_menu.length==1){
								                	cstr1+="</div></div></div>";
								                	 cstr3+=cstr1;
								                	 flag=1;
								                	 
								                	 return false //3 5 7 9 11
								                }
								                else if(str3%2==1&&str3!=1&&data.category_menu.length%str3==0){
								                	if(data.category_menu.length!=str3){
								                		
								                	}else{
								                		cstr4+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
									                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
									                	  "<div class='row'>";
									                cstr4+="<div class='col-md-5'>" +
									                		"<div class='row' style='border: 1px solid;'>";
									                cstr4+="<div class='col' style='width: 120px;'>" +
									                
									                
									                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
									                "</div>";
									                cstr4+="<div class='col' style='height: 120px;'>";
									               
									                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
									                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
									                cstr4+="</div>";
									                
									                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
									                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
									                cstr4+="</div>";
									                
									                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
									                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
									                cstr4+="</div></a>";
									                
									                cstr4+="</div></div></div></div></div></div>";
									                
									                cstr3+=cstr4;
									                cstr4="";
								                	}
								                	flag=1;
								                	
								                	
								                }
								                
								                
								        	 }else if(str2==1){
								        		 cstr2+="<div class='col-md-1'></div>" +
								               	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"
								               cstr2+="<div class='col-md-5'>" +
								               		"<div class='row' style='border: 1px solid;'>";
								               cstr2+="<div class='col' style='width: 120px;'>" +
								               "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
								               "</div>";
								               cstr2+="<div class='col' style='height: 120px;'>";
								              
								               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
								               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
								               cstr2+="</div>";
								               
								               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
								               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
								               cstr2+="</div>";
								               
								               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
								               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
								               cstr2+="</div></a>";
								               
								               cstr2+="</div></div></div></div></div></div>";
								               str1=0;
								               str2=0; 
								               str3+=1;
								              
								               
								               cstr3+=cstr1+" "+cstr2;
								               flag=1;
								               cstr1="";
								               cstr2="";
								        	 }
								        	
						        	 

						        	 

						            });
						        }
						      $("#category_showme").append(cstr3);
						 }else{
			        		 flag=0;
			        	 }

					      
					      
					   })
					      },error:function(){
					            
					         }
					      
					   });
		        }

		  }else if (flag3==1&&maxHeight <= currentScroll + 100) {
			  
		  }

	});	
	
	
    	  $.ajax({
		      type:"POST",
		      url:"category_output",
		      dataType:"json",
		      success:function(data){
		    	  inputIndex=data.category_menu.length
		    	  
		   $(data.category_menu).each(function(idx,objArr){

		      if(objArr["market_no"]=="no"){
		    	 
		    	  
		    	  cstr="찾는 가게가 없습니다." 
			      $("#category_showme").html(cstr);
			        if(objArr["market_no2"]=="0"){
			        		 ClassChange($("#0"))
			        		 
			        }else if(objArr["market_category"]=="1"){
			        		 ClassChange($("#1"))
			        }else if(objArr["market_category"]=="2"){
			        		 ClassChange($("#2"))
			        }else if(objArr["market_category"]=="3"){
			        		 ClassChange($("#3"))
			        }else if(objArr["market_category"]=="4"){
			        		 ClassChange($("#4"))
			        }else if(objArr["market_category"]=="5"){
			        		ClassChange($("#5"))
			        }else if(objArr["market_category"]=="6"){
			        		 ClassChange($("#6"))
			        }else if(objArr["market_category"]=="7"){
			        		ClassChange($("#7"))
			        }else if(objArr["market_category"]=="8"){
			        		ClassChange($("#8"))
			        }else if(objArr["market_category"]=="9"){
			        		ClassChange($("#9"))
			        }
			        	 
		      }else if(objArr["market_no"]!="no"){
		         var cstr1="";
		         var cstr2="";
		         var cstr3="";
		         var cstr4="";//모든 목록 합치기
		         
		         var str1=0;
		         var str2=0;
		         var str3=0;
		         
		         var test=1;
		         
		         $(data.category_menu).each(function(idx,objArr){
			        	 if(objArr["market_no2"]=="0"){
			        		 ClassChange($("#0"))
					        }else if(objArr["market_category"]=="1"){
					        		 ClassChange($("#1"))
					        }else if(objArr["market_category"]=="2"){
					        		 ClassChange($("#2"))
					        }else if(objArr["market_category"]=="3"){
					        		 ClassChange($("#3"))
					        }else if(objArr["market_category"]=="4"){
					        		 ClassChange($("#4"))
					        }else if(objArr["market_category"]=="5"){
					        		ClassChange($("#5"))
					        }else if(objArr["market_category"]=="6"){
					        		 ClassChange($("#6"))
					        }else if(objArr["market_category"]=="7"){
					        		ClassChange($("#7"))
					        }else if(objArr["market_category"]=="8"){
					        		ClassChange($("#8"))
					        }else if(objArr["market_category"]=="9"){
					        		ClassChange($("#9"))
					        }
			        	 
			        	 if(str1==0){
			        		 
				                cstr1+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
				                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
				                	  "<div class='row'>";
				                cstr1+="<div class='col-md-5'>" +
				                		"<div class='row' style='border: 1px solid;'>";
				                cstr1+="<div class='col' style='width: 120px;'>" +
				                
				                
				                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
				                "</div>";
				                cstr1+="<div class='col' style='height: 120px;'>";
				               
				                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
				                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
				                cstr1+="</div>";
				                
				                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
				                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
				                cstr1+="</div>";
				                
				                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
				                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
				                cstr1+="</div></a>";
				                
				                cstr1+="</div></div></div>";
				                cstr1+="<div class='col-md-1'></div>";
				                
				                str1=1;
				                str2=1;
				                str3+=1;
				                if(data.category_menu.length==1){
				                	cstr1+="</div></div></div>";
				                	 cstr3+=cstr1;
				                	 return false //3 5 7 9 11
				                }
				                else if(str3%2==1&&str3!=1&&data.category_menu.length%str3==0){
				                	if(data.category_menu.length!=str3){
				                		
				                	}else{
				                		cstr4+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
					                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
					                	  "<div class='row'>";
					                cstr4+="<div class='col-md-5'>" +
					                		"<div class='row' style='border: 1px solid;'>";
					                cstr4+="<div class='col' style='width: 120px;'>" +
					                
					                
					                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
					                "</div>";
					                cstr4+="<div class='col' style='height: 120px;'>";
					               
					                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
					                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
					                cstr4+="</div>";
					                
					                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
					                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
					                cstr4+="</div>";
					                
					                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
					                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
					                cstr4+="</div></a>";
					                
					                cstr4+="</div></div></div></div></div></div>";
					                
					                cstr3+=cstr4;
					                cstr4="";
				                	}
				                	
				                }
				                
				                
				        	 }else if(str2==1){
				        		 cstr2+="<div class='col-md-1'></div>" +
				               	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"
				               cstr2+="<div class='col-md-5'>" +
				               		"<div class='row' style='border: 1px solid;'>";
				               cstr2+="<div class='col' style='width: 120px;'>" +
				               "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
				               "</div>";
				               cstr2+="<div class='col' style='height: 120px;'>";
				              
				               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
				               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
				               cstr2+="</div>";
				               
				               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
				               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
				               cstr2+="</div>";
				               
				               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
				               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
				               cstr2+="</div></a>";
				               
				               cstr2+="</div></div></div></div></div></div>";
				               str1=0;
				               str2=0; 
				               str3+=1;
				              
				               
				               cstr3+=cstr1+" "+cstr2;
				               
				               cstr1="";
				               cstr2="";
				        	 }
				        	 test=test+1
		        	 

		        	 

		            });
		        }
		      $("#category_showme").html(cstr3);
		      
		      
		   })
		      },error:function(){
		            
		         }
		      
		   });
      
			
		    
		    

	

	
	 });





	
	$("div[class=card-header]").find('ul>li>a').on("click",function(){
		flag3=1;
		inputIndex="";//현재 출력된 목록의 개수
		isEnd =false
		index=8;//처음에는 index가 8로 들어가고 이후에는 2씩 더해야 한다.
		end=0;//index증가 끝낼곳 정하는 변수
		add=0;//2씩 더해주기 위한 변수
		ss="";
		newIndex=0;
		flag=0;
		flag2=0;
		
		
		ClassChange($(this))
		menu=$(this).attr("id")
		$(this).css({'font-size': '28px',"color": "rgb(0,0,255)"})
		$('div[class=card-header]').find('ul>li>a').not(this).css({"font-size": "28px","color": "rgb(0,0,0)"})
		
		
			$.ajax({
			
				      type:"POST",
				      url:"category_output",
				      data:{
				    	  "menu":menu,
				    	  "flag":flag3,
				      },
				      dataType:"json",
				      success:function(data){
				  $(data.category_menu).each(function(idx,objArr){
					  if((data.category_menu.length%2)!=0){//전체 개수가 홀수인경우
						  var len = 1;
							  if(len == data.category_menu.length){//개수가 하나일때
						         var cstr="";
						         /////////////////////////////////
					        	 if(objArr["market_no"]=="no"){
					        		 	 cstr="찾는 가게가 없습니다."
					        			 $("#category_showme").html(cstr);
					        	 }else if(objArr["market_no"]!="no"){
					        		 
						         $(data.category_menu).each(function(idx,objArr){


							                cstr+="<div><div class='container-fluid' style='margin-top: 45px;'><div class='row'>";
							                cstr+="<div class='col-md-5'>" +
							                "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
							                "<div class='row' style='border: 1px solid;'>";
							                cstr+="<div class='col' style='width: 120px;'>" +
							                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
							                "</div>";
							                cstr+="<div class='col' style='height: 120px;'>";
							               
							                cstr+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
							                cstr+="</div>";
							                
							                cstr+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
							                cstr+="</div>";
							                
							                cstr+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
							                cstr+="</div>";
							                
							                cstr+="</div></div></div></div></a></div></div></div>";
							                cstr+="<div class='col-md-1'></div>";

						            });
						         
						         $("#category_showme").html(cstr);
						         
						         
					        	 	}
					        	 
							  }//개수가 하나일때
						  
						//len == data.category_menu.length에서 1개보다 길이가 클경우
							  else if(len < data.category_menu.length){
				        	 		 var cstr1="";//왼쪽
							         var cstr2="";//오른쪽
							         var cstr3="";//왼쪽 목록과 오른쪽 목록을 더한다.
							         var cstr4="";//모든 목록 합치기
							         
							         var str1=0;//flag1
							         var str2=0;//flag2
							         var str3=0;
						         $(data.category_menu).each(function(idx,objArr){
						        	 
						        	 if(str1==0){//1개보다 많을경우 왼쪽 우선
							                cstr1+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
							                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
							                	  "<div class='row'>";
							                cstr1+="<div class='col-md-5'>" +
							                		"<div class='row' style='border: 1px solid;'>";
							                cstr1+="<div class='col' style='width: 120px;'>" +
							                
							                
							                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
							                "</div>";
							                cstr1+="<div class='col' style='height: 120px;'>";
							               
							                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
							                cstr1+="</div>";
							                
							                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
							                cstr1+="</div>";
							                
							                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
							                cstr1+="</div></a>";
							                
							                cstr1+="</div></div></div>";
							                cstr1+="<div class='col-md-1'></div>"
							                str1=1;
							                str2=1;
							                str3+=1;
							                
							                //홀수 개가 있을때는 cstr1은 들어가지 않고 cstr4가 들어간다.
							                if(str3%2==1&&str3!=1&&data.category_menu.length%str3==0){
							                	if(data.category_menu.length!=str3){//str3의 배수로 length가 나눠졌을때의 조건을 추가
							                		
							                	}else{
							                	
							                	cstr4+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
							                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
							                	  "<div class='row'>";
							                cstr4+="<div class='col-md-5'>" +
							                		"<div class='row' style='border: 1px solid;'>";
							                cstr4+="<div class='col' style='width: 120px;'>" +
							                
							                
							                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
							                "</div>";
							                cstr4+="<div class='col' style='height: 120px;'>";
							               
							                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
							                cstr4+="</div>";
							                
							                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
							                cstr4+="</div>";
							                
							                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
							                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
							                cstr4+="</div></a>";
							                
							                cstr4+="</div></div></div></div></div></div>";
							                
							                cstr3+=cstr4;
							                cstr4="";
							                	}
							                }
							              
							        	 }else if(str2==1){//왼쪽 나온후 오른쪽
							        	
							        		 cstr2+="<div class='col-md-1'></div>" +
							               	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"
							               cstr2+="<div class='col-md-5'>" +
							               		"<div class='row' style='border: 1px solid;'>";
							               cstr2+="<div class='col' style='width: 120px;'>" +
							               "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
							               "</div>";
							               cstr2+="<div class='col' style='height: 120px;'>";
							              
							               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
							               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
							               cstr2+="</div>";
							               
							               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
							               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
							               cstr2+="</div>";
							               
							               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
							               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
							               cstr2+="</div></a>";
							               
							               cstr2+="</div></div></div></div></div></div>";
							               str1=0;
							               str2=0;
							               str3+=1;
							               cstr3+=cstr1+" "+cstr2;//오른쪽 훌력후 서로 합치는 작업
							               cstr1="";
							               cstr2="";
							        	 	}
						            });
				        	 	}
						    
					  }else{//(data.category_menu.length%2)!=0 의 else 즉 짝수 일때
						  
						  if(objArr["market_no"]=="no"){
			        		 	 cstr="찾는 가게가 없습니다."
			        			 $("#category_showme").html(cstr);
			        	 }else if(objArr["market_no"]!="no"){
			        		 var cstr1="";
					         var cstr2="";
					         var cstr3="";
					         var str1=0;//flag1
					         var str2=0;//flag2
				         $(data.category_menu).each(function(idx,objArr){
				        	 if(str1==0){
					                cstr1+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
					                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
					                	  "<div class='row'>";
					                cstr1+="<div class='col-md-5'>" +
					                		"<div class='row' style='border: 1px solid;'>";
					                cstr1+="<div class='col' style='width: 120px;'>" +
					                
					                
					                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
					                "</div>";
					                cstr1+="<div class='col' style='height: 120px;'>";
					               
					                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
					                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
					                cstr1+="</div>";
					                
					                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
					                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
					                cstr1+="</div>";
					                
					                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
					                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
					                cstr1+="</div></a>";
					                
					                cstr1+="</div></div></div>";
					                cstr1+="<div class='col-md-1'></div>"
					                str1=1;
					                str2=1;
					                
					        	 }else if(str2==1){
						        		 cstr2+="<div class='col-md-1'></div>" +
					               	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"
					               cstr2+="<div class='col-md-5'>" +
					               		"<div class='row' style='border: 1px solid;'>";
					               cstr2+="<div class='col' style='width: 120px;'>" +
					               "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
					               "</div>";
					               cstr2+="<div class='col' style='height: 120px;'>";
					              
					               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
					               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
					               cstr2+="</div>";
					               
					               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
					               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
					               cstr2+="</div>";
					               
					               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
					               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
					               cstr2+="</div></a>";
					               
					               cstr2+="</div></div></div></div></div></div>";
					               str1=0;
					               str2=0; 
					               cstr3+=cstr1+" "+cstr2;
					               cstr1="";
					               cstr2="";
					        	 }

				        	

				            });
			        	 	}
					  }
			        	 $("#category_showme").html(cstr3);
				    })
				         },
				         error:function(){
				            
				         }
				   });
		 

	});
	$("#nowlocation").click(function(){
		// Geolocation API에 액세스할 수 있는지를 확인
		if (navigator.geolocation) {
			//위치 정보를 정기적으로 얻기
			var id = navigator.geolocation.watchPosition(
					function(pos) {
						latitude=pos.coords.latitude;
						longitude=pos.coords.longitude; 
						backgeocoding(latitude,longitude);
					});
			setTimeout(function() { navigator.geolocation.clearWatch(id)}, 10000);
		} else {
			alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.");
		}
	});
	function backgeocoding(latitude,longitude){
		var geocoder = new daum.maps.services.Geocoder();

		var coord = new daum.maps.LatLng(latitude,longitude);
		var callback = function(result, status) {
		    if (status === daum.maps.services.Status.OK) {
		        $("#nowlocation").val(result[0].address.address_name);
		    }
		};

		geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
	}	
	


	//목록 class 초기화
	function ClassChange($value=ss){

		$.each($("div[class=card-header]").find('ul>li>a'),function(i){
		  $(this).attr("class", "nav-link");
		 	
	});
		$value.attr("class","nav-link active")
		$value.css({'font-size': '28px',"color": "rgb(0,0,255)"})
		$('div[class=card-header]').find('ul>li>a').not($value).css({"font-size": "28px","color": "rgb(0,0,0)"})

}

function category_value(value){
	location.href="category_detail?value="+value
}

$("#nowmap").click(function(){
	market_category=$(".nav-link.active").attr("id")//현재 클릭된 목록
	$.ajax({
	      type:"POST",
	      url:"category_Mappingout",
	      data:{
	    	  "market_category":market_category,"market_address":$("#nowlocation").val()
	      },
	      dataType:"json",
	      
	      success:function(data){
	    	  var cstr1="";
		      var cstr2="";
		      var cstr3="";
		      var cstr4="";
		      
		      var str1=0;
		      var str2=0;
		      var str3=0;
	    	  $(data.category_menu).each(function(idx,objArr){
		        if(objArr["market_no"]=="no"){
			    	  cstr3="찾는 가게가 없습니다." 
					   $("#category_showme").html(cstr3);
	    		  }else if(objArr["market_no"]!="no"){
	    		  	    	
	    		  if(str1==0){
		                cstr1+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
		                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
		                	  "<div class='row'>";
		                cstr1+="<div class='col-md-5'>" +
		                		"<div class='row' style='border: 1px solid;'>";
		                cstr1+="<div class='col' style='width: 120px;'>" +
		                
		                
		                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
		                "</div>";
		                cstr1+="<div class='col' style='height: 120px;'>";
		               
		                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
		                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
		                cstr1+="</div>";
		                
		                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
		                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
		                cstr1+="</div>";
		                
		                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
		                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
		                cstr1+="</div></a>";
		                
		                cstr1+="</div></div></div>";
		                cstr1+="<div class='col-md-1'></div>";
		                str1=1;
		                str2=1;
		                str3+=1;
		                
		                if(data.category_menu.length==1){
		                	cstr1+="</div></div></div>";
		                	 cstr3+=cstr1;
		                	 return false //3 5 7 9 11
		                }
		                else if(str3%2==1&&str3!=1&&data.category_menu.length%str3==0){
		                	if(data.category_menu.length!=str3){
		                		
		                	}else{
		                		cstr4+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
			                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
			                	  "<div class='row'>";
			                cstr4+="<div class='col-md-5'>" +
			                		"<div class='row' style='border: 1px solid;'>";
			                cstr4+="<div class='col' style='width: 120px;'>" +
			                
			                
			                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
			                "</div>";
			                cstr4+="<div class='col' style='height: 120px;'>";
			               
			                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
			                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
			                cstr4+="</div>";
			                
			                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
			                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
			                cstr4+="</div>";
			                
			                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
			                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
			                cstr4+="</div></a>";
			                
			                cstr4+="</div></div></div></div></div></div>";
			                
			                cstr3+=cstr4;
			                cstr4="";
		                	}
		                	
		                }

		        	 }else if(str2==1){
		        		 cstr2+="<div class='col-md-1'></div>" +
		               	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"
		               cstr2+="<div class='col-md-5'>" +
		               		"<div class='row' style='border: 1px solid;'>";
		               cstr2+="<div class='col' style='width: 120px;'>" +
		               "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
		               "</div>";
		               cstr2+="<div class='col' style='height: 120px;'>";
		              
		               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
		               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
		               cstr2+="</div>";
		               
		               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
		               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
		               cstr2+="</div>";
		               
		               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
		               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
		               cstr2+="</div></a>";
		               
		               cstr2+="</div></div></div></div></div></div>";
		               str1=0;
		               str2=0; 
		               str3+=1;
		               cstr3+=cstr1+" "+cstr2;

		               cstr1="";
		               cstr2="";
		        	 }
	    		  
	    		  }
		        
	    	  });
	    	  
	    	  $("#category_showme").html(cstr3);
	      },
	      error:function(){
	    	  $("#category_showme").html("응 에러야");
	      }
	});
});

$("#nowsearch").click(function(){
	market_category=$(".nav-link.active").attr("id")

	$.ajax({
	      type:"POST",
	      url:"category_Searchout",
	      data:{
	    	  "market_category":market_category,"market_name":$("#nowirum").val()
	      },
	      dataType:"json",
	      success:function(data){
	    	  var cstr1="";
		      var cstr2="";
		      var cstr3="";
		      var cstr4="";
		      var str1=0;
		      var str2=0;
		      var str3=0;
		      var no="";


	    	  $(data.category_menu).each(function(idx,objArr){
	    		  if(objArr["market_no"]=="no"){
			    	  cstr3="찾는 가게가 없습니다." 
					  $("#category_showme").html(cstr3);
	    		  }else if(objArr["market_no"]!="no"){

	    		  if(str1==0){
	    			  
		                cstr1+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
		                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
		                	  "<div class='row'>";
		                cstr1+="<div class='col-md-5'>" +
		                		"<div class='row' style='border: 1px solid;'>";
		                cstr1+="<div class='col' style='width: 120px;'>" +
		                
		                
		                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
		                "</div>";
		                cstr1+="<div class='col' style='height: 120px;'>";
		               
		                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
		                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
		                cstr1+="</div>";
		                
		                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
		                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
		                cstr1+="</div>";
		                
		                cstr1+="<div class='row' style='width: 450px;height: 40px;'>";
		                cstr1+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
		                cstr1+="</div></a>";
		                
		                cstr1+="</div></div></div>";
		                cstr1+="<div class='col-md-1'></div>";
		                
		                str1=1;
		                str2=1;
		                str3+=1;
		                
		                
		                if(data.category_menu.length==1){
		                	cstr1+="</div></div></div>";
		                	 cstr3+=cstr1;
		                	 return false //3 5 7 9 11
		                }
		                else if(str3%2==1&&str3!=1&&data.category_menu.length%str3==0){
		                	if(data.category_menu.length!=str3){
		                		
		                	}else{
		                		cstr4+="<div><div class='container-fluid' style='margin-top: 45px;'>" +
			                	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"+
			                	  "<div class='row'>";
			                cstr4+="<div class='col-md-5'>" +
			                		"<div class='row' style='border: 1px solid;'>";
			                cstr4+="<div class='col' style='width: 120px;'>" +
			                
			                
			                "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
			                "</div>";
			                cstr4+="<div class='col' style='height: 120px;'>";
			               
			                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
			                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
			                cstr4+="</div>";
			                
			                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
			                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
			                cstr4+="</div>";
			                
			                cstr4+="<div class='row' style='width: 450px;height: 40px;'>";
			                cstr4+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
			                cstr4+="</div></a>";
			                
			                cstr4+="</div></div></div></div></div></div>";
			                
			                cstr3+=cstr4;
			                cstr4="";
		                	}
		                	
		                }
		                
		        	 }else if(str2==1){
		        		 cstr2+="<div class='col-md-1'></div>" +     
		               	  "<a href='javascript:category_value("+objArr["market_no"]+")'>"
		               cstr2+="<div class='col-md-5'>" +
		               		"<div class='row' style='border: 1px solid;'>";
		               cstr2+="<div class='col' style='width: 120px;'>" +
		               "<img style='width: 120px;height: 120px;margin-top: 5px;' src='/img/upload/"+objArr["market_image"]+"'>" +
		               "</div>";
		               cstr2+="<div class='col' style='height: 120px;'>";
		              
		               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
		               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_name"]+"</label></div>";
		               cstr2+="</div>";
		               
		               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
		               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_tel"]+"</label></div>";
		               cstr2+="</div>";
		               
		               cstr2+="<div class='row' style='width: 450px;height: 40px;'>";
		               cstr2+="<div class='col'><label class='col-form-label'>"+objArr["market_address"]+"</label></div>";
		               cstr2+="</div></a>";
		               
		               cstr2+="</div></div></div></div></div></div>";
		               str1=0;
		               str2=0; 
		               cstr3+=cstr1+" "+cstr2;
		               cstr1="";
		               cstr2="";
		               str3+=1;
		        	 }
	    		  
	    		  
	    		  }
	    		 
	    	  });
	    	  $("#category_showme").html(cstr3); 
	      },
	      error:function(){
	    	  $("#category_showme").html("응 에러야");
	      }
	});
});

