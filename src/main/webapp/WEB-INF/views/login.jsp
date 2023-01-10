<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    
    <title>로그인</title>
    
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/login/login_fonts/ionicons.min.css">
    <link rel="stylesheet" href="resources/login/login_css/Login-Form-Clean.css">
    <link rel="stylesheet" href="resources/login/login_css/styles.css">
</head>

<body>
    <div class="login-clean">
        <form action="login" id="login" method="post">
            <h2 class="sr-only">Login Form</h2>
            <div class="illustration"><i class="icon ion-log-in"></i></div>
            <div class="form-group"><input class="form-control" type="email" id="login_id" name="email" placeholder="아이디"></div>
            <div class="form-group"><input class="form-control" type="password" id="login_password" name="password" placeholder="비밀번호"></div>
            <div class="form-group"><button class="btn btn-primary btn-block" id="btn_Login" type="button">로그인</button><button class="btn btn-primary btn-block" id="btn_Cancel" type="button">취소</button></div><a id="search_id" class="forgot" href="#">아이디 찾기</a><a id="search_password"
                class="forgot" href="#">비밀번호 찾기</a><a id="sign_up" class="forgot" href="#">회원가입</a>
                </form>
    </div>
    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/login/login_js/login.js"></script>
</body>
</html>