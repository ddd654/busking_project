<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="../resources/css/bootstrap.min.css">
    <script src="../resources/js/jquery-3.7.1.min.js"></script>
    <script src="../resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../resources/css/mypage/findIdPw.css">
    <link rel="stylesheet" href="../resources/css/headerfooter/default_main.css">
    <link rel="stylesheet" href="../resources/css/headerfooter/main.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@24,400,0,0" />



<body>
    
    <div class="jinseok-wrap">
        <div class="findidpw-wrap">
            <div class="login-wrap-border">
                <p>아이디 찾기</p>
                <form class="findid">
                    <label for="email">이메일</label>
                    <div class="form-group">
                        <input type="text" class="form-control" id="email" value="" placeholder="가입하신 이메일을 입력하세요.">
                    </div>
                    <label for="phone-num">연락처</label>
                    <div class="form-group">
                        <input type="text" class="form-control" id="usr" value="" placeholder="가입하신 연락처를 입력하세요.">
                    </div>
                    
                    <input type="button" class="jinseok-button" value="아이디 찾기"></input>
                    <div class="form-group" style="margin-top: 15px;">
                        <input readonly type="text" class="form-control" id="email" value="" placeholder="아이디 나오는 칸">
                    </div>
                </form>
            
            </div>
            <p style="margin-top: 35px;">비밀번호 찾기</p>
            <form class="findpw">
                <label for="id">아이디</label>
                <div class="form-group">
                    <input type="text" class="form-control" id="id" value="" placeholder="가입하신 아이디를 입력하세요.">
                </div>
                <label for="phone-num">연락처</label>
                <div class="form-group">
                    <input type="text" class="form-control" id="usr" value="" placeholder="가입하신 연락처를 입력하세요.">
                </div>
                
                <input type="button" class="jinseok-button" value="비밀번호 찾기"></input>
                <div class="form-group" style="margin-top: 15px;">
                    <input readonly type="text" class="form-control" id="email" value="" placeholder="비밀번호 나오는 칸">
                </div>
            </form>

        </div>
    </div>

</body>
</html>