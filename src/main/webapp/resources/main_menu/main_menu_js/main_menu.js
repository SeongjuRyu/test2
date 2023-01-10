$(document).ready(function() {
	
		$.ajax({
		type:"get",
		url:"MainMenu_Category",
		dataType:"json",
		success:function(data){
			idx_start=0;
			idx_end=0;
			flag=0;
			var str = "<div class='team-grid'>" +
						"<div class='container'>" +
							"<div class='row people'>";
					str +="<tbody>";
					str +="<tr>";
					str +="<td>" +
							"<div class='col-md-4 col-lg-3 item'>" +
							"<a href='javascript:category_value(0)'>"+
								"<div class='box' " +
								"style='background-image:url(&quot;resources/main_menu/main_menu_img/all.png&quot;);'>" +
										"<div class='cover'>" +
											"<h3 class='name'>전체</h3>" +
										"</div>" +
								 "</div>" +
							"</a>"+
							"</div>" +
						 "</td>";
										
					str +="</tr>";
					str+="</tbody>";

			$(data.categories).each(function(idx,objArr){
				
				if(idx>=0 && idx<=2){
					str +="<tbody>";
					str +="<tr>";
					str +="<td>" +
								"<div class='col-md-4 col-lg-3 item'>" +
								"<a href='javascript:category_value("+objArr["category_no"]+")'>"+
									"<div class='box' " +
									"style='background-image:url(&quot;resources/main_menu/main_menu_img/" + objArr["category_image"]+"&quot;);'>" + 
											"<div class='cover'>" +
												"<h3 class='name'>" + objArr["category_name"] + "</h3>" +
											"</div>" +
									 "</div>" +
								"</a>"+
								"</div>"+

						"</td>";
					str +="</tr>";
					str+="</tbody>";
					if(idx==2)
					{
						str += "</div></div></div>";
						}
				} 
				else if(idx>=3 && idx<=(data.categories.length-1)){
					
					
					if(idx==3&&flag==0){
						idx_start=idx;
						idx_end=idx+3;
						
											
						str += "<div class='team-grid'>" +
									"<div class='container'>" +
										"<div class='row people'>";	
						
						str +="<tbody>";
						str +="<tr>";
						str +="<td>" +
									"<div class='col-md-4 col-lg-3 item'>" +
									"<a href='javascript:category_value("+objArr["category_no"]+")'>"+
										"<div class='box' " +
										"style='background-image:url(&quot;resources/main_menu/main_menu_img/" + objArr["category_image"]+"&quot;);'>" + 
												"<div class='cover'>" +
													"<h3 class='name'>" + objArr["category_name"] + "</h3>" +
												"</div>" +
										 "</div>" +
									"</a>"+
									"</div>"+
							"</td>";
						str +="</tr>";
						str+="</tbody>";
						
					}else if(idx>3&&flag==1){
						flag=0;
						idx_start+=4;
						
						str += "<div class='team-grid'>" +
									"<div class='container'>" +
										"<div class='row people'>";	
						
						str +="<tbody>";
						str +="<tr>";
						str +="<td>" +
									"<div class='col-md-4 col-lg-3 item'>" +
									"<a href='javascript:category_value("+objArr["category_no"]+")'>"+
										"<div class='box' " +
										"style='background-image:url(&quot;resources/main_menu/main_menu_img/" + objArr["category_image"]+"&quot;);'>" + 
												"<div class='cover'>" +
													"<h3 class='name'>" + objArr["category_name"] + "</h3>" +
												"</div>" +
										 "</div>" +
									"</div>"+
									"</a>"+
							"</td>";
						str +="</tr>";
						str+="</tbody>";
					}else if(idx>3&&flag==0)
					{
						str +="<tbody>";
						str +="<tr>";
						str +="<td>" +
									"<div class='col-md-4 col-lg-3 item'>" +
									"<a href='javascript:category_value("+objArr["category_no"]+")'>"+
										"<div class='box' " +
										"style='background-image:url(&quot;resources/main_menu/main_menu_img/" + objArr["category_image"]+"&quot;);'>" + 
												"<div class='cover'>" +
													"<h3 class='name'>" + objArr["category_name"] + "</h3>" +
												"</div>" +
										 "</div>" +
									"</div>"+
									"</a>"+
							"</td>";
						str +="</tr>";
						str+="</tbody>";
					}


				
				if(idx==idx_end){
						flag=1;
						idx_end+=4
						
						str += "</div></div></div>";
						
					}else if (idx==(data.categories.length-1)){
					
					str += "</div></div></div>";
					}
				}
			});
			
			

			$("#MainMenuCategory_ShowData").html(str);
		},
		error:function(){
			$("#MainMenuCategory_ShowData").text("에러 발생");
		}
			})
		})
		
function category_value(value){
   location.href="category_handler?value="+value
}