$(document).ready(function(){
	
	$("#divMenu").hide()
	
//메인으로 이동할때
$("#back").on("click",function(){
	location.href="menu_back";
})

// <!-- 메뉴 클릭했을때!!!!! -->	
$("#btnMenu").click(function(){
	menu=$("#market_no").val();
	var promise = $.ajax({  
		type: "POST",

		url: "category_detail_menu",

		dataType: "json",		

		data:{"value":menu} 
	});
	
	promise.done(successFunction);

	promise.fail(failFunction);
	
});	
// <!-- 메뉴 끝 -->


	//리뷰 클릭 이벤트
	$("#divReview").hide()
	$("#btnReview").click(function() {
		var readsent_market=$("#readsent_check").val()
		$("#divMenu").hide()
		$("#divReview").slideToggle('slow')
		$.ajax({
		      type:"POST",
		      url:"readsent_show",
		      data:{"readsent_market":readsent_market},
		      dataType:"json",
		      success:function(data){
		    	  cstr="";
		    	  $(data.readsent_data).each(function(idx,objArr){
		    		  cstr+="<div class='row' style='margin-top:100px; margin-left: 30px' id='divMenu'>";
		    		  cstr+="<div class='media'>"
		    		  cstr+="<div class='media-body'>"
		    		cstr+="<div class='col'>"
		    			  for(i=0;i<objArr["readsent_star"];i++){
		    				  if(objArr["readsent_star"]==0){
		    					  return false;
		    				  }
		    				  cstr+="<i class='fa fa-star'></i>"
		    			  }
		    		  cstr+="</div>"
		    		  
		    		  cstr+="<h5 class='mt-0' style='margin-top:10px !important'>작 성 자 : <label id='lblId'>"+objArr["readsent_id"]+"</label>" +
		    		  		"<label style='margin-left:650px'>등록날짜 : </label> <label id='lblDay' >"+objArr["readsent_day"]+"</label></h5>";
					  cstr+="<h5 class='mt-0' style='margin-top:30px !important'></h5>"
					  cstr+="</div>"
					  cstr+="</div>"
					  cstr+="<div>"
					  cstr+="<textarea cols = '170' rows='4' readonly='readonly'>"+objArr["readsent_content"]+"</textarea>"
					  cstr+="</div>"    	
	                cstr+="</div>"  
		    	  });
		    	  $("#readsentshow").html(cstr);
		      },
		      error:function(){
		    	  
		      }
			});
	})
	
	//댓글 별 클릭 이벤트
	$('.starR').click(function(){
		$(this).parent().children('span').removeClass('on');
		var value=$(this).attr("id")
		star=$("#readsent_star").val(value);
		$(this).addClass('on').prevAll('span').addClass('on');
		  return false;
	});
	$("#reviewSubmit").on("click",function(){
		if($("#readsent_content").val()==""){
			alert("글을 입력해주세요")
		}else{
			$("#readsentInput").submit();
		}
	});


	//모달안에 있는 가격의 합
	GloPrice="";
	//주문등록 되는 모달의 DB에서의 No(menu_no)
	GloNo="";
	
	$('#modal-testNew').on('show.bs.modal', function (event) {
		
		  var event = $(event.relatedTarget) // Button that triggered the modal
		  var name = event.data('name') // Extract info from data-* attributes
		  var price= event.data("price");
		  GloPrice=price;//모달의 가격을 얻는다.
		  var image= event.data("image");
		  var row_price=event.data("rowprice")
		  var text="(최소 : "+row_price+"원 이상)"
		  
		  GloNo=event.data("no");
		  var modal = $(this)
		  
		  modal.find('.modal-body #name').html(name);
		  modal.find('.modal-body #price').html(price);
		  modal.find('.modal-body #input-quantity').val("1");
		  modal.find('.modal-body #menu_price').text(price*1);
		  modal.find('.modal-body #modal_rowprice').html(text);
		  
		 $(".modal-body #images").attr("src", "/img/upload/"+image);
		 
		})

//modal에서의 버튼 함수
	$("#Ordertable").on("click",function(){
		
		num=$('#input-quantity').val();//모달 내부에서의 수량
		name=$('.modal-body #name').text();//모달 내부에서의 이름
		price=$('.modal-body #menu_price').text();//모달 내부에서의 가격
		modalprice=$('.modal-body #price').text();//modal내부에서 계산되는 개수*가격
		$('#modal-testNew').modal('hide');


		
		flag=0;
		count=0;
		//누르기 전에 똑같은 name이 있는지 확인
		if($("#ordername").length==0){
			
			var str="";
			str+="<li class='list-group-item clearfix' id='menu"+GloNo+"'>"
				
			str+="<div class='row'>"
			str+="<div class='menu-name ng-binding' id='ordername'>"+name+"</div>"
			
			str+= "<div>"
				
			str+="<div class='col-xs-6 pull-left'>"
				
			str+="<button type='button' class='btn pull-right' onclick='closes("+GloNo+")'>×</button>"
			str+=	"<span id='allprice"+GloNo+"' name='allprice'class='order-price ng-binding' >"+price+"</span>"
			
			str+="</div>"
				
			str+="<div class=' mmosolution-quantity-container' style='width: 100%;'>"
			str+=   "<div class='input-group'>"
			str+=           "<span class='input-group-btn'>"
			str+=                   "<button class='btn btn-danger mmosolution-quantity-decrease' onclick='decrease("+GloNo+")' type='button'><i class='fa fa-minus'></i></button>"
			str+=            "</span>"
			str+=       "<span id='quantity"+GloNo+"'style='min-width:0;' name='quantity'>"+num+"</span>"
			str+=             "<span class='input-group-btn'>"
			str+=                  "<button class='btn btn-primary mmosolution-quantity-increas' onclick='increase("+GloNo+")' type='button'><i class='fa fa-plus'></i></button>"
			str+=             "</span>"
			str+=     "</div>"                
			str+="</div>"	
			str+="<span id='oneprice"+GloNo+"' style='display:none'>"+modalprice+"</span>"
			str+="</div></div></li>"

				
		$("#Sumprice").text($("#menu_price").text());
		$('#accordion-1 .item-1').collapse("show");
		$("#ul").append(str);
		
		}else{
			$.each($("div[class=card-body]").find('ul>li>div>div[id=ordername]'),function(i){
				ss=$(this).text()
				var str="";
				if(ss==name){
					flag=0
					count=i;
					return false;//break
				}else{
					flag=1;
					return true;//continue
				}
			});
			
			if(flag==0){
				quantityId="#quantity"+GloNo;

				//alert('같은거 있으니까 쓰지 마라')
				$.each($("div[class=card-body]").find('ul>li>div>div>div>div>span'),function(i){
				if(i==count){
					ordercnt=parseInt($(quantityId).text())+parseInt(num);//주문하기목록에 현재 주문한 총 개수
					$(quantityId).text(ordercnt)	
					
					sum=parseInt($(quantityId).text())*parseInt($(".modal-body #price").text())
					var priceId="#allprice"+GloNo
					$(priceId).text(sum)//각각의 주문한 것에 대한 합
					$("#Sumprice").text("0")
					
					var dd=0;
				$.each($("div[class=card-body]").find('ul>li>div>div>div>span'),function(i){
					var ss=$(this).text()
					dd=parseInt($(this).text())+dd;
					$("#Sumprice").text(dd)
					
					
				})
					
					$('#accordion-1 .item-1').collapse("show");
					
					return false//break
					}
				
				});

			}else if(flag==1){

				var str="";
				str+="<li class='list-group-item clearfix' id='menu"+GloNo+"'>"
					
					str+="<div class='row'>"
					str+="<div class='menu-name ng-binding' id='ordername'>"+name+"</div>"
					str+= "<div>"
						
					str+="<div class='col-xs-6 pull-left'>"
					str+=	"<span id='allprice"+GloNo+"'name='allprice' class='order-price ng-binding' >"+price+"</span>"
					str+="	<button type='button' class='btn pull-right' onclick='closes("+GloNo+")'>×</button>"
					str+="</div>"
					 str+="<div class=' mmosolution-quantity-container' style='width: 100%;'>"
					str+=   "<div class='input-group'>"
					str+=           "<span class='input-group-btn'>"
					str+=                   "<button class='btn btn-danger mmosolution-quantity-decrease' onclick='decrease("+GloNo+")' type='button'><i class='fa fa-minus'></i></button>"
					str+=            "</span>"
					str+=       "<span id='quantity"+GloNo+"'style='min-width:0;'name='quantity'>"+num+"</span>"
					str+=             "<span class='input-group-btn'>"
					str+=                  "<button class='btn btn-primary mmosolution-quantity-increas' onclick='increase("+GloNo+")' type='button'><i class='fa fa-plus'></i></button>"
					str+=             "</span>"
					str+=     "</div>"                
					str+="</div>"
					str+="<span id='oneprice"+GloNo+"' style='display:none'>"+modalprice+"</span>"
					str+="</div></div></li>"
			$("#ul").append(str);
			var modalpricesum=parseInt($("#menu_price").text())+parseInt($("#Sumprice").text())
			
			$("#Sumprice").text(modalpricesum);
				$('#accordion-1 .item-1').collapse("show");
			}
		}

		
		});


	$("#Order").on("click",function(){
		alert("b")
	})

	
	//모달 창에서의 감소
	$('#decreaseQuantity').click(function(e){
		e.preventDefault();
		var stat = $('#input-quantity').val();
		var num = Number(stat);
		num--;
		
		if(num<=0){
		alert('더이상 줄일수 없습니다.');
		num =1;
		}else{
			ss=GloPrice
			$('#input-quantity').val(num)
			s1=$('#input-quantity').val(num);
			mstr="";
			price=parseInt(ss)*parseInt($('#input-quantity').val())
			mstr+=String(price);
			$("#menu_price").text(mstr);
			
			
		}
		
	});

	//모달 창에서의 증가
		$('#increaseQuantity').click(function(e){
			e.preventDefault();
			
			var stat = $('#input-quantity').val();
			var num = Number(stat);
			num++;
			
			if(num>100){
			alert('더이상 늘릴수 없습니다.');
			}else{
				$('#input-quantity').val(num)
				ss=GloPrice//현재 가격
				s1=$('#input-quantity').val(num);
				mstr="";
				price=parseInt(ss)*parseInt($('#input-quantity').val())
				mstr+=String(price);
				$("#menu_price").text(mstr);
			}

			});
		
	
		//주문하기 버튼 클릭 이벤트
		$('#btnOrder').on("click",function(){
			if($("#ordername").length==0){
				alert("주문할 목록이 없습니다.")
			}else{

				
				if($("#user_id").val()==""&&$("#master_id").val()==""){
					alert("로그인을 하세요")
				}else{
				var ss="";
				if($("#ul li").length != 0){
				    for(var i=0; i<$("#ul li").length; i++){
				     var price=  $("#ul li span[id*=allprice]").eq(i).text();//각각의 구매가격
				    var name= $("#ul li div[id=ordername]").eq(i).text();//구매한 음식 이름
				    var cnt= $("#ul li span[name=quantity]").eq(i).text();//수량
				    ss+=price+','+name+','+cnt+"/";
				    
				    }
				}else {data.addList = "";}
				
				
					$('#orderinput').val(ss);
					$('#Sumpriceinput').val($("#Sumprice").text());
					$('#Orderdata').submit();
				}

				
				
			}
			
			
		});
	
});


