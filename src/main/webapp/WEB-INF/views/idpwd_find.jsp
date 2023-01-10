<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>아이디 비밀번호 찾기</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/idpwd_find/idpwd_find_css/ensign-form-1.css">
    <link rel="stylesheet" href="resources/idpwd_find/idpwd_find_css/ensign-form.css">
    <link rel="stylesheet" href="resources/idpwd_find/idpwd_find_css/styles.css">
</head>

<body class="text-center" style="margin-right: 0px;margin-left: 0px;">
    <div class="row text-center" style="width: 1300px;margin-left: 15%;margin-top: 25%;margin-right: 15%;margin-bottom: 25%;">
        <div class="col-md-5" style="margin-right: 100px;">
            <form action="Id_find" id="Id_find"method="POST"><label style="margin-top: 40px;font-size: 30px;">아이디 찾기</label><input class="form-control" type="text" name="IdFind_Name" id="IdFind_Name" style="margin-top: 40px;height: 50px;" placeholder="이름"><input class="form-control" type="text" name="IdFind_Phone" id="IdFind_Phone" style="margin-top: 40px;margin-bottom: 40px;height: 50px;"
                    placeholder="폰번호"></form><button class="btn btn-primary" id ="btnId_Ok" type="button" style="margin-right: 200px;background-color: #18c2d9;">확인</button><button class="btn btn-primary" id="btnId_Cancel" type="button" style="background-color: #18c2d9;">취소</button></div>
       
        <div style="border:1px solid"></div>
        <div></div>
        <span>${sel_id}</span>
        <div
            class="col-md-5" style="margin-left: 100px;">
            <form action="Pwd_find" id="Pwd_find" style="width: 500px;" method="POST"><label style="margin-top: 40px;font-size: 30px;">비밀번호 찾기</label><input class="form-control" type="text" name="PwdFind_Id" id="PwdFind_Id" style="margin-top: 40px;height: 50px;width: 520px;" placeholder="아이디"><input class="form-control" type="text" style="margin-top: 40px;margin-bottom: 40px;height: 50px;width: 520px;"
                    placeholder="이름" name="PwdFind_Name" id="PwdFind_Name"><button class="btn btn-primary" id ="btnPwd_Ok" type="button" style="margin-right: 200px;background-color: #18c2d9;">확인</button><button class="btn btn-primary" id ="btnPwd_Cancel" type="button" style="background-color: #18c2d9;">취소</button></form>
    </div>
    </div>
    <span>${sel_pwd}</span>
    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/idpwd_find/idpwd_find_js/idpwd_find.js"></script>
    
</body>
</html>