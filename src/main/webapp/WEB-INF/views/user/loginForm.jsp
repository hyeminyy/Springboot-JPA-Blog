<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

<style>
    body {
        background-color: #eaf2d7;
        font-family: Arial, sans-serif;
    }

    .container {
        margin-top: 50px;
        margin-bottom: 50px;
        max-width: 400px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.2);
        padding: 40px;
        text-align: center;
    }

    .form-group {
        margin-bottom: 20px;
    }

    .form-control {
        width: calc(100% - 20px);
        padding: 15px 10px;
        font-size: 16px;
        border: 1px solid #ced4da;
        border-radius: 5px;
        margin-bottom: 10px;
        display: inline-block;
    }

    .form-control:focus {
        border-color: #007bff;
    }

    .btn-login {
        background-color: #D2E5A8;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        padding: 15px 20px;
        font-size: 18px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .btn-login:hover {
        background-color: #C0D396;
    }

    .btn-login:active {
        background-color: #003366;
    }

    .btn-signup {
        color: #007bff;
        text-decoration: underline;
        cursor: pointer;
        transition: color 0.3s;
    }

    .btn-signup:hover {
        color: #0056b3;
    }
</style>

<div class="container">
    <h2>로그인</h2>
    <form action="/auth/loginProc" method="post">
        <div class="form-group">
            <input type="text" name="username" class="form-control" placeholder="사용자명">
        </div>

        <div class="form-group">
            <input type="password" name="password" class="form-control" placeholder="비밀번호">
        </div>

        <button id="btn-login" class="btn btn-login btn-block">로그인</button>
    </form>

    <div class="mt-3">
        <p>계정이 없으신가요? <a href="/auth/joinForm" class="btn-signup">회원가입</a></p>
    </div>
</div>

<%@include file="../layout/footer.jsp" %>
