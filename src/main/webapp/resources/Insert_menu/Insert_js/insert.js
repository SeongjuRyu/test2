$(document).ready(function() {
	
	$("#Insert_menu_img").on("change", handleImgFileSelect);
	//취소버튼
	$("#btn_Insertcancel").on("click", function() {
		location.href = "Insertcancel";
	});



});