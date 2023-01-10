<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>회원가입</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/signup/signup_css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="resources/signup/signup_css/styles.css">
    
</head>

<body>
    <div class="register-photo">
        <div class="form-container">
            <form action="Sign_up_submit" id="Sign_up" method="post">
                <h2 class="text-center"><strong>&nbsp;회원가입</strong></h2>
                <div class="form-group"><input class="form-control" type="email" id="sign_email" name="email" placeholder="(필수)이메일 주소 입력"></div>
                <div class="form-group"><span id="chkMsg"></span></div>
                <div class="form-group"><input class="form-control" type="password" id="sign_password" name="password" placeholder="(필수)비밀번호 입력"></div>
                <div class="form-group"><input class="form-control" type="password" id="sign_repassword" placeholder="(필수)비밀번호 재확인"></div>
                <div class="form-group"><span id="chkPwdMsg"></span></div>
                <div class="form-group"><input class="form-control" type="text" id="sign_name" name="name" placeholder="(필수)이름 입력 "></div>
                <div class="form-group"><input class="form-control" type="tel" id="sign_phone" maxlength="11" name="" placeholder="(필수)핸드폰 번호 입력"></div>
                <input type="hidden" id="sign_address" name="sign_address"/>
                <div class="form-group"><input class="form-control" type="text" id="postcode" name="postcode" placeholder="우편번호"></div>                
                <div class="form-group"><input type="button" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br></div>
                <div class="form-group"><input class="form-control" type="text" id="address" name=address placeholder="주소"><br></div>
                <div class="form-group"><input class="form-control" type="text" id="detailAddress" name=detailAddress placeholder="상세주소"></div>
                <div class="form-group"><input class="form-control"type="text" id="extraAddress" name=extraAddress placeholder="참고항목"></div>
                
                <div class="form-group">
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" name="sign_select" type="checkbox" value="0">고객</label></div>
                    <div class="form-check"><label class="form-check-label"><input class="form-check-input" name="sign_select" type="checkbox" value="1">점주</label></div>
                </div>
                <div class="form-group"><button class="btn btn-primary btn-block" id="sign_up" type="button">회원가입</button><button class="btn btn-primary btn-block" id="sign_cancel" type="button">취소</button></div><a class="already" href="#">You already have an account? Login here.</a></form>
        </div>
    </div>
    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/signup/signup_js/signup.js"></script>
    <script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
    <script src="resources/signup/signup_js/addressAPI.js"></script>
</body>
</html>