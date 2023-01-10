<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>update</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/login_update/login_update_css/Login-Form-Clean.css">
    <link rel="stylesheet" href="resources/login_update/login_update_css/Registration-Form-with-Photo.css">
    <link rel="stylesheet" href="resources/login_update/login_update_css/css/styles.css">
</head>

<body>
    <div></div>
    <div class="container">
        <div class="row">
            <div class="col text-center col-4">
                <ul class="list-group">
                    <li class="list-group-item"><a href="#">주문내역</a></li>
                    <li class="list-group-item"><a href="#">이용내역</a></li>
                    <li class="list-group-item"><a href="#">회원정보 수정</a></li>
                    <li class="list-group-item"><a href="#">비밀번호 변경</a></li>
                </ul>
            </div>
            <div class="col col-8">
                <form>
                    <div class="form-group"><input class="form-control" type="text" id="Update_name" name="Update_name" placeholder="이름(ex:홍길동)"></div>
                    <div class="form-group"><input class="form-control" type="tel" id="Update_phone" name="Update_phone" placeholder="휴대폰 번호 (ex:010-111-1111)"></div>
                    <div class="form-group"><input class="form-control" type="text" id="Update_address" name="Update_address" placeholder="주소"></div>
                    <div class="form-group"><input class="form-control" type="password" id="Update_pwd" placeholder="비밀번호를 입력해주세요" name="Update_pwd"></div>
                    <div class="form-group">
                        <div class="form-row">
                            <div class="col"><button class="btn btn-primary btn-block" type="submit" style="background-color: #18c2d9; border:none;">확인</button></div>
                            <div class="col"><button class="btn btn-primary btn-block" type="submit" style="background-color: #18c2d9;padding: 6px; border:none;">취소</button></div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script src="resources/bootstrap/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>