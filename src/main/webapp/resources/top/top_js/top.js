$(document).ready(function() {
	// top_menubar에서 로그인 버튼
	$("#btn_Loginhandler").on("click", function() {
		location.href = "login";
	});
	// top_menubar에서 로그아웃
	$("#btn_Logout").on("click", function() {
		location.href = "logout";
	});

	// top-menubar 회원가입(MainMenu_CategoryController)
	$("#btn_Sign_Up").on("click", function() {
		location.href = "sign_up"
	});
	//로그인 후 점주 메뉴등록
	$("#btn_Insert_Menu").on("click", function() {
		location.href = "insert_menu";
	});
	//로그인 후 점주 가게등록
	$("#btn_Market_Create").on("click", function() {
		location.href = "market_create";
	});
});