//메뉴 띄우는 function(ajax success)
function successFunction(data){

	$("#divReview").hide()
	$("#divMenu").slideToggle('slow')
	var rowprice=$("#rowprice").val()
	var str="";
	 $(data.category_menu_detail).each(function(idx,objArr){
		 
		 str+="<div class = 'col-md-4'>"
		 str+="<div class='card' style='width: 100%'>"
		 str+="<a data-toggle='modal' data-target='#modal-testNew' " +
		 		"data-price='"+objArr["menu_price"]+"'" +
		 		" data-name='"+objArr["menu_name"]+"'" +
		 		" data-image='"+objArr["menu_image"]+"'" +
		 		" data-no='"+objArr["menu_no"]+"'" +
		 		" data-rowprice='"+rowprice+"'" +
		 		" data-backdrop='static'> "
		 str+= "<img src='/img/upload/"+objArr["menu_image"]+"'" +
				" style='width:100%; height:250px; align:center;' " +
				" m class='card-img-top'"+
		 " alt='...'>"
		 str+="<ul class='list-group list-group-flush'>"
		 str+="<li class='list-group-item'>이름 :"+objArr["menu_name"]+"</li>"
		 str+="<li class='list-group-item'>가격 :"+objArr["menu_price"]+"</li>"
		 str+="<li class='list-group-item'>내용:"+objArr["menu_content"]+"</li>"
		 str+="</ul>"
		 str+="</div></a></div>"
	 });
	$("#divMenu").html(str);



}


