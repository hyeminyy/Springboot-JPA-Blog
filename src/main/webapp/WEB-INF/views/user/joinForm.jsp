<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp" %>

<style>
    body {
        background-color: #eaf2d7;
        
    }

    .container {
        margin-top: 50px;
         margin-bottom: 50px;
    }

    .form-container {
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0px 0px 20px 0px rgba(0, 0, 0, 0.2);
        padding: 40px;
        text-align: center;
        max-width: 400px;
        margin: 0 auto;
    }

    .form-container h2 {
        margin-bottom: 30px;
    }

    .form-group {
        margin-bottom: 25px;
        position: relative;
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

    .btn-save {
        background-color: #D2E5A8;
        color: #ffffff;
        border: none;
        border-radius: 5px;
        padding: 15px 20px;
        cursor: pointer;
        font-size: 18px;
        transition: background-color 0.3s;
    }

    .btn-save:hover {
        background-color: #C0D396;
    }

    .btn-save:active {
        background-color: #003366;
        
    }
</style>

<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="form-container">
                <h2>회원가입</h2>
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="사용자명">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="비밀번호">
                </div>
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="이메일">
                </div>
                <button id="btn-save" class="btn btn-save btn-block">회원가입 완료</button>
            </div>
        </div>
    </div>
</div>

<%@ include file="../layout/footer.jsp" %>
<script src="/js/user.js"></script>
