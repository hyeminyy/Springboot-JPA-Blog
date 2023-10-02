<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>
<style>
    body {
        background-color: #eaf2d7;
        font-family: Arial, sans-serif; 
    }

    .container {
        margin: 20px auto;
        padding: 20px;
        background-color: #ffffff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }

    .form-group {
        margin-bottom: 20px;
    }

    label {
        font-weight: bold;
        color: #333;
    }

    .form-control {
        width: 100%;
        padding: 10px;
        font-size: 16px;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-sizing: border-box;
    }

    .btn-primary {
        background-color: #D2E5A8;
        color: #fff;
        border: none;
        border-radius: 5px;
        padding: 10px 20px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    .btn-primary:hover {
        background-color: #C0D396;
    }
</style>

<div class="container">
<form>
<input type="hidden" id="id" value="${principal.user.id}"/>
  <div class="form-group">
  
    <label for="username">Username</label>
    <input type="text" value="${principal.user.username}" class="form-control" placeholder="Enter username" id="username" readonly>
  </div>
  
   <div class="form-group">
   	 <label for="password">Password</label>
   	 
  	  <input type="password" class="form-control" placeholder="Enter password" id="password">
  </div>
  
   <div class="form-group">
    	<label for="email">Email</label>
   	 <input type="email" value="${principal.user.email}" class="form-control" placeholder="Enter email" id="email">
  </div>
 
</form>
  <button id = "btn-update" class="btn btn-primary">회원수정 완료</button>


</div>
<script src ="/js/user.js"></script>
<%@include file="../layout/footer.jsp" %>