//메뉴 띄우는 function(ajax fail)
function failFunction(data){

	if(data.result !='success')

		var a = "함수호출 fail";		

	return alert(a);

}

//주문목록 내부의 감소 function
function decrease(no){


id="#quantity"+no;//증가되는 숫자의 id
var priceId="#oneprice"+no//각각의 가격 합id
var allpriceId="#allprice"+no//증가되는 가격의 id

var stat = $(id).text();
var num = Number(stat);
num--;

if(num<=0){
alert('더이상 줄일수 없습니다.');
num =1;
}else{
	$(id).text(num)
	var sum=parseInt($(priceId).text())*parseInt($(id).text())
	$(allpriceId).text(sum)
	var sum=0
	$.each($("div[class=card-body]").find('ul>li>div>div>div>span'),function(i){
				
					sum=parseInt($(this).text())+sum;
					$("#Sumprice").text(sum)
				})
}





}
//주문목록 내부의 증가 function
function increase(no){
	
	id="#quantity"+no;//증가되는 숫자의 id
	var priceId="#oneprice"+no//각각의 가격 합id
	var allpriceId="#allprice"+no//증가되는 가격의 id

	var stat = $(id).text();
	var num = Number(stat);
	num++;

	if(num>100){
	alert('더이상 늘릴수 없습니다.');
	}else{
		$(id).text(num)
		var sum=parseInt($(priceId).text())*parseInt($(id).text())
		$(allpriceId).text(sum)
	
	var sum=0
	$.each($("div[class=card-body]").find('ul>li>div>div>div>span'),function(i){

		sum=parseInt($(this).text())+sum;
		$("#Sumprice").text(sum)
	})
	}
}

//주문목록 내부의 취소 function
function closes(no2){
	id="#menu"+String(no2)
	$(id).remove();
	var sum=0
	if($("#ordername").length==0){
		$("#Sumprice").text("0")
		$('#accordion-1 .item-1').collapse("hide");
	}else{
		$.each($("div[class=card-body]").find('ul>li>div>div>div>span'),function(i){
			
			sum=parseInt($(this).text())+sum;
			$("#Sumprice").text(sum)
		})
	}

}
		